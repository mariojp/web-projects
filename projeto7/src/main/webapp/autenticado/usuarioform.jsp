<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>


	<h1>FORMULARIO DE USUARIO</h1>

	<form action="/blog/autenticado/usuario/salvar" method="post">
		<input type="hidden" name="login" value="${model.login}" /> Usuario:
		<input name="usuario" type="text" value="${model.login}" /><br>
		Senha: <input name="senha" type="password" value="${model.password}" /><br>
		<button type="submit">SALVAR</button>
	</form>

</body>
</html>
