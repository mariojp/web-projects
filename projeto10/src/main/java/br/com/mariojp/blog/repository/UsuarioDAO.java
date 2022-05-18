package br.com.mariojp.blog.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.mariojp.blog.model.Usuario;
import br.com.mariojp.blog.util.Database;

public class UsuarioDAO {
	
	/**
	 * Obter a lista
	 * @return
	 */
	public List<Usuario> findAll(){
		List<Usuario> usuarios = null;
		try (Statement statement =  Database.getInstance().getConnection().createStatement()){
			ResultSet resultSet = statement.executeQuery("SELECT ID, LOGIN, PASSWORD FROM USUARIOS");
			usuarios = new ArrayList<Usuario>();
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("ID"));
				usuario.setLogin(resultSet.getString("LOGIN"));
				usuario.setPassword(resultSet.getString("PASSWORD"));
				usuarios.add(usuario);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	/**
	 * Salvar ou atualizar
	 * @param usuario
	 * @return
	 */
	public Usuario save(Usuario usuario) {
		if(usuario.getId() == null ) { 
			inserir(usuario);
		}else {
			atualizar(usuario);
		}
		return usuario;
	}

	private void atualizar(Usuario usuario) {
		String query = "UPDATE USUARIOS SET LOGIN= ? ,PASSWORD = ? WHERE ID = ?";
		try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query)) {
		    statement.setString(1, usuario.getLogin());
		    statement.setString(2, usuario.getPassword());
		    statement.setInt(3, usuario.getId());
		    statement.executeUpdate();
		    statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void inserir(Usuario usuario) {
		String query = "INSERT INTO USUARIOS (LOGIN,PASSWORD) VALUES (?,?)";
		try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
		    statement.setString(1, usuario.getLogin());
		    statement.setString(2, usuario.getPassword());
		    if(statement.executeUpdate() > 0) {
		    	ResultSet keys = statement.getGeneratedKeys();
		    	if(keys.next()) {
		    		usuario.setId(keys.getInt(1));
		    	}
		    }
		    statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Buscar pelo login
	 * 
	 * @param login
	 * @return
	 */
	public Optional<Usuario> findByLogin(String login) {
		Usuario usuario = null;
		String query = "SELECT ID, LOGIN, PASSWORD FROM USUARIOS WHERE LOGIN = ?";
		try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query)){
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt("ID"));
				usuario.setLogin(resultSet.getString("LOGIN"));
				usuario.setPassword(resultSet.getString("PASSWORD"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.ofNullable(usuario);
	}
	
	
	/**
	 * Excluir pelo login
	 * 
	 * @param login
	 * @return
	 */
	public void delete(Integer id) {
		String query = "DELETE FROM USUARIOS WHERE ID = ?";
		try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query)){
			statement.setInt(1, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario findById(Integer id) {
		Usuario usuario = null;
		String query = "SELECT ID, LOGIN, PASSWORD FROM USUARIOS WHERE ID = ?";
		try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query)){
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt("ID"));
				usuario.setLogin(resultSet.getString("LOGIN"));
				usuario.setPassword(resultSet.getString("PASSWORD"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	
	

}
