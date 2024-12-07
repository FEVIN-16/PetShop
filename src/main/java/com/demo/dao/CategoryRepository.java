package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Breed;
import com.demo.entity.Category;
import com.demo.entity.CategoryCustomized;
import com.demo.entity.PetCustomized;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

	@Query("select c.petName as petName  from Category c where c.petName like %:pn% ")
	List<CategoryCustomized> findByPetNameCustomized(@Param("pn") String petName);
	
	@Query("select c.petId as petId,c.petName as petName,b.breedId as breedId,b.breedName as breedName FROM  Category as c  join Breed b on c.petId=b.category where c.petId=:id")
	List<PetCustomized> fetchByIdPetDetail(@Param("id") String petId);

	@Query("select c.petId as petId,c.petName as petName,b.breedId as breedId,b.breedName as breedName FROM  Category as c  join Breed b on c.petId=b.category")
	List<PetCustomized> findCategoryWithBreed();

	@Query("select c.petId as petId,c.petName as petName,b.breedName as breedName,b.breedId as breedId FROM  Category as c  left join Breed b on c.petId=b.category")
	List<PetCustomized> findCategoryWithBreedLeft();

	@Query("select c.petId as petId,c.petName as petName,b.breedName as breedName,b.breedId as breedId FROM  Category as c  right join Breed b on c.petId=b.category")
	List<PetCustomized> findCategoryWithBreedRight();

}
