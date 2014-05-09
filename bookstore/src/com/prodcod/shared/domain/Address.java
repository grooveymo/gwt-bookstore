package com.prodcod.shared.domain;

import java.io.Serializable;

import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Base Class for address
 * @author BruceWayne
 *
 */
public class Address implements Serializable{

	private static final long serialVersionUID = 1769559052818415322L;

	@NotEmpty(message = "You must supply the first line of the address")	
	private String firstLineOfAddress;
	
	@NotEmpty(message = "You must supply the city", groups=Default.class)	
	private String city;
	
	@NotEmpty(message = "You must supply the Post code")	
	private String postCode;
	
	protected enum AddressType {
		BILLING_ADDRESS,
		SHIPPING_ADDRESS;
	};
	
	protected AddressType type;
	
	public Address(final String firstLineOfAddress, final String city, final String postCode) {
		this.firstLineOfAddress = firstLineOfAddress;
		this.city = city;
		this.postCode = postCode;
	}
	
	public String getFirstLineOfAddress() {
		return firstLineOfAddress;
	}

	public void setFirstLineOfAddress(String firstLineOfAddress) {
		this.firstLineOfAddress = firstLineOfAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public Address() {		
	}
	
	
}
