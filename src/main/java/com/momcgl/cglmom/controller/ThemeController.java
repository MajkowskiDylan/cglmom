package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Theme;
import com.momcgl.cglmom.service.ThemeService;

@Controller
public class ThemeController {
	
	@Autowired
	private ThemeService themeService;
 
    @RequestMapping(value = { "/themes", "/themes/show" }, method = RequestMethod.GET)
    public String themesList(Model model) {
    	List<Theme> themes = themeService.findAll();
    	
    	model.addAttribute("themes", themes);
        return "themes/show";
    }
}
