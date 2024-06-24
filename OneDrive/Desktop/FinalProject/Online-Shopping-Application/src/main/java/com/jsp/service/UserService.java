package com.jsp.service;

import org.springframework.http.ResponseEntity;

import com.jsp.enums.UserRole;
import com.jsp.requestdto.UserRequest;
import com.jsp.responsedto.UserResponse;
import com.jsp.util.ResponseStructure;

import jakarta.validation.Valid;

public interface UserService {

	ResponseEntity<ResponseStructure<UserResponse>> registerUser(@Valid UserRequest userRequest, UserRole userRole);
	

}
