package com.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class ForumComment {
@Id
int forumcommentid;
/*int forumId;
int userId;*/
String comment,username;
Date commentDate;

public int getId() {
	return forumcommentid;
}
public void setId(int id) {
	this.forumcommentid = id;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Date getCommentDate() {
	return commentDate;
}
public void setCommentDate(Date commentDate) {
	this.commentDate = commentDate;
}


}

