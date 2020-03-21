package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.model.Genre;


public interface EditeurService {
	List<Editeur> findAll();
	Editeur save(Editeur editeur);
	void delete(Editeur editeur);
}