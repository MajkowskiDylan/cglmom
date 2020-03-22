package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.model.Type;


public interface JeuService {
	List<Jeu> findAll();
	Jeu save(Jeu jeu);
	void delete(Jeu jeu);
	List<Jeu> findByFilter(Type type, Genre genre, Theme theme, Editeur editeur, Integer age_minimum, Integer nombre_joueurs);
}
