package com.backend.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.BlogDAO;
import com.backend.model.Blog;

@RestController
public class BlogController {

	@Autowired 
	BlogDAO blogDAO;
	
	@PostMapping(value="/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
	{
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	@PostMapping(value="/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		if(blogDAO.updateBlog(blog))
		{
			return new ResponseEntity<String>("Blog updated",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	
	@PostMapping(value="/deleteBlog")
	public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
	{
		if(blogDAO.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Blog deleted",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	}
	

