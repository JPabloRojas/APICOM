package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Detail;

public interface DetailRepository extends PagingAndSortingRepository<Detail, Integer>{

}
