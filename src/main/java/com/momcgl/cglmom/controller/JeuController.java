package com.momcgl.cglmom.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.model.Person;

@Controller
public class JeuController {
	private static List<Jeu> jeux = new ArrayList<Jeu>();
	 
    static {
    	jeux.add(new Jeu((long) 1.0, "Gates"));
    	jeux.add(new Jeu((long) 2.0, "Wow"));
    }
 
    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
 
        return "index";
    }
 
    @RequestMapping(value = { "/jeux", "/jeux/show" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("jeux", jeux);
 
        return "jeux/show";
    }
}
