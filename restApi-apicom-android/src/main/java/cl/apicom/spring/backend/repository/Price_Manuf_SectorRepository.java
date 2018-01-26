package cl.apicom.spring.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.apicom.spring.backend.entities.Price_Manuf_Sector;

public interface Price_Manuf_SectorRepository extends PagingAndSortingRepository<Price_Manuf_Sector, Long>{
	
	@Query("SELECT pms FROM Price_Manuf_Sector pms WHERE pms.id_sector = :id_sector and pms.id_manufacture = :id_manufacture")
	Price_Manuf_Sector getPMSsectormanuf(@Param("id_sector") long id_sector, @Param("id_manufacture") long id_manuf);
}
