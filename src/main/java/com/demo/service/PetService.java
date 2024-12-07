package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.PetBO;
import com.demo.entity.Breed;
import com.demo.entity.BreedCustomized;
import com.demo.entity.Category;
import com.demo.entity.CategoryCustomized;
import com.demo.entity.PetCustomized;

@Component
public class PetService {

	@Autowired
	PetBO bo;

//add category details in the both the entities
	public Category AddDetails(Category c) {
		return bo.AddDetails(c);
	}

//add pet details only in breed table using foreign key
	public Breed AddDetail(Breed c) {
		return bo.AddDetail(c);
	}

//fetch Category details only in Category table
	public List<Category> fetchAllDetails() {
		return bo.fetchAllDetails();
	}

//fetch Breed details  in breed  and Category table
	public List<Breed> fetchAllDetail() {
		return bo.fetchAllDetail();
	}

// fetch by id in the category table
	public Category fetchOneDetails(String id) {
		return bo.fetchOneDetails(id);
	}

// fetch by id in the breed table  it will display both the table details
	public Breed fetchOneDetail(String id) {
		return bo.fetchOneDetail(id);
		
	}

//fetch by pet name using customized query in category entity
	public List<CategoryCustomized> findByPetNameCustomized(String a) {
		return bo.findByPetNameCustomized(a);

	}

// fetch breed name by customized query in breed entity	
	public List<BreedCustomized> fetchByNameCustomized(String b) {
		return bo.fetchByNameCustomized(b);
	}

//find the count of the breed id in breed entity
	public Integer findCount() {
		return bo.findCount();
	}

//display all details from  category and breed using join	
	public List<PetCustomized> findCategoryWithBreed() {
		return bo.findCategoryWithBreed();
	}

//display all details from  category and breed using left join	
	public List<PetCustomized> findCategoryWithBreedLeft() {
		return bo.findCategoryWithBreedLeft();
	}

//display all details from  category and breed using left join	
	public List<PetCustomized> findCategoryWithBreedRight() {
		return bo.findCategoryWithBreedRight();
	}

//fetch by id using customized query
	public List<PetCustomized> fetchByIdPetDetail(String id) {
		List<PetCustomized> pc1 = bo.fetchByIdPetDetail(id);
//		List<PetCustomized> li5 = bo.fetchByIdPetDetail("1c2ow3");
//		for (PetCustomized pc : li5) {
//			System.out.println("petId: " + pc.getPetId() + "  petName: " + pc.getPetName() + "  breedName: "
//					+ pc.getBreedName() + "  breeId: " + pc.getBreedId());
//		}

		return pc1;

	}

}
