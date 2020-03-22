package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Theme;


public interface ThemeService {
	List<Theme> findAll();
	Theme save(Theme theme);
	void delete(Theme theme);
	Theme findByIdentifier(long identifier);
}