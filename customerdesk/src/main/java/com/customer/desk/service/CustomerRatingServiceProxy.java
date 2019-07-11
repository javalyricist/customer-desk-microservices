package com.customer.desk.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.desk.entity.CustomerRating;

//@FeignClient(name = "customer-rating", url = "http://localhost:8100")
@RibbonClient(name = "customer-rating")
@FeignClient(name = "customer-rating")
//@FeignClient(name= "zuul-api-gateway-server")
public interface CustomerRatingServiceProxy {

	//@GetMapping("/customer/{Id}")
	@GetMapping("customer-rating/customer/{Id}")
	public CustomerRating retriveCustomerRatingByID(@PathVariable long Id);
	//@GetMapping("/customer/rating/name/{name}")
	@GetMapping("customer-rating/customer/rating/name/{name}")
	public List<CustomerRating> retriveCustomerRatingByName(@PathVariable String name);
}
