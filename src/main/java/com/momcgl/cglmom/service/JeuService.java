package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.momcgl.cglmom.model.Jeu;


public interface JeuService {
	List<Jeu> findAll();
	Jeu save(Jeu jeu);
	void delete(Jeu jeu);
	List<Jeu> findByFilter(Integer id_type, Integer id_genre, Integer theme, Integer editeur, Integer age_minimum, Integer nombre_joueurs_maximum, Integer nombre_joueurs_minimum);
}
