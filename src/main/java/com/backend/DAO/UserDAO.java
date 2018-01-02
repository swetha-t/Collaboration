package com.backend.DAO;

import java.util.List;

import com.backend.model.Forum;
import com.backend.model.UsersDetails;

public interface UserDAO {


	public boolean addUserDetail(UsersDetails user);
	public boolean updateOnlineStatus(String status, UsersDetails user);
	public UsersDetails getByEmail(String email);
	public List<UsersDetails> getAllUserDetails();
	public UsersDetails getUserDetails(String username);
	public boolean checkLogin (UsersDetails userDetail);
	
}
