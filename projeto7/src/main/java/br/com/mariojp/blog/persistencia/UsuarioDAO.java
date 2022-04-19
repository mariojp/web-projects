package br.com.mariojp.blog.persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mariojp.blog.model.Usuario;

public class UsuarioDAO {
	
	
	private static Map<String,Usuario> usuarios = new HashMap<String,Usuario>();
	
	
	
	/**
	 * Obter a lista
	 * @return
	 */
	public List<Usuario> findAll(){
		return usuarios.values().stream().toList();
	}
	
	/**
	 * Salvar ou atualizar
	 * @param usuario
	 * @return
	 */
	public Usuario save(Usuario usuario) {
		return 	usuarios.put(usuario.getLogin(), usuario);
	}
	
	/**
	 * Buscar pelo login
	 * 
	 * @param login
	 * @return
	 */
	public Usuario findByLogin(String login) {
			return usuarios.get(login);
	}
	
	
	/**
	 * Excluir pelo login
	 * 
	 * @param login
	 * @return
	 */
	public Usuario delete(String login) {
		return usuarios.remove(login);
	}
	
	
	
	

}
