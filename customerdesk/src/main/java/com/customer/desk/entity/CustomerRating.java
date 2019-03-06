package com.customer.desk.entity;

public class CustomerRating {
	private Long Id;
	private String name;
	private String rating;
	private String ratingSource;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRatingSource() {
		return ratingSource;
	}

	public void setRatingSource(String ratingSource) {
		this.ratingSource = ratingSource;
	}

}
