package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.service.EditeurService;

@Controller
public class EditeurController {
	
	@Autowired
	private EditeurService editeurService;
 
    @RequestMapping(value = { "/editeurs", "/editeurs/show" }, method = RequestMethod.GET)
    public String editeursList(Model model) {
    	List<Editeur> editeurs = editeurService.findAll();
    	
    	model.addAttribute("editeurs", editeurs);
        return "editeurs/show";
    }
}
