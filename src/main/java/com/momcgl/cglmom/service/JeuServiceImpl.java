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

	@Override
	public List<Jeu> findByFilter(Integer id_type, Integer id_genre, Integer theme, Integer editeur, Integer age_minimum,
			Integer nombre_joueurs_maximum, Integer nombre_joueurs_minimum) {
		List<Jeu> jeux = (List<Jeu>) jeuRepository.findByFilter(id_type, id_genre, theme, editeur, age_minimum, nombre_joueurs_maximum, nombre_joueurs_minimum);
		return jeux;
	}
}
