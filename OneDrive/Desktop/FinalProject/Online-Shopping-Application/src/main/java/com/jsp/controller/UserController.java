package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.enums.UserRole;
import com.jsp.requestdto.UserRequest;
import com.jsp.responsedto.UserResponse;
import com.jsp.service.UserService;
import com.jsp.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	private UserService userService;
	
	@PostMapping("/sellers/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerSeller(@RequestBody @Valid UserRequest userRequest){
		
		return userService.registerUser(userRequest,UserRole.SELLER);	
	}

	@PostMapping("/customers/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerCustomer(@RequestBody @Valid UserRequest userRequest){
		return userService.registerUser(userRequest,UserRole.CUSTOMER);	
	}
}
