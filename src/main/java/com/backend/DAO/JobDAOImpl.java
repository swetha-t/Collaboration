package com.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.Forum;
import com.backend.model.Job;

@Repository("JobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JobDAO jobDAO;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addJob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}	
	}

	public List<Job> getAllJobs() {
     Session session=sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Job> jobList=(List<Job>)session.createQuery("from Job").list();
		session.close();
		return jobList;
	}

	public Job getJob(int jobId) {
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		session.close();
		return job;
	}
@Transactional
	public boolean updateJob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().update(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}	
	}

@Transactional
public boolean deleteJob(Job job) {
	try
	{
	sessionFactory.getCurrentSession().delete(job);
	return true;
	}
	catch(Exception e)
	{
	System.out.println("Exception arised:"+e);
	return false;
	}
}
	

	

}
