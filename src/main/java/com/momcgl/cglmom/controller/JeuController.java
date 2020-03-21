package com.momcgl.cglmom.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    	//List<Jeu> jeux = jeuService.findAll();
    	
    	// TEST : avec ça, ça fonctionne
    	ArrayList jeux = new ArrayList();
    	Jeu j = new Jeu((long)3.0, "KEK");
    	Jeu h = new Jeu((long)4.0, "FUU");
    	jeux.add(j);
    	jeux.add(h);
    	
    	model.addAttribute("jeux", jeux);
        return "jeux/show";
    }
}
