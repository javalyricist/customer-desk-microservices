package com.rating.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rating.customer.entity.CustomerDO;
@Service
public interface ICustomerService {
	public void save(CustomerDO customerDO);

	public CustomerDO getCustomerByID(Long Id);
	
	public List<CustomerDO> findCustomerByName(String name);
}
