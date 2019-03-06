package com.rating.customer.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.rating.customer.entity.CustomerDO;

@Service
public interface ICustomerRepository extends CrudRepository<CustomerDO, Long>{

	List<CustomerDO> findAllByName(String name);

}
