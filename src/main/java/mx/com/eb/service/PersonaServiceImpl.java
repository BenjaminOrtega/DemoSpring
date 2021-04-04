package mx.com.eb.service;

import java.util.List;

import mx.com.eb.domain.Persona;

public interface PersonaServiceImpl {

	public List<Persona> listaPersona();
	
	public void guardar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona encontrarPersona(Persona persona);
}
