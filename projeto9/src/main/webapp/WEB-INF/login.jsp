<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>

	<form action='<c:url value="/login" />' method="post">
		Usuario: <input name="usuario" type="text" /><br>
		Senha: <input name="senha" type="password" /><br>
		<span style="color: red;">${erro}</span><br>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>
