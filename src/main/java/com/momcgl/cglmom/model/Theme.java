package com.momcgl.cglmom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theme_jeu")
public class Theme {
	
	@Id
	Long id;
	
	@Column	
	String nom_theme;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_theme() {
		return nom_theme;
	}

	public void setNom_theme(String nom_theme) {
		this.nom_theme = nom_theme;
	}
}
