package com.momcgl.cglmom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.Type;

@Repository
public interface TypeRepository  extends JpaRepository<Type, Long>{

	@Query("SELECT t FROM Type t WHERE " + "t.id = :identifier")
	Type findByIdentifier(@Param("identifier") Long identifier);
}
