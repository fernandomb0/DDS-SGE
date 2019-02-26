package ar.com.sge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.sge.dto.UsuarioDTO;
import ar.com.sge.model.User;
import ar.com.sge.repository.UsuarioRepository;

/**
 * Implementacion del servicio de usuario. Es importante indicar la anotation
 * @Service para que spring lo detecte como un bean a generar en su contexto.
 * @author Fernando
 *
 */

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired //Esta anotacion sirve para que inyecte una implementacion de UsuarioRepository
	private UsuarioRepository usuarioRepo; //Nos permite comunicarnos con la DB
	
	@Override
	/**
	 * Obtiene un usuario de la DB por ID
	 */
	public User obtenerUsuarioPorId(int id) {
		User usuario = null;
		Optional<UsuarioDTO> usuarioDb = usuarioRepo.findById(id); //Este metodo ya viene por CrudRepository
		
		//Si encontro usuario
		if(usuarioDb.isPresent()) {
			usuario = mapearUsuarioDb(usuarioDb.get());
		}
		
		return usuario;
	}

	@Override
	public int crearUsuario(User user) {
		UsuarioDTO userDb = mapearUsuario(user);
		
		userDb = usuarioRepo.save(userDb);
		return userDb.getId();
	}

	@Override
	public boolean eliminarUsuario(int id) {
		usuarioRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarUsuario(User user) {
		UsuarioDTO userDb = mapearUsuario(user);
		
		userDb = usuarioRepo.save(userDb);
		return true;
	}

	private User mapearUsuarioDb(UsuarioDTO usuarioDb) {
		User usuario = new User();
		
		usuario.setId(usuarioDb.getId());
		usuario.setNombre(usuarioDb.getNombre());
		
		return usuario;
		
	}
	
	private UsuarioDTO mapearUsuario(User usuario) {
		UsuarioDTO usuarioDb = new UsuarioDTO();
		
		usuarioDb.setId(usuario.getId());
		usuarioDb.setNombre(usuario.getNombre());
		
		return usuarioDb;
		
	}
	
}
