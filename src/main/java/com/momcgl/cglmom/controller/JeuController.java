package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.service.JeuService;

@Controller
public class JeuController {
	
	@Autowired
	private JeuService jeuService;
 
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Bonjour !");
        return "index";
    }
 
    @RequestMapping(value = { "/jeux", "/jeux/show" }, method = RequestMethod.GET)
    public String jeuxList(Model model) {
    	// avec ça, ça fonctionne pu
    	List<Jeu> jeux = jeuService.findAll();
    	
    	model.addAttribute("jeux", jeux);
        return "jeux/show";
    }
}
