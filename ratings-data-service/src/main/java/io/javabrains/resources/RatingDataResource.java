package io.javabrains.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.models.Rating;
import io.javabrains.models.UserRatings;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataResource {
	
	@GetMapping("{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@GetMapping("users/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId) {
		return new UserRatings (Arrays.asList(new Rating("1234", 4), new Rating("5678", 3)));
	}
}
