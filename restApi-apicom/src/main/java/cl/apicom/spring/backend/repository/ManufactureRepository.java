package cl.apicom.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import cl.apicom.spring.backend.entities.Manufacture;

public interface ManufactureRepository extends PagingAndSortingRepository<Manufacture, Integer>{
		
}
