package com.momcgl.cglmom.service;

import java.util.List;

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
	public Type save(Type type) {
		// TODO Auto-generated method stub
		return typeRepository.save(type);
	}

	@Override
	public void delete(Type type) {
		// TODO Auto-generated method stub
		typeRepository.delete(type);
	}




}
