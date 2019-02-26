package ar.com.sge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dispositivo {
	
	@JsonProperty("id")
	Integer id;
	
	@JsonProperty("nombre")
	String nombre;
	
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