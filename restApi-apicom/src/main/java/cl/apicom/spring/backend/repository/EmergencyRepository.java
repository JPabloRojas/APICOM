package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Emergency;

public interface EmergencyRepository extends PagingAndSortingRepository<Emergency, Integer>{

}
