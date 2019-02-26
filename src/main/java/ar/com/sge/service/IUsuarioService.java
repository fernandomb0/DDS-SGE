package ar.com.sge.service;

import ar.com.sge.model.User;

/**
 * Interface de servicios que ofrece ABM de usuarios.
 * @author Hisoka
 *
 */
public interface IUsuarioService {

	public User obtenerUsuarioPorId(int id);
	
	public int crearUsuario(User user);
	
	public boolean eliminarUsuario(int id);
	
	public boolean actualizarUsuario(User user);
	
}
