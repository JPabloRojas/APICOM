package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

}
