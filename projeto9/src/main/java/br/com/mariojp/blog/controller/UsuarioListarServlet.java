package br.com.mariojp.blog.controller;

import java.io.IOException;
import java.util.List;

import br.com.mariojp.blog.model.Usuario;
import br.com.mariojp.blog.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet("/autenticado/usuario/listar")
public class UsuarioListarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioService();

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Usuario> lista =  usuarioService.findAll();
		
		request.setAttribute("usuarios", lista);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");			
		requestDispatcher.forward(request, response);
	
	}
	
}
