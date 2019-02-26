package ar.com.sge.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase representa es el objeto de transferencia de datos que se utiliza
 * para la tabla Usaurios de la base de datos.
 * Siempre debe tener un @Entity que indique que es un bean, y con @Table se le indica
 * la tabla a la que hace referencia en la base de datos.
 * @author Fernando
 *
 */
@Entity
@Table(name = "Usuarios")
public class UsuarioDTO {

	@Id //Indica que va a ser el Id de la tabla
	@GeneratedValue(strategy = GenerationType.AUTO) //Tipo de estrategia para generacion de ID
	@Column(name = "id", nullable = false) //Indica el nombre de la columna y si puede ser null
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
