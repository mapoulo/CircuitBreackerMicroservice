package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	
	
	@RequestMapping("/getmovies/{movie}")
	public String getMovies(@PathVariable String movie) {
		return "The chosen movie is "+movie;
	}

}
