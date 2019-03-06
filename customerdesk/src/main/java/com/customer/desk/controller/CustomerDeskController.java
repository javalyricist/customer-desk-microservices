package com.customer.desk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.customer.desk.entity.CustomerRating;
import com.customer.desk.entity.Rating;
import com.customer.desk.service.CustomerRatingServiceProxy;
import com.customer.desk.until.RatingUtill.RatingEnum;

@RestController
public class CustomerDeskController {

	private Logger logger = LoggerFactory.getLogger(CustomerDeskController.class);

	@Autowired
	private CustomerRatingServiceProxy customerRating;

	@GetMapping("customer/{Id}")
	public CustomerRating getRatingByCustomerId(@PathVariable long Id) {
		return customerRating.retriveCustomerRatingByID(Id);

	}

	@GetMapping("customer/rating/name/{name}")
	public Rating getRatingByCustomerName(@PathVariable String name) {
		Integer rating = 0;
		Rating ratingCustomer = new Rating();
		ratingCustomer.setName(name);

		for (CustomerRating customer : customerRating.retriveCustomerRatingByName(name)) {
			rating = rating + (RatingEnum.valueOf(customer.getRating()).rating());
		}
		logger.info("total rating is {}", rating);
		ratingCustomer.setRating(String.valueOf(rating));
		return ratingCustomer;
	}
}
