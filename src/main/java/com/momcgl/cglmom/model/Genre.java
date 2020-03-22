package com.momcgl.cglmom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre_jeu")
public class Genre {
	
	@Id
	Long id;
	
	@Column	
	String nom_genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_genre() {
		return nom_genre;
	}

	public void setNom_genre(String nom_genre) {
		this.nom_genre = nom_genre;
	}
}
