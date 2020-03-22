package com.momcgl.cglmom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

	@Query("SELECT t FROM Theme t WHERE " + "t.id = :identifier")
	Theme findByIdentifier(long identifier);
}