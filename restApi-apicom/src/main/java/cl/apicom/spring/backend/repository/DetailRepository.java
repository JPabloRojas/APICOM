package cl.apicom.spring.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Detail;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Long>{
	
	
	@Query("SELECT d FROM Detail d, Lista l WHERE DATE(d.despair_date) = CURDATE() and d.id_lista = l.id and l.id_user = :id_user")
	Iterable<Detail> getDetailDay(@Param("id_user") long id_user);
	
	@Query("SELECT d FROM Detail d, Lista l, User u WHERE DATE(despair_date) = CURDATE() and d.id_lista = l.id and l.id_user = u.id and u.id = :id_user")
	Iterable<Detail> getDetailDayUser(@Param("id_user") long id_user);
	
	@Query("SELECT d FROM Detail d WHERE DATE(despair_date) = :date")
	Iterable<Detail> getDetailDate(@Param("date") Date date);
	
	@Query("SELECT d FROM Detail d, Base b, User u, Client c WHERE DATE(d.despair_date) BETWEEN :date_init AND :date_end AND d.id_base = b.id AND b.id_user = u.id AND u.id_client = c .id AND c.id = :id")
	Iterable<Detail> getDetailFromClientDate(@Param("date_init") Date date_init, @Param("date_end") Date date_end, @Param("id") long id);
	
	@Query("SELECT d FROM Detail d WHERE DATE(d.despair_date) BETWEEN :date_init AND :date_end")
	Iterable<Detail> getDetailDate(@Param("date_init") Date date_init, @Param("date_end") Date date_end);
	
	@Query("SELECT d FROM Detail d WHERE d.id_base = :id_base")
	Iterable<Detail> getDetailFromBase(@Param("id_base") long id_base);
	
	@Query("SELECT d FROM Detail d, Base b, User u, Client c WHERE d.id_base = b.id and b.id_user = u.id and u.id_client = c .id and c.id = :id")
	Iterable<Detail> getDetailFromClient(@Param("id") long id);
	
	@Query("SELECT d FROM Detail d, Lista l, User u WHERE d.id_lista = l.id and l.id_user = u.id and l.active = 1 and u.id = :id_user")
	Iterable<Detail> getDetailUser(@Param("id_user") long id_user);
	
}
