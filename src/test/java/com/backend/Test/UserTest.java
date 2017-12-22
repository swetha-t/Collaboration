/*
package com.backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.UserDAO;
import com.backend.config.DbConfig;
import com.backend.model.Blog;
import com.backend.model.Forum;
import com.backend.model.Job;
import com.backend.model.UsersDetails;


@ComponentScan("com.backend")
@Ignore
public class UserTest {

static UserDAO  userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Ignore
	@Test
	public void addUserTest()
	{
		UsersDetails user=new UsersDetails();
		user.setUserId(14);
		user.setFirstName("John");
		user.setLastName("abraham");
		user.setEmail("john14@gmail.com");
		user.setPassword("1230");
		user.setRole("Admin");
		
		user.setOnline("N");
		assertTrue("Problem in Inserting user", userDAO.saveUser(user));

	}

	@Test
	public void getAllUserTest(){
		List<UsersDetails> userList=(List<UsersDetails>)userDAO.getAllUserDetails();
		assertNotNull("Job list not found ",userList.get(0));
		for(UsersDetails user:userList)
		{
			System.out.println("EmailID:"+ user.getEmailId() + "Status:"+ user.getStatus());
		}
	}
	@Ignore	
		@Test
		public void isOnlineTest()
		{
			UsersDetails user=(UsersDetails)userDAO.getUser("swetha");
			assertTrue("Problem in updating",userDAO.updateOnlineStatus("N", user));
		
		
		@Transactional
		@Test
		public void getUserDetailTest(){

			UserDetail user=(UserDetail)userDAO.getUserDetails("swetha");
			
			System.out.println("UserFirstname:" + user.getFirstName());
			System.out.println("UserRole:" + user.getRole());
			
			assertNotNull("UserDetail not found", user);
		}
	}
	
}
*/