package ar.com.sge.service;

import ar.com.sge.model.Dispositivo;

/**
 * Interface de servicios que ofrece ABM de usuarios.
 * @author Hisoka
 *
 */
public interface IDispositivoService {

	public Dispositivo obtenerDispositivoPorId(int id);
	
	public int crearDispositivo(Dispositivo dispositivo);
	
	public boolean eliminarDispositivo(int id);
	
	public boolean actualizarDispositivo(Dispositivo user);
	
}
