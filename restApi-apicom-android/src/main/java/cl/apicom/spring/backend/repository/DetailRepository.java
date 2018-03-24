package cl.apicom.spring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Detail;
import cl.apicom.spring.backend.entities.Lista;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Long>{
	
	/*
	 * Consulta MySQL que retorna todos los detalles del dia.
	 */
	@Query("SELECT d FROM Detail d WHERE DATE(despair_date) = CURDATE()")
	Iterable<Detail> getDetailDay();
	
	/*
	 * Consulta MySQL que retorna los detalles de correspondientes a un usuario con ID especifico con lista activa
	 * y además la fecha de lista activa este dentro del dia pedido.
	 */
	@Query("SELECT d FROM Detail d, Lista l, User u WHERE d.id_lista = l.id and l.id_user = u.id and l.active = 1 and u.id = :id_user")
	Iterable<Detail> getDetailUser(@Param("id_user") long id_user);
	
	

}
