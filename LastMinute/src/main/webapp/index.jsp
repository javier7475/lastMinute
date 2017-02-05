<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	Form just for test purposes
	<form action="rest/flightSearch/search" method="GET">
		Origin <input type="text" name="origin" value="AMS"><br>
		Destination <input type="text" name="destination" value="FRA"><br>
		Departure date <input type="text" name="departureDate"
			value="01/01/2019"><br> Number of adults <input
			type="text" name="adults" value="1"><br> Number of
		children <input type="text" name="children"><br> Number
		of infants <input type="text" name="infants"><br> <input
			type="submit">
	</form>
</body>

</html>
