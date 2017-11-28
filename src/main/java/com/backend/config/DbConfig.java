package com.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.backend.DAO.BlogDAO;

import com.backend.DAO.BlogDAOImpl;

import com.backend.DAO.ForumDAO;
import com.backend.DAO.ForumDAOImpl;
import com.backend.DAO.JobDAO;
import com.backend.DAO.JobDAOImpl;
import com.backend.DAO.UserDAO;
import com.backend.DAO.UserDAOImpl;
import com.backend.model.Blog;
import com.backend.model.Forum;
import com.backend.model.Job;
import com.backend.model.UserDetail;



@Configuration
@EnableTransactionManagement
@ComponentScan("com.backend")
@Component
public class DbConfig {

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("mycoll");
		dataSource.setPassword("Swetha1234");

		System.out.println("DataBase is connected.........!");
		return dataSource;

	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		return properties;

	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
	
	    sessionBuilder.addAnnotatedClasses(Blog.class);
		sessionBuilder.addAnnotatedClasses(Forum.class);
		sessionBuilder.addAnnotatedClasses(UserDetail.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		/*sessionBuilder.addAnnotatedClass(BlogComments.class);*/
		sessionBuilder.scanPackages("com.backend");
		System.out.println("Session is created................!");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is created............!");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("Blog DAO object Created");
		return new BlogDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		System.out.println("Forum DAO object Created");
		return new ForumDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("User DAO object Created");
		return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory)
	{
		System.out.println("Job DAO object Created");
		return new JobDAOImpl(sessionFactory);
	}
	
	/*@Autowired
	@Bean(name="blogcommentDAO")
	public BlogCommentDAO getBlogCommentDAO(SessionFactory sessionFactory)
	{
		System.out.println("BlogComment DAO object Created");
		return new BlogCommentDAOImpl(sessionFactory);
	}*/
}