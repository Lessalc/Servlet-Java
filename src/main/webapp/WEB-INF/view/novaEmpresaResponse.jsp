<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
	<c:import url="logout-parcial.jsp"/>

	<c:if test="${not empty empresa}">
		<h3> Empresa ${empresa} cadastrada!</h3>
		<p>CNPJ: ${cnpj}</p>
		<p>Data Abertura: <fmt:formatDate value="${data }" pattern="dd/MM/yyyy"/> </p>
	</c:if>
	
	<c:if test="${empty empresa}">
		<h3> Nenhuma empresa cadastrada!</h3>
	</c:if>
	

</body>
</html>