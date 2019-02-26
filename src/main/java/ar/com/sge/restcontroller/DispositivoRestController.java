package ar.com.sge.restcontroller;

import java.util.ArrayList;
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

import ar.com.sge.model.Dispositivo;
import ar.com.sge.service.IDispositivoService;


@RestController
public class DispositivoRestController {

	@Autowired
	IDispositivoService dispositivoService;
	
	// Devuelve el dispositivo buscado por id
	@RequestMapping(value = "/dispositivo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dispositivo> getDispositivo(@PathVariable("id") int id) {
		System.out.println("Buscando dispositivo con id: " + id);

		Dispositivo dispositivo = dispositivoService.obtenerDispositivoPorId(id);
		
		if(dispositivo == null)
			return new ResponseEntity<Dispositivo>(dispositivo, HttpStatus.NOT_FOUND); 
		
		// spring hace que lo que se devuelve es un JSON
		return new ResponseEntity<Dispositivo>(dispositivo, HttpStatus.OK);
	}

	// Crea nuevo dispositivo
	@RequestMapping(value = "/dispositivo", method = RequestMethod.POST)
	public ResponseEntity<Integer> createDispositivo(@RequestBody Dispositivo dispositivo) {
		dispositivo.setId(null);
		System.out.println("Recibiendo dispositivo ...");

		//Se pasa el nuevo usuario al servicio de usuarios
		Integer idDispositivoCreado = dispositivoService.crearDispositivo(dispositivo);

		System.out.println("Dispositivo guardado!!");

		return new ResponseEntity<Integer>(idDispositivoCreado, HttpStatus.CREATED);
	}
	
	// Crea nuevos dispositivos
		@RequestMapping(value = "/dispositivos", method = RequestMethod.POST)
		public ResponseEntity<Boolean> createDispositivos(@RequestBody ArrayList<Dispositivo> dispositivos) {

			System.out.println("Recibiendo dispositivos ...");

			//Crea cada dispositivo recibido
			for(Dispositivo dispositivo : dispositivos) {
				dispositivoService.crearDispositivo(dispositivo);
			}

			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);

		}
	
	//Actualiza un usuario existente. En caso de no existir lo crea
		@RequestMapping(value = "/Dispositivo", method = RequestMethod.PUT)
		public ResponseEntity<Boolean> actualizarDispositivo(@RequestBody Dispositivo dispositivo) {

			System.out.println("Recibiendo dispositivo ...");

			//Se pasa actualizacion de usuario al servicio de usuarios
			Boolean ressultadoActualizacion = dispositivoService.actualizarDispositivo(dispositivo);

			System.out.println("dispositivo guardado!!");

			return new ResponseEntity<Boolean>(ressultadoActualizacion, HttpStatus.ACCEPTED);
		}
		
		//Elimina un usuario
		@RequestMapping(value = "/dispositivo/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Boolean> eliminarDispositivo(@PathVariable("id") int id) {

			System.out.println("Eliminando dispositivo con id " + id);

			//Se pasa id de dispositivo a eliminar
			Boolean ressultadoActualizacion = dispositivoService.eliminarDispositivo(id);

			return new ResponseEntity<Boolean>(ressultadoActualizacion, HttpStatus.OK);
			
		}
}
