package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.service.*;

@Controller
public class IndexController {
	
	@Autowired
	private EditeurService editeurService;
	@Autowired
	private GenreService genreService;
	@Autowired
	private ThemeService themeService;
	@Autowired
	private TypeService typeService;

 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Bonjour !");
        
        List<Editeur> editeurs = editeurService.findAll();
        model.addAttribute("editeurs", editeurs);
        
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        
        List<Theme> themes = themeService.findAll();
        model.addAttribute("themes", themes);
        
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return "index";
    }
}
