package mx.com.eb.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.eb.domain.Persona;
//en esta interfaz se extiende de la clase CrudRepository para heredar sus metodos
//tambien se pueden crear metodos (consultar) personalisables
public interface IPersonaDao extends CrudRepository<Persona, Long> {

}