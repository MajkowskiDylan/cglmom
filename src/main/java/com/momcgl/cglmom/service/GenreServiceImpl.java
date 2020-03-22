package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.repository.GenreRepository;


@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	public GenreRepository genreRepository;

	@Override
	public List<Genre> findAll() {
		List<Genre> genres = (List<Genre>) genreRepository.findAll();
		return genres;
	}
	
	@Override
	public Genre findByIdentifier(Long identifier) {
		Genre genre = genreRepository.findByIdentifier(identifier);
		return genre;
	}

	@Override
	public Genre save(Genre genre) {
		// TODO Auto-generated method stub
		return genreRepository.save(genre);
	}
	@Override
	public void delete(Genre genre) {
		genreRepository.delete(genre);
	}
}