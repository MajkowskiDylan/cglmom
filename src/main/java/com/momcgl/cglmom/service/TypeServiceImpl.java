package com.momcgl.cglmom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.repository.TypeRepository;

@Service
public class TypeServiceImpl  implements TypeService{
	@Autowired
	public TypeRepository typeRepository;

	@Override
	public List<Type> findAll() {
		List<Type> types = typeRepository.findAll();
		return types;
	}
	
	@Override
	public Type findByIdentifier(Long identifier) {
		Type type = typeRepository.findByIdentifier(identifier);
		return type;
	}

	@Override
	public Type save(Type type) {
		return typeRepository.save(type);
	}

	@Override
	public void delete(Type type) {
		typeRepository.delete(type);
	}
}
