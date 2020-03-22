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

import com.momcgl.cglmom.model.Editeur;
import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.model.Jeu;
import com.momcgl.cglmom.service.EditeurService;
import com.momcgl.cglmom.service.JeuService;

@Controller
public class EditeurController {
	
	@Autowired
	private EditeurService editeurService;
	
	private JeuService jeuService;
 
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
    
    @RequestMapping(value = "/editeurs/edit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("editeur")String nom_editeur, @ModelAttribute("id")String id, Model model) {
    	Long identifier = Long.parseLong(id);
    	Editeur editeur = editeurService.findByIdentifier(identifier);
    	editeur.setNom_editeur(nom_editeur);
    	editeurService.save(editeur);
    	
    	Editeur editeur2 = editeurService.findByIdentifier(identifier);
    	model.addAttribute("editeur", editeur2);
    	
    	if (editeur.getNom_editeur().equals(editeur2.getNom_editeur()))
    		model.addAttribute("good", "valeur changée avec succes");
    	else	
    		model.addAttribute("good", "echec du changement");

		model.addAttribute("modified", "visible");
    
        return ("/editeurs/edit");
    }
    
    @RequestMapping(value = "/editeurs/edit/{id}", method = RequestMethod.GET)
    public String editeurEdit(Model model, @PathVariable("id") Long id) {
    	Editeur editeur = editeurService.findByIdentifier(id);
    	model.addAttribute("editeur", editeur);
    	
    	model.addAttribute("modified", "hidden");
    	return "editeurs/edit";
    }
    
    @RequestMapping(value = { "/editeurs/add" }, method = RequestMethod.GET)
	public String editeurAdd(Model model) {
		return "editeurs/add";
	}
    
    @RequestMapping(value = "/editeurs/delete/{id}", method = RequestMethod.GET)
    public RedirectView editeurDelete(Model model, @PathVariable("id") Long id) {
    	try {
    		Editeur editeur = editeurService.findByIdentifier(id);
        	List<Jeu> jeux = jeuService.findByFilter(null, null, null, editeur, null, null);
            for(Jeu j : jeux)
            {
                jeuService.delete(j);
            }
            editeurService.delete(editeur);
		}
		catch(Exception e) {}
    	// Suppresion d'un éditeur = suppression de tous les jeux avec l'editeur là
    	return new RedirectView("/editeurs/edit");
    }
}
