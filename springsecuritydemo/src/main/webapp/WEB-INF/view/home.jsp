<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

	<head>
		<title>Home Page</title>
	</head>
	
	<body>
		<h2>Home Page</h2>
		<hr>
		
		<p>
			Hello World.
		</p>
		
		<hr>
		
		<!-- Display user name and role(s) -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>	
			
		<!-- Logout Button -->	
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout"/>
		</form:form>
		<hr>
	</body>

</html>