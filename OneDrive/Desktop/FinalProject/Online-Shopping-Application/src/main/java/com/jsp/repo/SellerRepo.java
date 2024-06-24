package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.model.Seller;

public interface SellerRepo extends JpaRepository<Seller , Integer> {

}
