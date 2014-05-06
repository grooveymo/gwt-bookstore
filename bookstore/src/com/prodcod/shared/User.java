package com.prodcod.shared;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * DTO representing customer
 * @author BruceWayne
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -4662456929999251486L;

	private int userId;
	
	@Size(min = 4, message = "forename must be at least 4 characters long.")
	private String forename;

	@Size(min = 4, message = "surname must be at least 4 characters long.")
	private String lastname;
	
//	Only works server side - @Email(message = "You must supply an email")		
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", message = "You must supply a valid email")
	private String email;
	private String mobileNumber;
	
	@NotEmpty(message = "You must supply a password")	
	private String password;
	
	@Valid
	private ShippingAddress shippingAddress;

	@Valid
	private BillingAddress billingAddress;
	
	public User(final String forename, final String lastname, final String email, final String password, final String mobileNumber) {
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

	public void setUserId(int i) {
		this.userId = i;
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
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	
}
