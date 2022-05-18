<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

</head>
<body>
	<main class="container mt-5 w-50 m-auto text-center">

		<form action='<c:url value="/login" />' method="post">
			<div class="form-floating mb-3">
				<input type="usuario" class="form-control ${erro}" id="usuario"
					name="usuario" placeholder="usuario"> <label for="usuario">Usuario</label>
			</div>
			<div class="form-floating mb-3">
				<input type="password" class="form-control ${erro}" id="senha" name="senha"
					placeholder="senha"> <label for="senha">Senha</label>
			</div>
			  <button class="w-100 btn btn-lg btn-primary" type="submit">Enviar</button>
		</form>
	</main>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>
