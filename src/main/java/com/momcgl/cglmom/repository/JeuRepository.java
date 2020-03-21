package com.momcgl.cglmom.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.Jeu;

@Repository
public interface JeuRepository extends CrudRepository<Jeu,Long>{}