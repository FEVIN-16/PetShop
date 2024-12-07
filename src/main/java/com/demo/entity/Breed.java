package com.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name = "breed")
@EntityListeners(AuditingEntityListener.class)
public class Breed  implements Serializable{
	
	@Id
	@Column(name="breed_id")
	private String breedId;
	

	@Column(name="breed_name")
	private String breedName;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pet_id",nullable = false,referencedColumnName = "pet_id")
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Breed [breedId=" + breedId + ", breedName=" + breedName + ", category=" + category + "]\n";
	}

}
