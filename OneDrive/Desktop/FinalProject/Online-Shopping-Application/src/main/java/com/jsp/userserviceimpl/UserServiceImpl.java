package com.jsp.userserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.enums.UserRole;
import com.jsp.exception.UserAlreadyExistException;
import com.jsp.mapper.UserMapper;
import com.jsp.model.Customer;
import com.jsp.model.Seller;
import com.jsp.repo.CustomerRepo;
import com.jsp.repo.SellerRepo;
import com.jsp.repo.UserRepo;
import com.jsp.requestdto.UserRequest;
import com.jsp.responsedto.UserResponse;
import com.jsp.service.UserService;
import com.jsp.util.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private SellerRepo sellerRepo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@Valid UserRequest userRequest,UserRole userRole) {

		boolean userExist = userRepo.existsByEmail(userRequest.getEmail());
		if (userExist)
			throw new UserAlreadyExistException("Email : " + userRequest.getEmail() + ", is already exist");
		else {

			if (userRole.equals(UserRole.CUSTOMER)) {
				Customer customer = (Customer) userMapper.mapToUserRequest(userRequest, new Customer());
				customer.setUserRole(userRole);
				customer = customerRepo.save(customer);

				return ResponseEntity.status(HttpStatus.CREATED)
						.body(new ResponseStructure<UserResponse>().setStatus(HttpStatus.CREATED.value())
								.setMessage("Customer Created").setData(userMapper.mapToUserResponse(customer)));
			} else {
				Seller seller = (Seller) userMapper.mapToUserRequest(userRequest, new Seller());
				seller.setUserRole(userRole);
				seller = sellerRepo.save(seller);

				return ResponseEntity.status(HttpStatus.CREATED)
						.body(new ResponseStructure<UserResponse>().setStatus(HttpStatus.CREATED.value())
								.setMessage("Seller Created").setData(userMapper.mapToUserResponse(seller)));
			}


		}


	}

}
