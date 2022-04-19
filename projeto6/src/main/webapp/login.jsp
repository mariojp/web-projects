<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<form action="./login" method="post">
		Usuario: <input name="usuario" type="text" /><br>
		Senha: <input name="senha" type="text" /><br>
		<span style="color: red;">${erro}</span><br>
		<button type="submit">Enviar</button>

	</form>
</body>
</html>
