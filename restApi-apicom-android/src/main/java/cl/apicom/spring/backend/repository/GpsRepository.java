package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Gps;
//Solo se usara si se impleneta el historial de gps
public interface GpsRepository extends PagingAndSortingRepository<Gps, Long>{
	
	@Query("SELECT g FROM Gps g WHERE g.id_user = :id_user")
	Gps findGpsUser(@Param("id_user") long id_user);
}
