package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.repository.JeuRepository;


@Service
public class JeuServiceImpl implements JeuService {
	
	@Autowired
	public JeuRepository jeuRepository;

	@Override
	public List<Jeu> findAll() {
		List<Jeu> jeux = (List<Jeu>) jeuRepository.findAll();
		return jeux;
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
