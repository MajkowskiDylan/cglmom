package com.momcgl.cglmom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.Editeur;

@Repository
public interface EditeurRepository extends JpaRepository<Editeur, Long> {

	@Query("SELECT e FROM Editeur e WHERE " + "e.id = :identifier")
	Editeur findByIdentifier(Long identifier);

}
