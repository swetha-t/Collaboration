package com.backend.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.UserDAO;
import com.backend.model.Forum;
import com.backend.model.UsersDetails;

@RestController
public class UserController {
	
	@Autowired 
	UserDAO userDAO;
	
	
	@RequestMapping(value="/getAllUsers")
	public List <UsersDetails> getAllUser(){
		return userDAO.getAllUserDetails();
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody UsersDetails userDetail){

		userDetail.setRole("user");
		if(userDAO.addUserDetail(userDetail))
		{
			
			return new ResponseEntity<UsersDetails>(userDetail,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginStatus(@RequestBody UsersDetails userDetail)
	{
		userDetail=userDAO.getByEmail(userDetail.getEmail());
		if((userDetail==null))
		{
			userDetail=new UsersDetails();
			System.out.println("user email invalid");
		}
		else
		{
			System.out.println("login user");
		}
		return new ResponseEntity<UsersDetails>(userDetail,HttpStatus.OK);
	}

	@GetMapping(value = "/logout/{username}")
	public ResponseEntity<String> loggingout(@PathVariable("username") String username) {
		UsersDetails user = userDAO.getUserDetails(username);
		if (userDAO.updateOnlineStatus("N", user)) {
			return new ResponseEntity<String>("Successful logout", HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<String>("error in logout", HttpStatus.SERVICE_UNAVAILABLE);
		}
	
	}
}