package br.com.mariojp.blog.controller;

import java.io.IOException;

import br.com.mariojp.blog.model.Usuario;
import br.com.mariojp.blog.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/autenticado/usuario/salvar")
public class UsuarioSalvarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioService();


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setPassword(senha);
		
		if(id != null && !id.isBlank()) {
			usuario.setId(Integer.parseInt(id));
			usuarioService.atualizar(usuario);
		
		}else
			usuarioService.criar(usuario);
		
		response.sendRedirect(request.getContextPath()+"/autenticado/usuario/listar");
		
	}
	
}
