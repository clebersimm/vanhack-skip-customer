package com.vanhack.skipthedishes.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanhack.skipthedishes.customer.entity.Customer;
import com.vanhack.skipthedishes.customer.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public String create(@RequestBody Customer customer) {
		try {
			return customerService.save(customer);
		}catch(Exception e) {
			return null;
		}
	}

}
