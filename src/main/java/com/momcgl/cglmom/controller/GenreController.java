package com.momcgl.cglmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.momcgl.cglmom.model.Genre;
import com.momcgl.cglmom.service.GenreService;

@Controller
public class GenreController {
	
	@Autowired
	private GenreService genreService;
 
    @RequestMapping(value = { "/genres", "/genres/show" }, method = RequestMethod.GET)
    public String genresList(Model model) {
    	List<Genre> genres = genreService.findAll();
    	
    	model.addAttribute("genres", genres);
        return "genres/show";
    }
}
