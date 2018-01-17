package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Gps;

public interface GpsRepository extends PagingAndSortingRepository<Gps, Integer>{
	
	@Query("SELECT g FROM Gps g WHERE g.id_user = :id_user")
	Gps findGpsUser(@Param("id_user") int id_user);
}
