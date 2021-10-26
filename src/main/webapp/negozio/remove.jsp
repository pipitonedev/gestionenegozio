<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.model.Negozio"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Elemento</title>
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
					        <h5>Visualizza dettaglio elemento da eliminare</h5>
					    </div>
					     <% Negozio negozioInPagina = (Negozio)request.getAttribute("remove_negozio_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Ragione Sociale:</dt>
							  <dd class="col-sm-9"><%=negozioInPagina.getRagioneSociale() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Partita Iva:</dt>
							  <dd class="col-sm-9"><%=negozioInPagina.getPartitaIva() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Fatturato:</dt>
							  <dd class="col-sm-9"><%=negozioInPagina.getFatturato() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Apertura:</dt>
							  <dd class="col-sm-9"><%=negozioInPagina.getDataApertura()!=null? new SimpleDateFormat("dd/MM/yyyy").format(negozioInPagina.getDataApertura()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					    	<form action="ExecuteRemoveNegozioServlet" method="post">
					    	<input type="hidden" name="idNegozio" value="<%=negozioInPagina.getId() %>">
						        
						        <button type="submit"  class='btn btn-outline-danger' style='width:80px'>Elimina</button>
						        <a href="ListNegoziServlet" class='btn btn-outline-secondary' style='width:80px'>
						            <i class='fa fa-chevron-left'></i> Back
						        </a>
					        </form>
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