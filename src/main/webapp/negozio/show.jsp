<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.model.Negozio"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					    
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Ragione Sociale:</dt>
							  <c:out value="${visualizza_negozio_attr.getRagioneSociale() }"/>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Partita IVA:</dt>
							  <c:out value="${visualizza_negozio_attr.getPartitaIva() }"/>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Fatturato:</dt>
							  <c:out value="${visualizza_negozio_attr.getFatturato() }"/>
					    	</dl>
					    	
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Apertura:</dt>
							  <fmt:formatDate value="${visualizza_negozio_attr.getDataApertura()}"  pattern="dd/MM/yyyy" var="dataapertura"/>
							  <c:out value="${dataapertura}"></c:out>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        <a href="results.jsp" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
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