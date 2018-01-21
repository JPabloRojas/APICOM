package cl.apicom.spring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long>{
	
	@Query("SELECT c FROM Client c where id != 0")
	List<Client> getAllExceptFirst();
	
}
