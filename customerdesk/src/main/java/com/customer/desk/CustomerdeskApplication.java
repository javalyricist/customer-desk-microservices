package com.customer.desk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.customer.desk.service")
@EnableDiscoveryClient
public class CustomerdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerdeskApplication.class, args);
	}

	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
