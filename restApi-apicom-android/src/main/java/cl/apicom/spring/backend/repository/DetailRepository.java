package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Detail;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Long>{
	
	
	@Query("SELECT d FROM Detail d WHERE DATE(despair_date) = CURDATE()")
	Iterable<Detail> getDetailDay();
	
}
