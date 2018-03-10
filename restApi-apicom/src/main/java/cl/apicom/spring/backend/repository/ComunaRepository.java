package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Comunas;

public interface ComunaRepository extends PagingAndSortingRepository<Comunas, Long>{

}
