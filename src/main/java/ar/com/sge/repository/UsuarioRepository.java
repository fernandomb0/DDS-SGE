package ar.com.sge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.sge.dto.UsuarioDTO;

/**
 * Repository es una interface que facilita la comunicacion con la Base de datos. 
 * Se caracteriza por tener una anotation @Repository que le indica a Spring que es un bean,
 * tambien por extender de la Interface CrudRepository, e indicar <ClaseDto, Id>, donde ClaseDTO
 * es el objeto utilizado para representar la tabla, en este caso de Usuarios, y Id, es el tipo de dato del 
 * Id del objeto. No hace falta realizar ninguna implementacion de esta interface, Springboot se encarga de ello
 * para que solo nos preocupemos por usarla.
 * @author Fernando
 *
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioDTO, Integer> {

}
