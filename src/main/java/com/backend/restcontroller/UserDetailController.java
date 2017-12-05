package com.backend.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.UserDAO;
import com.backend.model.Forum;
import com.backend.model.UserDetail;

@RestController
public class UserDetailController {
	@Autowired 
	UserDAO userDAO;
	
	@PostMapping(value="/insertUserDetail")
	public ResponseEntity<String> insertUser(@RequestBody UserDetail user)
	{
		if(userDAO.addUser(user))
		{
			return new ResponseEntity<String>("User Added",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}

	
	@PostMapping(value="/deleteUserDetail")
	public ResponseEntity<String> deleteUser(@RequestBody UserDetail user)
	{
		if(userDAO.addUser(user))
		{
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	@GetMapping(value="/getAllUser")
	public ResponseEntity<ArrayList<UserDetail>> getAllUserDetails()
	{
		ArrayList listUserDetails=(ArrayList)userDAO.getAllUserDetails();
		return new ResponseEntity<ArrayList<UserDetail>>(listUserDetails,HttpStatus.SERVICE_UNAVAILABLE);
	}

}
