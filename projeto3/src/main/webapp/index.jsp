<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<%
		response.getWriter().append("<h1>OLÁ, ");
		String nome = request.getParameter("nome");		
		response.getWriter().append(nome);
		response.getWriter().append("!</h1>");
	%>
</body>
</html>
