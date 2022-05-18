package br.com.mariojp.blog.controller;

import java.io.IOException;

import javax.security.auth.login.FailedLoginException;

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
 * Implementação de exemplo de um Servlet para login
 * 
 * 
 * @author mariojp
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");			
		requestDispatcher.forward(request, response);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("usuario");		
		String senha = request.getParameter("senha");		
				
		try {
			Usuario usuario = usuarioService.autenticar(login, senha);
			//ATRIBUTOS E PARAMETOS LIGADOS A REQUIÇÃO SÃO PERDIDOS QUANDO É CRIADA UMA NOVA REQUISIÇÃO
			//SE FAZ NECESSARIO O USAR O ESCOPO DE SESSÃO
			//ESSE ATRIBUTO É VALIDO ENQUANTO A SESSÃO ESTIVER VALIDA
			request.getSession().setAttribute("usuario", usuario);
			
			//REDIRECIONAMENTO
			//ENVIADO CODIGO 302 
			//O CLIENTE VAI EFETUAR UMA NOVA REQUISIÇÃO PARA dashboard.jsp
			response.sendRedirect(request.getContextPath()+"/autenticado/dashboard");
		}catch (FailedLoginException failedLoginException) {
			//DENTRO DE UMA MESMA REQUISIÇÃO É POSSIVEL USAR ATRIBUTOS NO ESCOPO DE REQUEST 
			//AO REPASSAR A REQUISIÇÃO O OUTRO SERVLET/JSP TERA ACESSO AO ATRIBUTO 
			request.setAttribute("erro", "is-invalid");
			//REPASSANDO A REQUISIÇÃO DE UMA SERVLET PARA OUTRO (DICA: JSP É UM SERVLET)
			//TUDO ACONTECE EM APENAS UMA REQUISIÇÃO
			this.doGet(request, response);
		}
				
	
	}
	
}
