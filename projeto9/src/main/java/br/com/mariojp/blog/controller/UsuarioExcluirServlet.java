package br.com.mariojp.blog.controller;

import java.io.IOException;

import br.com.mariojp.blog.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/autenticado/usuario/excluir")
public class UsuarioExcluirServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioService();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		usuarioService.excluir(Integer.parseInt(id));
		
		response.sendRedirect(request.getContextPath()+"/autenticado/usuario/listar");
	}
	
}
