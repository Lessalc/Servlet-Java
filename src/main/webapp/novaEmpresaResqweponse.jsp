<%
//scriplet
String nomeEmpresa = (String) request.getAttribute("empresa");
String cnpjEmpresa = (String) request.getAttribute("cnpj");
System.out.println(nomeEmpresa);
System.out.println(cnpjEmpresa);
%>


<html>
	<body>
		<h3>Empresa <%= nomeEmpresa%> Cadastrada!</h3>
  		<p>CNPJ: <%= cnpjEmpresa%> </p>
	</body>
</html>