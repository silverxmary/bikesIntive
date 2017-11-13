	<div class="container">
			<div class="row">
			<h1>Selected Service - ${service}</h1>
			<hr/>
			</div>
			<div class="row">
			<p>This is a  price preview of selected service</p>
			</div>
		<form name="formFam" action="${contextRoot}/selectPacks" method="get">
			<input type="text" id="nombre" path="nombre" value="${service}"/>
			
				How many packs will you need
			   <select name="choose" path="choose" id="choose">
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			 
			<button type="submit">Send</button>
	<form>
			
</div>
		
	

		