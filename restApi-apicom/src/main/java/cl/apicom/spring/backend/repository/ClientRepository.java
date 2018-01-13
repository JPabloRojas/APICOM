package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer>{

}
