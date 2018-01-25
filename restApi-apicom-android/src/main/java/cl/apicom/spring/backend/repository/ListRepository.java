package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Lista;

public interface ListRepository extends PagingAndSortingRepository<Lista, Long>{
	
	@Query("SELECT l FROM Lista l WHERE l.id_user=:id_user")
	Iterable<Lista> getListUser(@Param("id_user") long id_user);
}
