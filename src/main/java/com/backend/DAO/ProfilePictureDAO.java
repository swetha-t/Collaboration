package com.backend.DAO;

import com.backend.model.ProfilePicture;

public interface ProfilePictureDAO {
	
	public ProfilePicture getProfilePicture(String username);
	public void saveProfilePicture(ProfilePicture profilePicture);
}
