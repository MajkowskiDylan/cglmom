package com.momcgl.cglmom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="editeur_jeu")
public class Editeur {
	@Id
	Long id;
	
	@Column
	String nom_editeur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_editeur() {
		return nom_editeur;
	}

	public void setNom_editeur(String nom_type) {
		this.nom_editeur = nom_type;
	}


	
	
}
