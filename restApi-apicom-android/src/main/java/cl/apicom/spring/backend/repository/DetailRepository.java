package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Detail;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Long>{
	
	
	@Query("SELECT d FROM Detail d WHERE DATE(despair_date) = CURDATE()")
	Iterable<Detail> getDetailDay();
	
	@Query("SELECT d FROM Detail d, Lista l, User u WHERE d.id_lista = l.id and l.id_user = u.id and l.active = 1 and u.id = :id_user and DATE(l.list_date) = CURDATE()")
	Iterable<Detail> getDetailUser(@Param("id_user") long id_user);
	
}
