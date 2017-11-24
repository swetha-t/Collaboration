package com.backend.DAO;

import java.util.List;

import com.backend.model.Forum;
import com.backend.model.UserDetail;

public interface UserDAO {
	
	public boolean addUserDetail(UserDetail user);
	public boolean updateOnlineStatus(String status, UserDetail user);
/*	public UserDetail getUserDetail(String username);*/
	public List<UserDetail> getAllUserDetails();
	public UserDetail getUserDetails(String username);
	

}
