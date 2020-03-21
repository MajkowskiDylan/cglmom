package com.momcgl.cglmom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.Editeur;

@Repository
public interface EditeurRepository extends JpaRepository<Editeur, Long> {

}
