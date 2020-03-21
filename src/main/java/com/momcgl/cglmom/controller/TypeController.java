package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Type;
import com.momcgl.cglmom.service.TypeService;

@Controller
public class TypeController {
	@Autowired
	private TypeService typeService;
 
    @RequestMapping(value = { "/types", "/types/show" }, method = RequestMethod.GET)
    public String typesList(Model model) {
    	List<Type> types = typeService.findAll();
    	model.addAttribute("types", types);
        return "types/show";
    }
}
