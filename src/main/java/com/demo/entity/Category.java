package com.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)
public class Category implements Serializable {
	@Id
	@Column(name = "pet_id")
	private String petId;

	@Column(name = "pet_name")
	private String petName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
	private List<Breed> breed;

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

	public List<Breed> getBreed() {
		return breed;
	}

	public void setBreed(List<Breed> breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Category [petId=" + petId + ", petName=" + petName + "]";
	}

}
