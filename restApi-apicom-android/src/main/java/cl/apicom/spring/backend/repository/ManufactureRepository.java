package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Manufacture;

public interface ManufactureRepository extends PagingAndSortingRepository<Manufacture, Long>{ 
	
	/*
	 * Consulta Mysql que returna todos los productos correspondientes a un usuario con id en especifico.
	 */
	@Query("SELECT m FROM Manufacture m, Detail d, Lista l, User u WHERE m.id = d.id_manufacture and d.id_lista = l.id and l.id_user = u.id and u.id = :id_user")
	Iterable<Manufacture> getAllManufUser(@Param("id_user") long id_user);
	
	/*
	 * Consulta Mysql que retorna un producto con id en especifico.
	 */
	@Query("SELECT m FROM Manufacture m WHERE m.id = :id_manufacture")
	Manufacture getMAnufacture(@Param("id_manufacture") long id_manufacture);
}
