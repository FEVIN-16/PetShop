package com.example.demo;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.bo.PetBO;
import com.demo.dao.CategoryRepository;
import com.demo.entity.Breed;
import com.demo.entity.BreedCustomized;
import com.demo.entity.Category;
import com.demo.entity.CategoryCustomized;
import com.demo.entity.PetCustomized;
import com.demo.service.PetService;

@SpringBootApplication
@ComponentScan("com.demo")
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = CategoryRepository.class)
@EntityScan(basePackages = { "com.demo.entity" })
public class PetShop1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PetShop1Application.class, args);
		PetService service = ctx.getBean(PetService.class);

//add category details in the both the entities

		// System.out.println( service.fetchAllDetails());

//add pet details only in breed table using foreign key

		// System.out.println( service.fetchAllDetail());

// fetch by id in the category table

		// System.out.println(service.fetchOneDetails("2d2o3g4"));

// fetch by id in the breed table  it will display both the table details

		// System.out.println(service.fetchOneDetail("1pom2"));

//find the count of the breed id in breed entity

		// System.out.println(" total number of breed id :"+service.findCount());

// to add the details in the two entities

		Breed br1 = new Breed();
		br1.setBreedId("2nia3");
		br1.setBreedName("NiangMegha");
		Breed br2 = new Breed();
		br2.setBreedId("2ghoo3");
		br2.setBreedName("Ghoongroo ");

		Category ca1 = new Category();
		ca1.setPetId("2p3i4g");
		ca1.setPetName("pig");

		br1.setCategory(ca1);
		br2.setCategory(ca1);

		List<Breed> li = new ArrayList<Breed>();
		li.add(br1);
		li.add(br2);
		ca1.setBreed(li);

		// service.AddDetails(ca1);

//to add the details in one of the entity using the primary key of category

		Breed br3 = new Breed();
		br3.setBreedId("2spo3");
		br3.setBreedName("Spotted");

		Category ca3 = new Category();
		ca3.setPetId("2p3i4g");

		br3.setCategory(ca3);

		// service.AddDetail(br3);

//fetch by pet name using customized query

		// List <CategoryCustomized> list = service.findByPetNameCustomized("o");
		// for(CategoryCustomized obj:list) {
		// System.out.println("petName:"+"\t"+ obj.getPetName());

		// }

// fetch breed name by customized query in breed entity

		// List<BreedCustomized> li1=service.fetchByNameCustomized("d");
		// for(BreedCustomized ob:li1) {
		// System.out.println("breedName:"+"\t"+ ob.getBreedName());
		// }

//display all details from  category and breed using join	
		// List<PetCustomized> li2 = service.findCategoryWithBreed();
		// for (PetCustomized ob : li2) {
		// System.out.println("petId: " +ob.getPetId() + " petName: " + ob.getPetName()
		// + " breedName: "
		// + ob.getBreedName() + " breeId: " + ob.getBreedId());
		// }

//display all details from  category and breed using left join	
		// List<PetCustomized> li3 = service.findCategoryWithBreedLeft();
		// for (PetCustomized ob : li3) {
		// System.out.println("petId: " +ob.getPetId() + " petName: " + ob.getPetName()
		// + " breedName: "
		// + ob.getBreedName() + " breeId: " + ob.getBreedId());
		// }

//display all details from  category and breed using left join	
		// List<PetCustomized> li4 = service.findCategoryWithBreedRight();
		// for (PetCustomized ob : li4) {
		// System.out.println("petId: " +ob.getPetId() + " petName: " + ob.getPetName()
		// + " breedName: "
		// + ob.getBreedName() + " breeId: " + ob.getBreedId());
		// }

//fetch by id using customized query
		//List<PetCustomized> li5 = service.fetchOnePetDetail("1c2ow3");
		//for (PetCustomized pc : li5) {
			//System.out.println("petId: " + pc.getPetId() + "  petName: " + pc.getPetName() + "  breedName: "
					//+ pc.getBreedName() + "  breeId: " + pc.getBreedId());
		//}
	}

}
