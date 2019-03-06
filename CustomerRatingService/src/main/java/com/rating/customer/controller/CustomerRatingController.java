package com.rating.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rating.customer.configuration.CustomerRatingConfig;
import com.rating.customer.entity.CustomerDO;
import com.rating.customer.service.ICustomerService;

@RestController
@EnableHystrix
public class CustomerRatingController {

	private Logger logger = LoggerFactory.getLogger(CustomerRatingController.class);

	@Autowired
	CustomerRatingConfig rating;

	@Autowired
	ICustomerService service;

	@GetMapping("/customer/{Id}")
	@HystrixCommand(fallbackMethod = "customerDetailById")
	public CustomerDO getCustomerDetailById(@PathVariable("Id") Long Id) {
		return service.getCustomerByID(Id);
	}
	
	public CustomerDO customerDetailById(@PathVariable("Id") Long Id) {
		return service.getCustomerByID(Id);
	}

	@GetMapping("customer/rating/name/{name}")
	public List<CustomerDO> getCustomerDetailByName(@PathVariable String name) {
		logger.info(" Client name is {} ", name);
		return service.findCustomerByName(name);

	}
}
