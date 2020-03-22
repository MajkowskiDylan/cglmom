package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Genre;


public interface GenreService {
	List<Genre> findAll();
	Genre save(Genre genre);
	void delete(Genre genre);
	Genre findByIdentifier(Long identifier);
}