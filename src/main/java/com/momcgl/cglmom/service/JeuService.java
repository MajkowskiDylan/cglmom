package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Jeu;

public interface JeuService {
	List<Jeu> findAll();
	Jeu save(Jeu jeu);
	void delete(Jeu jeu);
}
