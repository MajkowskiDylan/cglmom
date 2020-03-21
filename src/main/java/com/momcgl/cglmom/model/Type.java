package com.momcgl.cglmom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type_jeu")
public class Type {
	@Id
	Long id;
	
	@Column
	String nom_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_type() {
		return nom_type;
	}

	public void setNom_type(String nom_type) {
		this.nom_type = nom_type;
	}


	
	
}
