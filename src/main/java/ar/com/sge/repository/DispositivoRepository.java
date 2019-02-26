package ar.com.sge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.sge.dto.DispositivoDTO;

@Repository
public interface DispositivoRepository extends CrudRepository<DispositivoDTO, Integer> {

}
