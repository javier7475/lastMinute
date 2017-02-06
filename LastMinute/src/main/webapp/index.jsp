<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	Form just for test purposes
	<form action="rest/flightSearch/search" method="GET">
		Origin <select name="origin">
			<option value="MAD">Madrid</option>
			<option value="BCN">Barcelona</option> 
			<option value="LHR">London</option>
			<option value="CDG">Paris</option>
			<option value="FRA">Frakfurt</option> 
			<option value="IST">Istanbul</option>
			<option value="AMS" selected>Amsterdam</option>
			<option value="FCO">Rome</option>
			<option value="CPH">Copenhagen</option>
			</select> 
			<br>
		Destination <select name="destination">
			<option value="MAD">Madrid</option>
			<option value="BCN">Barcelona</option> 
			<option value="LHR">London</option>
			<option value="CDG">Paris</option>
			<option value="FRA" selected>Frakfurt</option> 
			<option value="IST">Istanbul</option>
			<option value="AMS">Amsterdam</option>
			<option value="FCO">Rome</option>
			<option value="CPH">Copenhagen</option>
			</select> <br>
		Departure date <input type="text" name="departureDate"
			value="01/01/2019"><br> Number of adults <input
			type="text" name="adults" value="1"><br> Number of
		children <input type="text" name="children"><br> Number
		of infants <input type="text" name="infants"><br> <input
			type="submit">
	</form>
</body>

</html>
