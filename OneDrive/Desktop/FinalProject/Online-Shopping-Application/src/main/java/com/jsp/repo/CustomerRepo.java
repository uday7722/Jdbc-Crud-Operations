package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
