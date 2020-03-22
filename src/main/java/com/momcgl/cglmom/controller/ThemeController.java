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

import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.service.ThemeService;

@Controller
public class ThemeController {
	
	@Autowired
	private ThemeService themeService;
 
    @RequestMapping(value = { "/themes", "/themes/show", "/themes/edit" }, method = RequestMethod.GET)
    public String themesList(Model model) {
    	
    	// Visibilite des boutons d'edition et suppression
    	String path = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().getPath();
    	if(path.equals("/themes/edit")) {
    		model.addAttribute("visibility", "visible");
    	}
    	else {
    		model.addAttribute("visibility", "hidden");
    	}
    	
    	List<Theme> themes = themeService.findAll();
    	model.addAttribute("themes", themes);
        return "themes/show";
    }
    
    @RequestMapping(value = { "/themes/edit/{id}" }, method = RequestMethod.GET)
    public String themeEdit(Model model, @PathVariable("id") Long id) {
    	Theme theme = themeService.findByIdentifier(id);
    	model.addAttribute("theme", theme);
    	return "themes/edit";
    }
    
    @RequestMapping(value = { "/themes/add" }, method = RequestMethod.GET)
	public String themeAdd(Model model) {
		return "themes/add";
	}
    
    @RequestMapping(value = "/themes/delete/{id}", method = RequestMethod.GET)
    public RedirectView tehmeDelete(Model model, @PathVariable("id") Long id) {
    	try {
    		Theme theme = themeService.findByIdentifier(id);
        	themeService.delete(theme);
		}
		catch(Exception e) {}
    	return new RedirectView("/themes/edit");
    }
}
