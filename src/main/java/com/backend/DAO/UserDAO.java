package com.backend.DAO;

import java.util.List;

import com.backend.model.Forum;
import com.backend.model.UserDetail;

public interface UserDAO {
	
	public boolean addUser(UserDetail user);
	public boolean updateOnlineStatus(String status, UserDetail user);

	public List<UserDetail> getAllUserDetails();
	public UserDetail getUser(String username);
	public UserDetail getByEmail(String emailId);
	public boolean delete(String emailId);
	

}
