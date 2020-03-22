package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.model.Type;
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
		return jeuRepository.save(jeu);
	}

	@Override
	public void delete(Jeu jeu) {
		jeuRepository.delete(jeu);
	}

	@Override
	public List<Jeu> findByFilter(Type type, Genre genre, Theme theme, Editeur editeur, Integer age_minimum,
			Integer nombre_joueurs) {
		System.out.println(nombre_joueurs);
		List<Jeu> jeux = (List<Jeu>) jeuRepository.findByFilter(type, genre, theme, editeur, age_minimum, nombre_joueurs);
		return jeux;
	}

	@Override
	public Jeu findByIdentifier(Long identifier) {
		Jeu jeu = jeuRepository.findByIdentifier(identifier);
		return jeu;
	}
}
