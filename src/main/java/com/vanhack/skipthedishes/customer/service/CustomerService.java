package com.vanhack.skipthedishes.customer.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vanhack.skipthedishes.customer.entity.Customer;
import com.vanhack.skipthedishes.customer.repository.CustomerRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	public String save(Customer customer) {
		customerRepository.save(customer);
		return generateToken(customer.getEmail(), customer.getPassword());
	}

	//TODO must check when the spring security is implemented to remove this code
	private String generateToken(String email, String password) {
		String token = Jwts.builder().setSubject(email).claim("role", "user").setIssuedAt(Calendar.getInstance().getTime())
				.signWith(SignatureAlgorithm.HS256, password).compact();

		return token;
	}
}
