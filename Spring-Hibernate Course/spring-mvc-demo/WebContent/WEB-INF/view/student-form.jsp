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
	
	<br> <br>
	
	Country: 
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>	
	</form:select>
	
	<br> <br>
	Favorite Language:
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C#   <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP  <form:radiobutton path="favoriteLanguage" value="PHP" />
		RUBY <form:radiobutton path="favoriteLanguage" value="Ruby" />
		
	<br> <br>
	
	Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	
	</form:form>
</body>
</html>