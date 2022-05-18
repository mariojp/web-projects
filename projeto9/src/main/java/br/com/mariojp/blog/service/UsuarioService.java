package br.com.mariojp.blog.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.FailedLoginException;

import br.com.mariojp.blog.model.Usuario;
import br.com.mariojp.blog.repository.UsuarioDAO;

public class UsuarioService {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	public Usuario autenticar(String login, String senha) throws FailedLoginException {
		Optional<Usuario> usuario = usuarioDAO.findByLogin(login);
		if(usuario.isPresent() && usuario.get().getPassword().equals(senha)) {
			return usuario.get();
		}
		throw new FailedLoginException("suario ou Senha invalidos");
	}


	public List<Usuario> findAll() {
		return usuarioDAO.findAll();
	}


	public Usuario findByLogin(String login) {
		return usuarioDAO.findByLogin(login).get();
	}


	public void atualizar(Usuario usuario) {
		Optional<Usuario> u = usuarioDAO.findByLogin(usuario.getLogin());
		if(u.isEmpty() || u.get().getId().equals(usuario.getId())) {
			usuarioDAO.save(usuario);
		}
	}
	
	public void criar(Usuario usuario) {
		Optional<Usuario> u = usuarioDAO.findByLogin(usuario.getLogin());
		if(u.isEmpty()) { 
			usuarioDAO.save(usuario);
		}
	}


	public void excluir(Integer id) {
		usuarioDAO.delete(id);
	}


	public Usuario findById(Integer id) {
		return usuarioDAO.findById(id);
	}
	
	
	
	
	

}
