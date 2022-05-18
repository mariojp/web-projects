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
	<main class="container mt-5">


		<h1>FORMULARIO DE USUARIO</h1>

		<form action="/blog/autenticado/usuario/salvar" method="post">
			<input type="hidden" name="id" value="${model.id}" /> 
			<div class="mb-3">
				<label for="login" class="form-label">Usuario</label> <input
					name="login" type="text" class="form-control" id="login" value="${model.login}" >

			</div>
			<div class="mb-3">
				<label for="senha" class="form-label">Senha</label> <input
					name="senha" type="password" class="form-control" id="senha" value="${model.password}">
			</div>
			<button class="btn btn-primary" type="submit">SALVAR</button>
		</form>
	</main>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>
