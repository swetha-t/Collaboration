package com.backend.DAO;

import com.backend.model.ProfilePicture;

public interface ProfilePictureDAO {
	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
