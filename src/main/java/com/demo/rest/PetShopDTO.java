package com.demo.rest;



public class PetShopDTO {
	
	private String petId;
	private String petName;
	private String breedId;
	private String breedName;

	public String getBreedId() {
		return breedId;
	}
	public void setBreedId(String breedId) {
		this.breedId = breedId;
	}
	public String getBreedName() {
		return breedName;
	}
	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}
	
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	@Override
	public String toString() {
		return "PetShopDTO [breedId=" + breedId + ", breedName=" + breedName + ", petId="
				+ petId + ", petName=" + petName + "]";
	}
	


}
