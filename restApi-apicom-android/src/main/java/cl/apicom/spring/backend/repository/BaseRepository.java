package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Base;

public interface BaseRepository extends PagingAndSortingRepository<Base, Long>{

}
