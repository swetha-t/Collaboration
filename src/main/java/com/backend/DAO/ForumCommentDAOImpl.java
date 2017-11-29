package com.backend.DAO;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.ForumComment;

@Repository("ForumCommentDAO")
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	ForumCommentDAO forumcommentDAO;
	
	public ForumCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Transactional
	public boolean addForumComment(ForumComment forumcomment) {
		try
		{
		sessionFactory.getCurrentSession().save(forumcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
		
	}

}
