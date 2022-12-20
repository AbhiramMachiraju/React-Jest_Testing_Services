package com.example.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserTO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long autoId;
	
	@Column(name="USERNAME")
	private String userName;

	@Column(name="EMAIL_ID")
	private String emailId;

	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	

}
