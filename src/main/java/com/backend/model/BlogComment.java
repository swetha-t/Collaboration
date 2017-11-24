/*package com.backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BlogComment {
	
@Id
int id;
@ManyToOne(cascade={CascadeType.ALL})
@JoinColumn(name="blogId");
	

String comment;
Date commentDate;

@ManyToOne(cascade={CascadeType.ALL})
@JoinColumn(name="userId");

String username;

}
*/