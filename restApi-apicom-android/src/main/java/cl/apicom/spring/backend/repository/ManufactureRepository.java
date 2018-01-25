package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Manufacture;

public interface ManufactureRepository extends PagingAndSortingRepository<Manufacture, Long>{ 
	
	
	/*@Query("SELECT Manufacture m FROM Manufacture m, Detail d, Lista l, User u WHERE m.id = d.id_manufacture and d.id_lista = l.id and l.id_user = u.id and u.id = :id_user")
	Iterable<Manufacture> getAllManufUser(@Param("id_user") long id_user);*/
}
