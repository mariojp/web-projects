<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
   </head>
<body>


	<h1>DASHBOARD</h1>

	Bem vindo, ${usuario.login}!
	<br>
	
	<a href="/blog/autenticado/usuario/listar">Lista de Usuarios</a>
  
</body>
</html>
