package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.repository.JeuRepository;

@Service
public class JeuServiceImpl implements JeuService {
	// Decommenter Autowired, et puis vous aurez le bug consider defining bean qu'il faut resoudre
	//@Autowired
	private JeuRepository jeuRepository;

	@Override
	public List<Jeu> findAll() {
		return (List<Jeu>) jeuRepository.findAll();
	}

	@Override
	public Jeu save(Jeu jeu) {
		// TODO Auto-generated method stub
		return jeuRepository.save(jeu);
	}

	@Override
	public void delete(Jeu jeu) {
		jeuRepository.delete(jeu);
	}

}
