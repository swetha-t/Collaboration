package com.backend.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.backend.model.UsersDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addUserDetail(UsersDetails user) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			user.setEnabled(true);
		
			session.save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}

	@Transactional
	public boolean updateOnlineStatus(String status, UsersDetails user) {
		try
		{
		user.setOnline(false);
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	@Transactional
public UsersDetails getByEmail(String email) {
		return (UsersDetails)sessionFactory.getCurrentSession().get(UsersDetails.class, email);
	
	}

	@Transactional
	public List<UsersDetails> getAllUserDetails() {
		Session session=sessionFactory.openSession();
		List<UsersDetails> user=(List<UsersDetails>)session.createQuery("from UsersDetails").list();
		session.close();
		return user;
	}


    @Transactional
	public UsersDetails getUserDetails(String username) {
		Session session=sessionFactory.openSession();
		UsersDetails user=(UsersDetails)session.get(UsersDetails.class,username);
		session.close();
		return user;
	}


    @Transactional
	public boolean checkLogin(UsersDetails userDetail) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where email=:email and password=:paswrd");
			query.setParameter("email",userDetail.getEmail());
			query.setParameter("password",userDetail.getPassword());
			UsersDetails user=(UsersDetails)query.list().get(0);
			if(user==null)
			{
				return false;
			}
			else
			{
				return true;
			}
	     	}     catch(Exception e){
			    
	     		return false;
		}
	}
	}




