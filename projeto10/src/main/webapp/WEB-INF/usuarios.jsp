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



		<h1>LISTA USUARIOS</h1>
		<a role="button" class="btn btn-primary"
			href="<c:url value="/autenticado/usuario" />">Novo Usuario</a><br>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Login</td>
					<td>Senha</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.login}</td>
						<td>${usuario.password}</td>
						<td><a
							href="<c:url value="/autenticado/usuario" />?id=${usuario.id}">ALTERAR</a></td>
						<td><c:url value="/autenticado/usuario/excluir" var="excluir">
								<c:param name="id" value="${usuario.id}" />
							</c:url> <a href="${excluir}">EXCLUIR</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>
