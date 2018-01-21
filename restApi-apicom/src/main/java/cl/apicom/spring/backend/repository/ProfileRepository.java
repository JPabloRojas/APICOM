package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Profile;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long>{

}
