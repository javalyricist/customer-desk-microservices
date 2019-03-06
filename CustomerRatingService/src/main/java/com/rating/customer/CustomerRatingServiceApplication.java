package com.rating.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRatingServiceApplication.class, args);
	}

	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
