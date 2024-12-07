package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Breed;
import com.demo.entity.Category;
import com.demo.entity.PetCustomized;
import com.demo.service.PetService;

@RestController
public class PetShop {

	@Autowired
	PetService service;

	// post
	// insert details
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public PetShopDTO addPetDetails(@RequestBody PetShopDTO psd) {
		System.out.println("Pet id:" + psd.getPetId() + " pet name:" + psd.getPetName() + " breed id:"
				+ psd.getBreedId() + " breed name:" + psd.getBreedName());

		Breed br1 = new Breed();
		br1.setBreedId(psd.getBreedId());
		br1.setBreedName(psd.getBreedName());

		Category ca = new Category();
		ca.setPetId(psd.getPetId());
		ca.setPetName(psd.getPetName());

		br1.setCategory(ca);

		List<Breed> li = new ArrayList<Breed>();
		li.add(br1);
		ca.setBreed(li);
		service.AddDetails(ca);
		return psd;
	}

	// fetchById details
	@RequestMapping(value = "/fetchById", method = RequestMethod.POST)
	public List<PetShopDTO> fetchByIdPetDetail(@RequestBody String id) {
		System.out.println("pet id:" + id);
		List<PetShopDTO> psd = new ArrayList<PetShopDTO>();
		PetShopDTO ps = new PetShopDTO();
		List<PetCustomized> li5 = service.fetchByIdPetDetail(id);

		for (PetCustomized pc : li5) {
			ps = new PetShopDTO();
			ps.setPetId(pc.getPetId());
			ps.setPetName(pc.getPetName());
			ps.setBreedId(pc.getBreedId());
			ps.setBreedName(pc.getBreedName());
			psd.add(ps);

		}

		return psd;
	}
	
	// fetchOneById details
		@RequestMapping(value = "/fetchOneById", method = RequestMethod.POST)
		public PetShopDTO fetchOneByIdPetDetail(@RequestBody String id) {
			System.out.println("id:"+id);
			Breed b=service.fetchOneDetail(new String(id));
			PetShopDTO psd=new PetShopDTO();
			psd.setBreedId(b.getBreedId());
			psd.setBreedName(b.getBreedName());
			
			return psd;
			
			
		}
		
		

}
