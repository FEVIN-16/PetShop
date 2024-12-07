package com.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.BreedRepository;
import com.demo.dao.CategoryRepository;
import com.demo.entity.Breed;
import com.demo.entity.BreedCustomized;
import com.demo.entity.Category;
import com.demo.entity.CategoryCustomized;
import com.demo.entity.PetCustomized;

@Component
public class PetBO {
	@Autowired
	CategoryRepository cr;
	@Autowired
	BreedRepository br;

//add category details in the both the entities
	public Category AddDetails(Category c) {
		return cr.save(c);
	}

//add pet details only in breed table using foreign key
	public Breed AddDetail(Breed c) {
		return br.save(c);
	}

//fetch Category details only in Category table
	public List<Category> fetchAllDetails() {
		return cr.findAll();
	}

//fetch Breed details  in breed  and Category table
	public List<Breed> fetchAllDetail() {
		return br.findAll();
	}

// fetch by id in the category table
	public Category fetchOneDetails(String id) {
		Optional<Category> pet = cr.findById(id);
		return (pet.get());
	}

// fetch by id in the breed table  it will display both the table details
	public Breed fetchOneDetail(String id) {
		Optional<Breed> pet = br.findById(id);
		return (pet.get());
	}

//fetch by pet name using customized query in category entity
	public List<CategoryCustomized> findByPetNameCustomized(String a) {
		return cr.findByPetNameCustomized(a);

	}

// fetch breed name by customized query in breed entity	
	public List<BreedCustomized> fetchByNameCustomized(String b) {
		return br.fetchByNameCustomized(b);
	}

//find the count of the breed id in breed entity
	public Integer findCount() {
		return br.findCount();
	}

//display all details from  category and breed using join	
	public List<PetCustomized> findCategoryWithBreed() {
		return cr.findCategoryWithBreed();
	}

//display all details from  category and breed using left join	
	public List<PetCustomized> findCategoryWithBreedLeft() {
		return cr.findCategoryWithBreedLeft();
	}

//display all details from  category and breed using left join	
	public List<PetCustomized> findCategoryWithBreedRight() {
		return cr.findCategoryWithBreedRight();
	}
	
//fetch by id using customized query
	public List<PetCustomized> fetchByIdPetDetail(String id) {
		List<PetCustomized> pc=cr.fetchByIdPetDetail(id);
		return pc;

	}

}
