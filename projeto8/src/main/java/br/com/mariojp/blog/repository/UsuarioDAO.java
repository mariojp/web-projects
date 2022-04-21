package br.com.mariojp.blog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.mariojp.blog.model.Usuario;

public class UsuarioDAO {
	
	
	private static Map<Integer,Usuario> usuarios = new HashMap<Integer,Usuario>();
	
	private static AtomicInteger atomicInteger = new AtomicInteger();

	
	static {
		if(usuarios.isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setId(atomicInteger.getAndIncrement());
			usuario.setLogin("root");
			usuario.setPassword("1234");
			usuarios.put(usuario.getId(), usuario);
		}
	}
	
	/**
	 * Obter a lista
	 * @return
	 */
	public List<Usuario> findAll(){
		return usuarios.values().stream().collect(Collectors.toList());
	}
	
	/**
	 * Salvar ou atualizar
	 * @param usuario
	 * @return
	 */
	public Usuario save(Usuario usuario) {
		if(usuario.getId() == null ) {
			usuario.setId(atomicInteger.getAndIncrement());
		}			
		return usuarios.put(usuario.getId(), usuario); 	
	}
	
	/**
	 * Buscar pelo login
	 * 
	 * @param login
	 * @return
	 */
	public Optional<Usuario> findByLogin(String login) {
			return usuarios.values().stream().filter( u -> u.getLogin().equals(login)).findFirst();
	}
	
	
	/**
	 * Excluir pelo login
	 * 
	 * @param login
	 * @return
	 */
	public Usuario delete(Integer id) {
		return usuarios.remove(id);
	}

	public Usuario findById(Integer id) {
		return usuarios.get(id);
	}
	
	
	
	

}
