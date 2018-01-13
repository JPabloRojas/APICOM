package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.Lista;

public interface ListRepository extends PagingAndSortingRepository<Lista, Integer>{

}
