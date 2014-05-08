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
@PasswordValidatorAnnotation
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
	

	//TODO: add validator for mobile phone number 
	/*
	 * based on http://en.wikipedia.org/wiki/List_of_mobile_phone_number_series_by_country#United_Kingdom, mobile phone prefixes in uk are
	 * 
	 * 	071, 074, 075, 077, 078, 079
	 * 
	 * Need to write a custom validator that will check the number supplied conforms to this format.
	 */
//	@NotEmpty(groups = ServersideGroup.class, message = "Mobile number cannot be empty")
	@UKMobilePhone(groups = ServersideGroup.class)
	private String mobileNumber;
	
	@NotEmpty(message = "You must supply a password")	
	private String password;

	//@NotEmpty(message = "You must confirm the  password")	
	private String confirmPassword;

	@Valid
	private ShippingAddress shippingAddress;

	@Valid
	private BillingAddress billingAddress;
	
	public User(final String forename, final String lastname, final String email, final String password, final String confirmPassword, final String mobileNumber) {
		this.forename = forename;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
}
