package br.com.mariojp.blog.controllers;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * 
 * Implementação de exemplo de um Servlet equivalente ao index.jsp
 * 
 * Acesso por http://localhost:8080/blog/index
 * 
 * @author mariojp
 *
 * @WebServlet - faz o mapeamento do recurso
 * 
 * Equivalente a adicionar o seguinte trecha no web.xml
 * 
 * <servlet>
 * 		<servlet-name>alias</servlet-name>
 * 		<servlet-class>br.com.mariojp.blog.IndexServlet</servlet-class>
 * </servlet> 
 * 
 * <servlet-mapping>
 * 		<servlet-name>alias</servlet-name>
 * 		<url-pattern>/index</url-pattern>
 * </servlet-mapping>
 *
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * 	doGet modificado para doPost agora esse servlet não respode a chamadas HTTP GET (Erro 405), apenas HTTP POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<meta charset=\"UTF-8\"/>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>OLÁ, ");
		
		String nome = request.getParameter("nome");		
		response.getWriter().append(nome);
		response.getWriter().append("!</h1>");
		
		Map<String, String[]> parametros = request.getParameterMap();
		for (Entry<String, String[]> item: parametros.entrySet()) {
			response.getWriter().append(item.getKey() +" = "+item.getValue()[0]);
			response.getWriter().append("<br>");			
		}

		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
						
		
	
	}
	
}
