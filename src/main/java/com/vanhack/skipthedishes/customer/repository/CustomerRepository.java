package com.vanhack.skipthedishes.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanhack.skipthedishes.customer.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public Customer findByEmailAndPassword(String email,String password);
	
}
