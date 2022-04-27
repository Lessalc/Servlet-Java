<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresa </title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>

	<form action="${linkEntradaServlet}" method="post">
  		Nome: <input type="text" name="nome" value="${empresa.nome}"/> <br><br>
  		CNPJ: <input type="text" name="cnpj" value="${empresa.cnpj}"/> <br><br>
  		Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/> <br><br> 
  		<input type="hidden" name="id" value="${empresa.id}"/>
  		<input type="hidden" name="acao" value="AlteraEmpresa"/>
  		<input type="submit"/>
  	</form>
</body>
</html>