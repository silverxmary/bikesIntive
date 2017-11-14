<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bike Rental - ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
 <%@include file="./shared/navbar.jsp" %>
    <!-- Page Content -->
		
<div class="container">
<h1>Checkout</h1>
<br/>
	<c:if test="${singlePack==true}">
		<div class="row">
			
			
			<p>You Selected - Pack ${nombre} -  and must pay  ${precio}</p>
		</div>
	</c:if>
	<c:if test="${famPack==true}">
		<div class="row">
		<p>Selected Packs:</p>
		<br/>
		</div>
		<div class="row">
		<table>
			<c:forEach items="${famPacksForm.bikePacksFam}" var="p" varStatus="loop">
				<tr>
					<td>Nombre PacK ${p.nombre}</td>
					<td>Precio - ${p.precio}</td>

				</tr>
			</c:forEach>
			</table>
			</div>
			<br/>
		<div class="row">
			<p>Precio total - ${precioFin}</p>
		</div>
		
	</c:if>
	

</div>

			
	
    <!-- /.container -->

    <!-- Footer -->
 <%@include file="./shared/footer.jsp" %>
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>

  </body>

</html>


