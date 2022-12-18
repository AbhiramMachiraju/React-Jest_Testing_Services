package com.example.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.service.model.BioDataTO;


@Repository
public interface BioDao extends CrudRepository<BioDataTO,Long> {
	
	/*@Query("SELECT *  FROM BioDataTO e WHERE e.autoId >= :autoId")
    public List<BioDataTO> listItemsWithPriceOver(@Param("autoId") Long amount);*/
	

}
