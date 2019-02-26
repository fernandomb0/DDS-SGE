package ar.com.sge.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.sge.dto.DispositivoDTO;
import ar.com.sge.model.Dispositivo;
import ar.com.sge.repository.DispositivoRepository;


/**
 * Implementacion del servicio de usuario. Es importante indicar la anotation
 * @Service para que spring lo detecte como un bean a generar en su contexto.
 * @author Fernando
 *
 */

@Service
public class DispositivoService implements IDispositivoService {

	@Autowired //Esta anotacion sirve para que inyecte una implementacion de UsuarioRepository
	private DispositivoRepository dispositivoRepo; //Nos permite comunicarnos con la DB
	
	@Override
	/**
	 * Obtiene un dispositivo de la DB por ID
	 */
	public Dispositivo obtenerDispositivoPorId(int id) {
		Dispositivo dispositivo = null;
		Optional<DispositivoDTO> dispositivoDb = dispositivoRepo.findById(id); //Este metodo ya viene por CrudRepository
		
		//Si encontro dispositivo
		if(dispositivoDb.isPresent()) {
			dispositivo = mapeardispositivoDb(dispositivoDb.get());
		}
		
		return dispositivo;
	}

	@Override
	public int crearDispositivo(Dispositivo dispositivo) {
		DispositivoDTO dispositivoDb = mapearDispositivo(dispositivo);
		
		dispositivoDb = dispositivoRepo.save(dispositivoDb);
		return dispositivoDb.getId();
	}

	@Override
	public boolean eliminarDispositivo(int id) {
		dispositivoRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarDispositivo(Dispositivo dispositivo) {
		DispositivoDTO dispositivoDb = mapearDispositivo(dispositivo);
		
		dispositivoDb = dispositivoRepo.save(dispositivoDb);
		return true;
	}

	private Dispositivo mapeardispositivoDb(DispositivoDTO dispositivoDb) {
		Dispositivo dispositivo = new Dispositivo();
		
		dispositivo.setId(dispositivoDb.getId());
		dispositivo.setNombre(dispositivoDb.getNombre());
		
		return dispositivo;
		
	}
	
	private DispositivoDTO mapearDispositivo(Dispositivo dispositivo) {
		DispositivoDTO dispositivoDb = new DispositivoDTO();
		
		dispositivoDb.setId(dispositivo.getId());
		dispositivoDb.setNombre(dispositivo.getNombre());
		
		return dispositivoDb;
		
	}
	
}
