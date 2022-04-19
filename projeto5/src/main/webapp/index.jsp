<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>

	<!--  IMPRIMINDO A LISTA DE PARAMETRO NOME -->
	<h1>Imprinmindo parametro nome: ${param.nome}</h1>

	<!--  IMPRIMINDO A LISTA DE PARAMETRO QUE FOREM PASSADOS DINAMICAMENTE -->
	<c:forEach var="p" items="${paramValues}" >
    	${p.key} = ${p.value[0]} <br>
	</c:forEach>
  
</body>
</html>
