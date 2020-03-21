package com.momcgl.cglmom.model;

public class Jeu {

	private Long id;
	private String nom;
	private Type type;
	private Genre genre;
	private Theme theme;
	private Editeur editeur;
	
	
	public Jeu(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Jeu(Long id, String nom, Type type, Genre genre, Theme theme, Editeur editeur) {
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.genre = genre;
		this.theme = theme;
		this.editeur = editeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}
	
	

	
	
}
