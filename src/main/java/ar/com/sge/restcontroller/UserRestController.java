package ar.com.sge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.sge.model.User;
import ar.com.sge.service.IUsuarioService;

/**
 * Controlador que se encarga del abm de usuario. Fijarse bien le Request method de cada metyodo.
 * EL GET es para obtener datos, el POST para crear usuario, el PUT para actualizar usaurio y el DELETE 
 * para eliminar el usaurio.
 * @author Hisoka
 *
 */
@RestController
public class UserRestController {

	@Autowired
	IUsuarioService usuarioService;
	
	// Devuelve el dispositivo buscado por id
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getDispositivo(@PathVariable("id") int id) {
		System.out.println("Buscando usuario con id: " + id);

		User usuario = usuarioService.obtenerUsuarioPorId(id);
		
		if(usuario == null)
			return new ResponseEntity<User>(usuario, HttpStatus.NOT_FOUND); 
		
		// spring hace que lo que se devuelve es un JSON
		return new ResponseEntity<User>(usuario, HttpStatus.OK);
	}

	// Crea nuevo usuario
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Integer> createUsuario(@RequestBody User usuario) {
		usuario.setId(null);
		System.out.println("Recibiendo usuario ...");

		//Se pasa el nuevo usuario al servicio de usuarios
		Integer idUsuarioCreado = usuarioService.crearUsuario(usuario);

		System.out.println("Usuario guardado!!");

		return new ResponseEntity<Integer>(idUsuarioCreado, HttpStatus.CREATED);
	}
	
	// Crea nuevos usuarios
		@RequestMapping(value = "/users", method = RequestMethod.POST)
		public ResponseEntity<Boolean> createUsuarios(@RequestBody List<User> usuarios) {

			System.out.println("Recibiendo usuarios ...");

			//Crea cada usuario recibido
			for(User user : usuarios) {
				usuarioService.crearUsuario(user);
			}

			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		}
	
	//Actualiza un usuario existente. En caso de no existir lo crea
		@RequestMapping(value = "/user", method = RequestMethod.PUT)
		public ResponseEntity<Boolean> actualizarUsuario(@RequestBody User usuario) {

			System.out.println("Recibiendo usuario ...");

			//Se pasa actualizacion de usuario al servicio de usuarios
			Boolean ressultadoActualizacion = usuarioService.actualizarUsuario(usuario);

			System.out.println("Usuario guardado!!");

			return new ResponseEntity<Boolean>(ressultadoActualizacion, HttpStatus.ACCEPTED);
		}
		
		//Elimina un usuario
		@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Boolean> eliminarUsuario(@PathVariable("id") int id) {

			System.out.println("Eliminando usuario con id " + id);

			//Se pasa id de usuario a eliminar
			Boolean ressultadoActualizacion = usuarioService.eliminarUsuario(id);

			return new ResponseEntity<Boolean>(ressultadoActualizacion, HttpStatus.OK);
			
		}
}
