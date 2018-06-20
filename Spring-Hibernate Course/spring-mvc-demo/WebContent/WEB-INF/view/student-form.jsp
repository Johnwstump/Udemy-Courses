<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br> <br>
	
	Last name: <form:input path="lastName" />
	
	<input type="submit" value="Submit" />
	
	Country: 
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>	
		</form:select>
	</form:form>
</body>
</html>