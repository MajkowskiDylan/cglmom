package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String submit(@ModelAttribute("type")String type, @ModelAttribute("genre")String genre, @ModelAttribute("editeur")String editeur, @ModelAttribute("theme")String theme, Model model) {
        
    	Type id_type = (type.equals(""))? null :  typeService.findByIdentifier(Integer.parseInt(type));
    	Genre id_genre = (genre.equals(""))? null : genreService.findByIdentifier(Integer.parseInt(genre));
    	Editeur id_editeur = (editeur.equals(""))? null : editeurService.findByIdentifier(Integer.parseInt(editeur));
    	Theme id_theme = (theme.equals(""))? null : themeService.findByIdentifier(Integer.parseInt(theme));
    	
    	List<Jeu> jeux = jeuService.findByFilter(id_type, id_genre, id_theme, id_editeur, null, null, null);
    	model.addAttribute("jeux", jeux);
    	
        return "jeux/show";
    }
    
    @RequestMapping(value = "/jeux/edit/{id}", method = RequestMethod.GET)
    public String jeuEdit(Model model)
    {
    	return "jeux/edit";
    }
    
    @RequestMapping(value = { "/jeux/add" }, method = RequestMethod.GET)
	public String jeuAdd(Model model) {
		return "jeux/add";
	}
}
