package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.service.EditeurService;

@Controller
public class EditeurController {
	
	@Autowired
	private EditeurService editeurService;
 
    @RequestMapping(value = { "/editeurs", "/editeurs/show", "/editeurs/edit" }, method = RequestMethod.GET)
    public String editeursList(Model model) {
    	
    	// Visibilite des boutons d'edition et suppression
    	String path = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().getPath();
    	if(path.equals("/editeurs/edit")) {
    		model.addAttribute("visibility", "visible");
    	}
    	else {
    		model.addAttribute("visibility", "hidden");
    	}
    	
    	List<Editeur> editeurs = editeurService.findAll();
    	model.addAttribute("editeurs", editeurs);
        return "editeurs/show";
    }
    
    @RequestMapping(value = "/editeurs/edit/{id}", method = RequestMethod.GET)
    public String editeurEdit(Model model, @PathVariable("id") Long id) {
    	Editeur editeur = editeurService.findByIdentifier(id);
    	model.addAttribute("editeur", editeur);
    	return "editeurs/edit";
    }
    
    @RequestMapping(value = { "/editeurs/add" }, method = RequestMethod.GET)
	public String editeurAdd(Model model) {
		return "editeurs/add";
	}
}
