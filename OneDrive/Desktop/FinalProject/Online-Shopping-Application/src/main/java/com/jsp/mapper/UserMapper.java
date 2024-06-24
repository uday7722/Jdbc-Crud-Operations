package com.jsp.mapper;

import org.springframework.stereotype.Component;

import com.jsp.model.User;
import com.jsp.requestdto.UserRequest;
import com.jsp.responsedto.UserResponse;

@Component
public class UserMapper {
	
	public User mapToUserRequest(UserRequest userRequest,User user) {
		user.setUsername(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setUserRole(userRequest.getUserRole());
		
		return user;
	}
	
	public UserResponse mapToUserResponse(User user) {
		return UserResponse.builder()
				.userId(user.getUserId())
				.username(user.getUsername())
				.email(user.getEmail())
				.userRole(user.getUserRole())
				.build();
	}

}
