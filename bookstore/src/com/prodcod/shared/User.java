package com.prodcod.shared;

import java.io.Serializable;

/**
 * 
 * DTO representing customer
 * @author BruceWayne
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -4662456929999251486L;

	private int userId;
	
	private String forename;
	private String lastname;
	private String email;
	private String mobileNumber;
	private String password;
	
	
	public User(final int userId, final String forename, final String lastname, final String email, final String password, final String mobileNumber) {
		this.userId = userId;
		this.forename = forename;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * No arg constructor required
	 */
	public User() {
	}


	public int getUserId() {
		return userId;
	}


	public String getForename() {
		return forename;
	}


	public String getLastname() {
		return lastname;
	}


	public String getEmail() {
		return email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
