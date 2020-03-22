package com.momcgl.cglmom.controller;

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

import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.service.GenreService;

@Controller
public class GenreController {
	
	@Autowired
	private GenreService genreService;
 
    @RequestMapping(value = { "/genres", "/genres/show", "/genres/edit" }, method = RequestMethod.GET)
    public String genresList(Model model) {
    	// Visibilite des boutons d'edition et suppression
    	String path = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().getPath();
    	if(path.equals("/genres/edit")) {
    		model.addAttribute("visibility", "visible");
    	}
    	else {
    		model.addAttribute("visibility", "hidden");
    	}
    	
    	List<Genre> genres = genreService.findAll();
    	model.addAttribute("genres", genres);
        return "genres/show";
    }
    
    @RequestMapping(value = "/genres/edit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("genre")String nom_genre, @ModelAttribute("id")String id, Model model) {
    	
    	Long identifier = Long.parseLong(id);
    	
    	Genre genre = genreService.findByIdentifier(identifier);
    	genre.setNom_genre(nom_genre);
    	genreService.save(genre);
    	
    	Genre genre2 = genreService.findByIdentifier(identifier);
    	model.addAttribute("genre", genre2);
    	
    	if (genre.getNom_genre().equals(genre2.getNom_genre()))
    		model.addAttribute("good", "valeur changée avec succes");
    	else	
    		model.addAttribute("good", "echec du changement");

		model.addAttribute("modified", "visible");
    	
        return ("/genres/edit");
    }
    
    @RequestMapping(value = "/genres/edit/{id}", method = RequestMethod.GET)
    public String genreEdit(Model model, @PathVariable("id") Long id) {
    	Genre genre = genreService.findByIdentifier(id);
    	model.addAttribute("genre", genre);
    	
    	model.addAttribute("modified", "hidden");
    	
    	return "genres/edit";
    }
    
    @RequestMapping(value = { "/genres/add" }, method = RequestMethod.GET)
	public String genreAdd(Model model) {
		return "genres/add";
	}
    
    @RequestMapping(value = "/genres/delete/{id}", method = RequestMethod.GET)
    public RedirectView genreDelete(Model model, @PathVariable("id") Long id) {
    	try {
        	Genre genre = genreService.findByIdentifier(id);
        	genreService.delete(genre);
		}
		catch(Exception e) {}
    	return new RedirectView("/genres/edit");
    }
}
