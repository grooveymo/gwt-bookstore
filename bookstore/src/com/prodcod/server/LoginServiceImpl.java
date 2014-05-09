package com.prodcod.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.prodcod.client.service.LoginService;
import com.prodcod.shared.ExposePathImpl;
import com.prodcod.shared.ServersideGroup;
import com.prodcod.shared.domain.BillingAddress;
import com.prodcod.shared.domain.ShippingAddress;
import com.prodcod.shared.domain.User;
//TODO blog about the following class - it gives errors. Enusre that we use javax.validation.Validation
//import com.google.gwt.validation.client.impl.Validation;
import javax.validation.Validation;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	private static final long serialVersionUID = -6838579386240977104L;

	public static List<User> list = new ArrayList<User>();

	private static int counter = 0;
	
	static {
		BillingAddress billingAddress1 = new BillingAddress("1 springfield terrage", "Springfield", "CV1 5RP");
		ShippingAddress shippingAddress1 = new ShippingAddress("1 springfield terrage", "Springfield", "CV1 5RP");		
		User user1 = new User("Homer","Simpson","simpson@springfield.com","marge", "marge","012345678");
		user1.setBillingAddress(billingAddress1);
		user1.setShippingAddress(shippingAddress1);
		user1.setUserId(++counter);
		
		BillingAddress billingAddress2 = new BillingAddress("32 forshore avenue", "Springfield", "CV3 5QS");
		ShippingAddress shippingAddress2 = new ShippingAddress("32 forshore avenue", "Springfield", "CV3 5QS");		
		User user2 = new User("Ned","Flander","flanders@springfield.com","lefthand","lefthand", "111222333");
		user2.setBillingAddress(billingAddress2);
		user2.setShippingAddress(shippingAddress2);
		user1.setUserId(++counter);

		
		list.add(user1);
		list.add(user2);		
	}
	public static List<User> userList = Collections.<User>synchronizedList(list);
	
	@Override
	public User login(String name, String password)
			throws IllegalArgumentException {

		if(name == null | password == null) {
			throw new IllegalArgumentException("Failed to pass valid credentials");
			
		}
		synchronized(userList) {

			Iterator<User> i = userList.iterator();
			
			while(i.hasNext()) {
				
				User user = i.next();
				
				if(name.equals(user.getEmail()) && password.equals(user.getPassword())) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public Set<ConstraintViolation<User>> registerNewCustomer(final User customer) {
		
		Set<ConstraintViolation<User>> violations = validateServerSide(customer);

		//only add user if successfully validated
		if(violations.isEmpty()) {

			synchronized(userList) {
				userList.add(customer);
			}			
		}

		return violations;

	}

	/**
	 * Perform client side validation
	 * @param newCustomer User details
	 * @return Set of validation failures
	 */
	private Set<ConstraintViolation<User>> validateServerSide(final User newCustomer) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		final Set<ConstraintViolation<User>> violations = validator.validate(newCustomer, ServersideGroup.class);
		return violations;
	}

	@Override
	public ExposePathImpl dummyMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
