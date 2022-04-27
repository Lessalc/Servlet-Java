<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, gerenciador.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>

	<p>Usuario logado: ${usuarioLogado.login}</p>

	<c:if test="${not empty empresa}">
		<h3> Empresa ${empresa} cadastrada!</h3>
		<p>CNPJ: ${cnpj}</p>
		<p>Data Abertura: <fmt:formatDate value="${data }" pattern="dd/MM/yyyy"/> </p>
	</c:if>

<h1>Empresas Cadastradas</h1>

<ul>
	<c:forEach items="${ empresas }" var="empresa">
		
		<li>
		${ empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
		<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
		<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>
		</li>
	</c:forEach>
	
</ul>

<br><br>
<a href="/gerenciador/entrada?acao=NovaEmpresaForm"><input type="submit" value="Inserir Empresa"/></a>



</body>
</html>