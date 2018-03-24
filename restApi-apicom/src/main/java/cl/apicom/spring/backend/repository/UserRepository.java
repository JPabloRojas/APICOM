package cl.apicom.spring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	/*
	 * Consulta Mysql que permite obtener datos de un usuario a partir de su user y password.
	 */
	@Query("SELECT u FROM User u WHERE u.user = :user and u.password = :password")
	User findLogin(@Param("user") String user, @Param("password") String password);
	
	/*
	 * Consulta Mysql que permite encontrar un usuario a partir de su nombre de usuario(Dato único).
	 */
	@Query("SELECT u FROM User u WHERE u.user = :user")
	User findbyUser(@Param("user") String user);
	
	/*
	 * Consulta Mysql que permite obtener los usuarios en donde su lista esta activa.
	 */
	@Query("SELECT DISTINCT u FROM User u, Lista l WHERE l.id_user = u.id AND l.active = 1")
	Iterable<User> getUserActive();
}
