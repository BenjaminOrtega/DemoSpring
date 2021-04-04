package mx.com.eb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//se agrego la anotacion @Trasactional para que se tubiera que hacer commit(afectar las tablas si no hay errores) o 
//rollback(no afectar las tablas en caso de error)

import mx.com.eb.dao.IPersonaDao;
import mx.com.eb.domain.Persona;

@Service
public class PersonaService implements PersonaServiceImpl{

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)//el parametro de la anotacion readOnly es para activar la funcion de soloLectura y no afectar las tablas
	public List<Persona> listaPersona() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		return personaDao.findById(persona.getIdPersona()).orElse(null);
	}

}
