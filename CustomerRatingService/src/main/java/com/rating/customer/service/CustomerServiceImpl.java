package com.rating.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.customer.entity.CustomerDO;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public void save(CustomerDO customerDO) {
		customerRepository.save(customerDO);
	}

	@Override
	public CustomerDO getCustomerByID(Long Id) {
		return customerRepository.findById(Id).get();
	}

	@Override
	public List<CustomerDO> findCustomerByName(String name) {
		return customerRepository.findAllByName(name);
	}
	
	

}
