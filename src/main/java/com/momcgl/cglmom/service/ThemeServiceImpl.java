package com.momcgl.cglmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.repository.ThemeRepository;


@Service
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	public ThemeRepository themeRepository;

	@Override
	public List<Theme> findAll() {
		List<Theme> themes = (List<Theme>) themeRepository.findAll();
		return themes;
	}

	@Override
	public Theme findByIdentifier(long identifier) {
		Theme theme = themeRepository.findByIdentifier(identifier);
		return theme;
	}
	
	@Override
	public Theme save(Theme theme) {
		// TODO Auto-generated method stub
		return themeRepository.save(theme);
	}
	@Override
	public void delete(Theme theme) {
		themeRepository.delete(theme);
	}
}
