package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Breed;
import com.demo.entity.BreedCustomized;

@Repository
public interface BreedRepository extends JpaRepository<Breed, String> {
	@Query("select b.breedName as breedName from Breed b  where b.breedName like %:bn%")
	List<BreedCustomized> fetchByNameCustomized(@Param("bn") String breedName);

	@Query("select count(breedId) from Breed ")
	Integer findCount();
	
	
	
	
	

}
