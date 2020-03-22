package com.momcgl.cglmom.service;

import java.util.List;

import com.momcgl.cglmom.model.Type;

public interface TypeService {
	List<Type> findAll();
	Type findByIdentifier(long identifier);
	Type save(Type type);
	void delete(Type type);
}
