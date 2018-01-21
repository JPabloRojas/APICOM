package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Sector;

public interface SectorRepository extends PagingAndSortingRepository<Sector, Long>{

}
