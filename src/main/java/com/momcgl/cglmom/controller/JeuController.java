package com.momcgl.cglmom.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.service.EditeurService;
import com.momcgl.cglmom.service.GenreService;
import com.momcgl.cglmom.service.JeuService;
import com.momcgl.cglmom.service.ThemeService;
import com.momcgl.cglmom.service.TypeService;

@Controller
public class JeuController {
	
	@Autowired
	private JeuService jeuService;	
	@Autowired
	private ThemeService themeService;	
	@Autowired
	private GenreService genreService;	
	@Autowired
	private TypeService typeService;	
	@Autowired
	private EditeurService editeurService;
 
    @RequestMapping(value = "/jeux", method = RequestMethod.POST)
    public String submit(@ModelAttribute("age_Minimume")String age_Minimume,@ModelAttribute("nombre_de_joueurs")String nombre_de_joueurs,@ModelAttribute("type")String type, @ModelAttribute("genre")String genre, @ModelAttribute("editeur")String editeur, @ModelAttribute("theme")String theme, Model model) {

    	
    	Type id_type = (type.equals(""))? null :  typeService.findByIdentifier(Integer.parseInt(type));
    	Genre id_genre = (genre.equals(""))? null : genreService.findByIdentifier(Integer.parseInt(genre));
    	Editeur id_editeur = (editeur.equals(""))? null : editeurService.findByIdentifier(Integer.parseInt(editeur));
    	Theme id_theme = (theme.equals(""))? null : themeService.findByIdentifier(Integer.parseInt(theme));
    	
    	Integer age_Mini = (age_Minimume.equals(""))? null: Integer.parseInt(age_Minimume);
    	Integer nb_joueurs = (nombre_de_joueurs.equals(""))? null: Integer.parseInt(nombre_de_joueurs);
    	
    	List<Jeu> jeux = jeuService.findByFilter(id_type, id_genre, id_theme, id_editeur, age_Mini, nb_joueurs);
    	model.addAttribute("jeux", jeux);
    	model.addAttribute("visibility", "hidden");
        return "jeux/show";
    }
    
    /*
         @RequestMapping(value = "/jeux/edit", method = RequestMethod.POST)
    public RedirectView submit(
    		@ModelAttribute("id")String id, 
    		@ModelAttribute("nom")String nom_jeu, 
    		@ModelAttribute("type")String type_jeu, 
    		Model model) {
    	Long identifier = Long.parseLong(id);
    	Jeu jeu = jeuService.findByIdentifier(identifier);
    	jeu.setNom_jeu(nom_jeu);
    	// Faire pour tous les champs !!
    	jeuService.save(jeu);
        return new RedirectView("/jeux/edit");
    }
     */
    
    
    @RequestMapping(value = { "/jeux/show", "/jeux/edit" }, method = RequestMethod.GET)
    public String genresList(Model model) {
    	
    	// Visibilite des boutons d'edition et suppression
    	String path = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().getPath();
    	if(path.equals("/jeux/edit")) {
    		model.addAttribute("visibility", "visible");
    	}
    	else {
    		model.addAttribute("visibility", "hidden");
    	}
    	
    	List<Jeu> jeux = jeuService.findByFilter(null, null, null, null, null, null);
    	model.addAttribute("jeux", jeux);
    	
        return "jeux/show";
    }
    
    @RequestMapping(value = "/jeux/edit/{id}", method = RequestMethod.GET)
    public String jeuEdit(Model model)
    {
    	List<Editeur> editeurs = editeurService.findAll();
        model.addAttribute("editeurs", editeurs);
        
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        
        List<Theme> themes = themeService.findAll();
        model.addAttribute("themes", themes);
        
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
    	return "jeux/edit";
    }
    
    @RequestMapping(value = { "/jeux/add" }, method = RequestMethod.GET)
	public String jeuAdd(Model model) {
    	List<Editeur> editeurs = editeurService.findAll();
        model.addAttribute("editeurs", editeurs);
        
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        
        List<Theme> themes = themeService.findAll();
        model.addAttribute("themes", themes);
        
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
		return "jeux/add";
	}
    
    @RequestMapping(value = "/jeux/delete/{id}", method = RequestMethod.GET)
    public RedirectView jeuDelete(Model model, @PathVariable("id") Long id) {
    	try {
    		System.out.println("hrledfekl" + id.toString());
    		Jeu jeu = jeuService.findByIdentifier((long)id);
        	jeuService.delete(jeu);
        	// deleteMyGames
		}
		catch(Exception e) {}
    	return new RedirectView("/jeux/edit");
    }
}
