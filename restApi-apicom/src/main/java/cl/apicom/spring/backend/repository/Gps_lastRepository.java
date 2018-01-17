package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Gps_last;

public interface Gps_lastRepository extends PagingAndSortingRepository<Gps_last, Integer>{
	
	@Query("SELECT gl FROM Gps_last gl WHERE gl.id_user = :id_user")
	Gps_last findGpsUser(@Param("id_user") int id_user);
}
