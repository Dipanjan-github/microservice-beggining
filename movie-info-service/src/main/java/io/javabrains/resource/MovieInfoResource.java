package io.javabrains.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	@GetMapping("{movieId}")
	public Movie getCatalog(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test movie name");
	}

}
