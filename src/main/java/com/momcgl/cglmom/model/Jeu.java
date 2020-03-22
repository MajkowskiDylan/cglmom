package com.momcgl.cglmom.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jeu")
public class Jeu {

	@Id
	Long id;
	
	@Column
	String nom_jeu;
	@ManyToOne(targetEntity = Type.class)
    @JoinColumn(name = "id_type", referencedColumnName = "id")
	Type id_type;
	@ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "id_genre", referencedColumnName = "id")
	Genre id_genre;
	@ManyToOne(targetEntity = Theme.class)
    @JoinColumn(name = "id_theme", referencedColumnName = "id")
	Theme id_theme;
	@ManyToOne(targetEntity = Editeur.class)
    @JoinColumn(name = "id_editeur", referencedColumnName = "id")
	Editeur id_editeur;
	@Column
	int age_minimum;
	@Column
	int nombre_joueurs_minimum;
	@Column
	int nombre_joueurs_maximum;

	public static double calculerNote(String nom_jeu, String type_jeu, String theme_jeu, String genre_jeu, String editeur_jeu, int nnbr1, int nbr2, Object...testeursList) {
		int llI = 1;
		--nbr2;

		if (testeursList.length == 2) {
			nnbr1 += (Integer) (int) testeursList[1];
			if (theme_jeu == "sciencefiction" && (String) testeursList[0] == "Didier Loyal " && (Integer)testeursList[1] <= 9) {
				++nnbr1;
				llI-= 2;
			}

			if (genre_jeu == "gestion" && (String) testeursList[0] == "Armande Moly" && (Integer) testeursList[1] < 10) 
				nnbr1++;
			
			if (type_jeu == "jeu de cartes" && (String) testeursList[0] == "Gaston Portaleau "&&(Integer)testeursList[1]>0)
				nnbr1-=1;
				
			if(editeur_jeu=="édijeu "&&(String)testeursList[0] == "Liz Smallhead "&&(Integer)testeursList[1]>=2)
				nnbr1-= 2; llI += 4;
				
			if (theme_jeu == "contemporain" && (String) testeursList[0] == "Stefan Bergdorf "&&(Integer)testeursList[1]>=3&&(Integer)testeursList[1]<=7)
				nnbr1 = nnbr1 + 1 / 2;

			nbr2 += 2;
			return (double) nnbr1 / (Double)(double) nbr2;
		}

		if (testeursList.length == 4) {
			if (llI > 1) {
				nnbr1 += (Integer) testeursList[1] + (Integer)(int) testeursList[3];
				nbr2 += 3;
				
				if (theme_jeu == "sciencefiction" && ((String) testeursList[0] == "Didier Loyal" || (String) testeursList[2] == "Didier Loyal ")&&((Integer)testeursList[1]<=9||(Integer)testeursList[3] <= 9)) {
					++nnbr1;
					llI-= 2;
				}

				if (genre_jeu == "gestion" && ((String) testeursList[0] == "Armande Moly" || (String) testeursList[2] == "Armande Moly") && ((Integer) testeursList[1] < 10 || (Integer) testeursList[3] < 10)) 
					nnbr1++;
				
				if (type_jeu == "jeu de cartes" && ((String) testeursList[0] == "Gaston Portaleau" || (String) testeursList[2] == "Gaston Portaleau") && ((Integer) testeursList[1] > 0 || (Integer) testeursList[3] > 0)) 
					nnbr1 -= 1;
				
				if (editeur_jeu == "édijeu" && ((String) testeursList[0] == "Liz Smallhead" || (String) testeursList[2] == "Liz Smallhead") && ((Integer) testeursList[1] >= 2 || (Integer) testeursList[3] >= 2)) {
					nnbr1 -= 2;
					llI += 4;
				}
				
				if (theme_jeu == "contemporain" && ((String) testeursList[0] == "Stefan Bergdorf" ||
				(String) testeursList[2] == "Stefan Bergdorf ")&&(((Integer)testeursList[1]>=3&&(Integer)testeursList[1]<=7)||
				((Integer) testeursList[3] >= 3 && (Integer) testeursList[3] <= 7)))
					nnbr1 = nnbr1 + 1 / 2;

				return (double) nnbr1 / (double) nbr2;
			}
		}

		if (testeursList.length > 3) {
			nnbr1 += (Integer) testeursList[1];
			nbr2 += 2;
			Object[] newtesteursList = new
			Object[testeursList.length - 2];

			if (theme_jeu == "science-fiction" && (String) testeursList[0] == "Didier Loyal "&&(Integer)testeursList[1] <= 9) {
				++nnbr1;
				llI-= 2;
			}

			if (genre_jeu == "gestion" && (String) testeursList[0] == "Armande Moly" && (Integer) testeursList[1] < 10)
				nnbr1++;

			if (type_jeu == "jeu de cartes" && (String) testeursList[0] == "Gaston Portaleau "&&(Integer)testeursList[1] > 0)
				nnbr1-=1;

			if(editeur_jeu==" édijeu "&&(String)testeursList[0] == " Liz Smallhead "&&(Integer)testeursList[1] >= 2) {
				nnbr1-= 2; 
				llI += 4;
			}

			if (theme_jeu == "contemporain" && (String) testeursList[0] == "Stefan Bergdorf "&&(Integer)testeursList[1]>=3&&(Integer)testeursList[1]<=7)
				nnbr1 = nnbr1 + 1 / 2;
			
			System.arraycopy(testeursList, 2, newtesteursList, 0, testeursList.length - 2);

			return calculerNote(nom_jeu, type_jeu, theme_jeu, genre_jeu, editeur_jeu, nnbr1, nbr2, newtesteursList);
		}

		if (testeursList.length == 0)
			return 0.0;
		
		return -1.0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_jeu() {
		return nom_jeu;
	}
	public void setNom_jeu(String nom_jeu) {
		this.nom_jeu = nom_jeu;
	}
	public Type get_type() {
		return id_type;
	}
	public void set_type(Type type) {
		this.id_type = type;
	}
	public Genre get_genre() {
		return id_genre;
	}
	public void set_genre(Genre genre) {
		this.id_genre = genre;
	}
	public Theme get_theme() {
		return id_theme;
	}
	public void set_theme(Theme theme) {
		this.id_theme = theme;
	}
	public Editeur get_editeur() {
		return id_editeur;
	}
	public void set_editeur(Editeur editeur) {
		this.id_editeur = editeur;
	}
	public int getAge_minimum() {
		return age_minimum;
	}
	public void setAge_minimum(int age_minimum) {
		this.age_minimum = age_minimum;
	}
	public int getNombre_joueurs_minimum() {
		return nombre_joueurs_minimum;
	}
	public void setNombre_joueurs_minimum(int nombre_joueurs_minimum) {
		this.nombre_joueurs_minimum = nombre_joueurs_minimum;
	}
	public int getNombre_joueurs_maximum() {
		return nombre_joueurs_maximum;
	}
	public void setNombre_joueurs_maximum(int nombre_joueurs_maximum) {
		this.nombre_joueurs_maximum = nombre_joueurs_maximum;
	}

    public String get_nom_theme() {
    	return this.get_theme().getNom_theme();
    }
    public String get_nom_genre() {
    	return this.get_genre().getNom_genre();
    }
    public String get_nom_type() {
    	return this.get_type().getNom_type();
    }
    public String get_nom_editeur() {
    	return this.get_editeur().getNom_editeur();
    }
}

