package com.momcgl.cglmom.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jeu")
public class Jeu {

	@Id
	Long id;
	
	@Column
	String nom_jeu;
	@Column
	int id_type;
	@Column
	int id_genre;
	@Column
	int id_theme;
	@Column
	int id_editeur;
	@Column
	int age_minimum;
	@Column
	int nombre_joueurs_minimum;
	@Column
	int nombre_joueurs_maximum;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_jeu() {
		return nom_jeu;
	}
	public void setNom_jeu(String nom_jeu) {
		this.nom_jeu = nom_jeu;
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
	public int getId_genre() {
		return id_genre;
	}
	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	public int getId_theme() {
		return id_theme;
	}
	public void setId_theme(int id_theme) {
		this.id_theme = id_theme;
	}
	public int getId_editeur() {
		return id_editeur;
	}
	public void setId_editeur(int id_editeur) {
		this.id_editeur = id_editeur;
	}
	public int getAge_minimum() {
		return age_minimum;
	}
	public void setAge_minimum(int age_minimum) {
		this.age_minimum = age_minimum;
	}
	public int getNombre_joueurs_minimum() {
		return nombre_joueurs_minimum;
	}
	public void setNombre_joueurs_minimum(int nombre_joueurs_minimum) {
		this.nombre_joueurs_minimum = nombre_joueurs_minimum;
	}
	public int getNombre_joueurs_maximum() {
		return nombre_joueurs_maximum;
	}
	public void setNombre_joueurs_maximum(int nombre_joueurs_maximum) {
		this.nombre_joueurs_maximum = nombre_joueurs_maximum;
	}
}
