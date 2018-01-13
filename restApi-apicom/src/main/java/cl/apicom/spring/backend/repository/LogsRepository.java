package cl.apicom.spring.backend.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import cl.apicom.spring.backend.entities.Logs;

public interface LogsRepository extends PagingAndSortingRepository<Logs, Integer>{

}
