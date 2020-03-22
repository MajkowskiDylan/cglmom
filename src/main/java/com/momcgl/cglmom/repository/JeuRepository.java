package com.momcgl.cglmom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.momcgl.cglmom.model.*;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {
	@Query("SELECT j FROM Jeu j WHERE " + "j.id = :identifier")
	Jeu findByIdentifier(Long identifier);
	
	@Query(value = "DELETE FROM jeu WHERE id_editeur = ?", nativeQuery = true)
    void deleteByIdEditeur(int idEditeur);

	@Query("SELECT game FROM Jeu game WHERE" +
			"(:id_type is null or game.id_type = :id_type)" +
			"and (:id_genre is null or game.id_genre = :id_genre)" +
			"and (:id_theme is null or game.id_theme = :id_theme)" +
			"and (:id_editeur is null or game.id_editeur = :id_editeur)" +
			"and (:age_minimum is null or game.age_minimum <= :age_minimum)" +
			"and (:nombre_joueurs  is null or game.nombre_joueurs_minimum  <= :nombre_joueurs )"+
			"and (:nombre_joueurs  is null or game.nombre_joueurs_maximum  >= :nombre_joueurs )")
    List<Jeu> findByFilter(
    		@Param("id_type") Type type, 
    		@Param("id_genre") Genre genre,
            @Param("id_theme") Theme theme, 
            @Param("id_editeur") Editeur editeur,
            @Param("age_minimum") Integer age_minimum,
            @Param("nombre_joueurs") Integer nombre_joueurs);

}