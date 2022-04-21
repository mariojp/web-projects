package br.com.mariojp.blog.controller;

import java.io.IOException;

import br.com.mariojp.blog.model.Usuario;
import br.com.mariojp.blog.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/autenticado/usuario")
public class UsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioService();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(id != null ) {
			Usuario usuario =  usuarioService.findById(Integer.parseInt(id));
			request.setAttribute("model", usuario);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/usuarioform.jsp");			
		requestDispatcher.forward(request, response);
	
	}
	
}
