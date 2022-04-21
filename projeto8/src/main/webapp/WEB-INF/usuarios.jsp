<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>



	<h1>LISTA USUARIOS</h1>
	<a href="<c:url value="/autenticado/usuario" />">Novo Usuario</a><br>
	<table>
		<tr>
			<td>Login</td>
			<td>Senha</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var="usuario" items="${usuarios}">
			<tr>
				<td>${usuario.login}</td>
				<td>${usuario.password}</td>
				<td><a
					href="<c:url value="/autenticado/usuario" />?id=${usuario.id}">ALTERAR</a></td>
				<td>
					<c:url value="/autenticado/usuario/excluir" var="excluir"> 
						<c:param name="id" value="${usuario.id}" />
					</c:url> 
				<a href="${excluir}">EXCLUIR</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
