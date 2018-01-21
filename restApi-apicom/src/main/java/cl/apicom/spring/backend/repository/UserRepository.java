package cl.apicom.spring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	
	@Query("SELECT u FROM User u WHERE u.user = :user and u.password = :password")
	User findLogin(@Param("user") String user, @Param("password") String password);
		
	@Query("SELECT u FROM User u WHERE u.user = :user")
	User findbyUser(@Param("user") String user);
	
	@Query("SELECT u FROM User u WHERE creation_date BETWEEN '2018-01-20 22:14:09' and '2018-01-21 00:00:00'")
	List<User> findByDate();
}
