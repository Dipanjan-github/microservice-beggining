package io.javabrains.models;

import java.util.List;

public class UserRatings {
	
	private List<Rating> ratings;
	
	public UserRatings() {
		super();
	}

	public UserRatings(List<Rating> ratings) {
		super();
		this.ratings = ratings;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
}
