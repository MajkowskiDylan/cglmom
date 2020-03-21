package com.momcgl.cglmom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.*;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {
	
	@Query(value = "DELETE FROM jeu WHERE id_editeur = ?", nativeQuery = true)
    void deleteByIdEditeur(int idEditeur);

	@Query("SELECT game FROM Jeu game WHERE" +
			"(:id_type is null or game.id_type = :id_type)" +
			"and (:id_genre is null or game.id_genre = :id_genre)" +
			"and (:id_theme is null or game.id_theme = :id_theme)" +
			"and (:id_editeur is null or game.id_editeur = :id_editeur)" +
			"and (:age_minimum is null or game.age_minimum = :age_minimum)" +
			"and (:nombre_joueurs_minimum  is null or game.nombre_joueurs_minimum  = :nombre_joueurs_minimum )"+
			"and (:nombre_joueurs_maximum  is null or game.nombre_joueurs_maximum  = :nombre_joueurs_maximum )")
    List<Jeu> findByFilter(
    		@Param("id_type") Integer id_type, 
    		@Param("id_genre") Integer id_genre,
            @Param("id_theme") Integer theme, 
            @Param("id_editeur") Integer editeur,
            @Param("age_minimum") Integer age_minimum,
            @Param("nombre_joueurs_maximum") Integer nombre_joueurs_maximum,
            @Param("nombre_joueurs_minimum") Integer nombre_joueurs_minimum);

}