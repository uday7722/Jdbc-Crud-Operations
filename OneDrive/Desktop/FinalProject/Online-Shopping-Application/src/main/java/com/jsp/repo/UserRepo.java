package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

}
