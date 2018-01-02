 package com.backend.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="c_Userdetails")
public class UsersDetails {
	
	@Id
	@GeneratedValue
	int user_Id;

	private String firstName;
	private String lastName;
	
	@Column(unique=true,nullable=false)
	private String userName;
	private String contact;
	
	@Column(unique=true,nullable=false)
	private String email;
	private String password;
	private String role;
    private String status;
	private boolean isOnline;
	private boolean Enabled;
	
	@Lob
	private byte[] image;

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	
	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean b) {
		this.isOnline = b;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	


}