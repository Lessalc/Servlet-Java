<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Empresa </title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>


	<form action="${linkEntradaServlet}" method="post">
  		
  		
  		Login: <input type="text" name="login""/> <br><br>
  		Senha: <input type="password" name="senha""/> <br><br>
  		<input type="hidden" name="acao" value="Login"/>
  		<input type="submit"/>
  	</form>
</body>
</html>