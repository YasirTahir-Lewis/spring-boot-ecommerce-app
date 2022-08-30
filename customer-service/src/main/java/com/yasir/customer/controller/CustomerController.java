package com.yasir.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasir.customer.entity.Customer;
import com.yasir.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerServiceImpl.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		return new ResponseEntity<Customer>(customerServiceImpl.getCustomerById(id), HttpStatus.OK);
	}

	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerServiceImpl.addCustomer(customer), HttpStatus.CREATED);
	}

	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerServiceImpl.updateCustomer(customer), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerServiceImpl.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
