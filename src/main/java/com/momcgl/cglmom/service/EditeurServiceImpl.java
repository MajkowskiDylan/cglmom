package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.repository.EditeurRepository;

@Service
public class EditeurServiceImpl implements EditeurService {
	
	@Autowired
	public EditeurRepository editeurRepository;

	@Override
	public List<Editeur> findAll() {
		List<Editeur> editeurs = (List<Editeur>) editeurRepository.findAll();
		return editeurs;
	}

	@Override
	public Editeur save(Editeur editeur) {
		return editeurRepository.save(editeur);
	}
	
	@Override
	public void delete(Editeur editeur) {
		editeurRepository.delete(editeur);
	}
}