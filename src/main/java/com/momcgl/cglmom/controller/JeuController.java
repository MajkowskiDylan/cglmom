package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.service.JeuService;

@Controller
public class JeuController {
	
	@Autowired
	private JeuService jeuService;
 
    @RequestMapping(value = "/jeux", method = RequestMethod.GET)
    public String jeuxList(@RequestParam("type")  Model model) {
    	List<Jeu> jeux = jeuService.findByFilter(null, null, null, null, null, null, null);
    	
    	model.addAttribute("jeux", jeux);
        return "jeux/show";
    }
    
    @RequestMapping(value = "/jeux", method = RequestMethod.POST)
    public String submit(@ModelAttribute("type")String type, @ModelAttribute("genre")String genre, @ModelAttribute("editeur")String editeur, @ModelAttribute("theme")String theme, Model model) {
    	System.out.println(type);
    	System.out.println(genre);
    	System.out.println(editeur);
    	System.out.println(theme);
    	
    	Integer id_type = (type.equals(""))? null :  Integer.parseInt(type);
    	Integer id_genre = (genre.equals(""))? null : Integer.parseInt(genre);
    	Integer id_editeur = (editeur.equals(""))? null : Integer.parseInt(editeur);
    	Integer id_theme = (theme.equals(""))? null : Integer.parseInt(theme);
    	
    	List<Jeu> jeux = jeuService.findByFilter(id_type, id_genre, id_theme, id_editeur, null, null, null);
    	
    	model.addAttribute("jeux", jeux);
        return "jeux/show";
    }
}
