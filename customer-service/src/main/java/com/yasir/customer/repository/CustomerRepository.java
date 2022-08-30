package com.yasir.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yasir.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
