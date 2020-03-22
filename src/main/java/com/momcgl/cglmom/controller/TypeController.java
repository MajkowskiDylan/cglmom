package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.service.TypeService;

@Controller
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	public String navAccueil = "<a href=\"/\"> Retour à l'accueil </a>";
 
    @RequestMapping(value = { "/types", "/types/show", "/types/edit" }, method = RequestMethod.GET)
    public String typesList(Model model) {
    	
    	// Visibilite des boutons d'edition et suppression
    	String path = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().getPath();
    	if(path.equals("/types/edit"))
    	{
    		model.addAttribute("visibility", "visible");
    	}
    	else
    	{
    		model.addAttribute("visibility", "hidden");
    	}
    	
    	List<Type> types = typeService.findAll();
    	model.addAttribute("types", types);
        return "types/show";
    }
   
    @RequestMapping(value = "/types/edit/{id}", method = RequestMethod.GET)
    public String typeEdit(Model model, @PathVariable("id") Long id)
    {
    	Type type = typeService.findByIdentifier(id);
    	model.addAttribute("type", type);
    	return "types/edit";
    }
    
    @RequestMapping(value = { "/types/add" }, method = RequestMethod.GET)
	public String typeAdd(Model model) {
		return "types/add";
	}
    
    @RequestMapping(value = "/types/delete/{id}", method = RequestMethod.GET)
    public RedirectView typeDelete(Model model, @PathVariable("id") Long id)
    {
    	try {
    		Type type = typeService.findByIdentifier(id);
        	typeService.delete(type);
		}
		catch(Exception e) {}
    	return new RedirectView("/types/edit");
    }
}
