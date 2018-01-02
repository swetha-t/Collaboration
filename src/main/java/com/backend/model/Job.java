package com.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job {
	@Id
	@GeneratedValue
int jobId;
String jobProfile,jobDesc,qualification,status;
Date postDate;
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getJobProfile() {
	return jobProfile;
}
public void setJobProfile(String jobProfile) {
	this.jobProfile = jobProfile;
}
public String getJobDesc() {
	return jobDesc;
}
public void setJobDesc(String jobDesc) {
	this.jobDesc = jobDesc;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getPostDate() {
	return postDate;
}
public void setPostDate(Date postDate) {
	this.postDate = postDate;
}

}
