package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Editeur;


public interface EditeurService {
	List<Editeur> findAll();
	Editeur save(Editeur editeur);
	void delete(Editeur editeur);
}