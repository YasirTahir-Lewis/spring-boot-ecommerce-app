package com.yasir.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasir.customer.entity.Customer;
import com.yasir.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
	}

	@SuppressWarnings("static-access")
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optional = customerRepository.findById(customer.getId());
		if (optional.isPresent()) {
			Customer newCustomer = optional.get();
			newCustomer.setUserName(customer.getUserName());
			newCustomer.setPassword(customer.getPassword());
			newCustomer.setEmail(customer.getEmail());
			newCustomer.setPhoneNumber(customer.getPhoneNumber());
			newCustomer.setName(customer.getName());
			newCustomer.setAddresses(customer.getAddresses());
			return customerRepository.save(newCustomer);
		} else {
			return customerRepository.save(customer);
		}
		
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);	
	}
	
	
}
