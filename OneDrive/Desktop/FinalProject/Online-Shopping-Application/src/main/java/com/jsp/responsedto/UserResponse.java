package com.jsp.responsedto;

import com.jsp.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
	
	private int userId;
	private String username;
	private String email;
	UserRole userRole;

}
