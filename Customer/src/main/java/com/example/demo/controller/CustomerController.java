package com.example.demo.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.commonHyStrixCommand.MyHystrixCommad;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	RestTemplate template;
	
	@RequestMapping("/getcustomers/{movie}")
	public String getMovies(@PathVariable String movie)throws Exception {
		MyHystrixCommad<String>  theCommand = new MyHystrixCommad<String>("",()->{return template.getForObject("http://MOVIES-SERVICE/movies/getmovies/"+movie, String.class);}, ()->{return "The fallback method executed";});
		Future<String> theFuture = theCommand.queue();
		return theFuture.get();
	}
	
	
}
