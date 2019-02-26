package ar.com.sge.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Dispositivos")
public class DispositivoDTO {

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