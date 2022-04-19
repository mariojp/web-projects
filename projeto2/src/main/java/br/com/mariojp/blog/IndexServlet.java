package br.com.mariojp.blog;

import java.io.IOException;

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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<meta charset=\"UTF-8\"/>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>ALÔ MUNDO SERVLET</h1>");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
						
		
	
	}
	
}
