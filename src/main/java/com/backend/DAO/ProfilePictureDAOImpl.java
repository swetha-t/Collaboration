package com.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.ProfilePicture;


@Repository("profilePictureDAO")
public class ProfilePictureDAOImpl implements ProfilePictureDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ProfilePictureDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(ProfilePicture profilePicture) {

		try 
		{
			sessionFactory.getCurrentSession().save(profilePicture);
			return true;
		} catch (Exception e) 
		{
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public ProfilePicture getProfilePicture(String username) {

		Session session = sessionFactory.openSession();
		ProfilePicture profilePicture = (ProfilePicture) session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}

}
