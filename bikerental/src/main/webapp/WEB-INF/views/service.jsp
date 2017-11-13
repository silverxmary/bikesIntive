	<div class="container">
			<div class="row">
			<h1>Selected Service - ${service}</h1>
			<hr/>
			</div>
			<div class="row">
			<p>This is a  price preview of selected service</p>
			</div>
		<form:form action="${contextRoot}/check" method="POST"  commandName="packForm">
			<form:input type="text" id="nombre" path="nombre" value="${service}"/>
			
			  How long will you rent the bike
			  <form:input type="text" id="rentTime" path="rentTime" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
			 
			 
			<c:if test="${service=='1'}">
				Hours
			</c:if>
			<c:if test="${service=='2'}">
				Days
			</c:if>
			<c:if test="${service=='3'}">
				weeks
			</c:if>
			<button type="submit">Send</button>
	</form:form>
			
</div>
		
	

		