package io.javabrains.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.models.CatalogItem;
import io.javabrains.models.Movie;
import io.javabrains.models.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRatings userRatings = restTemplate.getForObject("http://ratings-data-service/ratingdata/users/" + userId, UserRatings.class);

		return userRatings.getRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "test movie", rating.getRating());
		}).collect(Collectors.toList());
	}
	
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}
