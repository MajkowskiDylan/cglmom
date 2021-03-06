package com.momcgl.cglmom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	@Query("SELECT g FROM Genre g WHERE " + "g.id = :identifier")
	Genre findByIdentifier(Long identifier);
}