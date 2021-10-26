<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.model.Negozio"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Inserisci Nuovo Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci nuovo elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertNegozioServlet" class="row g-3" novalidate="novalidate">
							
								<% Negozio negozioInPagina = (Negozio)request.getAttribute("insert_negozio_attr"); %>
							
								<div class="col-md-6">
									<label for="ragioneSociale" class="form-label">Ragione Sociale <span class="text-danger">*</span></label>
									<input type="text" name="ragioneSociale" id="ragioneSociale" class="form-control" placeholder="Inserire la ragione Sociale"  
										value="<%=negozioInPagina.getRagioneSociale()!=null?negozioInPagina.getRagioneSociale():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="partitaIva" class="form-label">Partita Iva <span class="text-danger">*</span></label>
									<input type="text" name="partitaIva" id="partitaIva" class="form-control" placeholder="Inserire la partita Iva"  
										value="<%=negozioInPagina.getPartitaIva()!=null?negozioInPagina.getPartitaIva():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="fatturato" class="form-label">Fatturato <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="fatturato" id="fatturato" placeholder="Inserire fatturato" 
									value="<%=negozioInPagina.getFatturato()!=null?negozioInPagina.getFatturato():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataApertura" class="form-label">Data di Apertura<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataApertura" id="dataApertura" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=negozioInPagina.getDataApertura()!=null? new SimpleDateFormat("yyyy-MM-dd").format(negozioInPagina.getDataApertura()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>