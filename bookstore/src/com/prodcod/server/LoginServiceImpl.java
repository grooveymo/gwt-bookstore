package com.prodcod.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.prodcod.client.service.LoginService;
import com.prodcod.shared.BillingAddress;
import com.prodcod.shared.ShippingAddress;
import com.prodcod.shared.User;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	private static final long serialVersionUID = -6838579386240977104L;

	public static List<User> list = new ArrayList<User>();

	private static int counter = 0;
	
	static {
		BillingAddress billingAddress1 = new BillingAddress("1 springfield terrage", "Springfield", "CV1 5RP");
		ShippingAddress shippingAddress1 = new ShippingAddress("1 springfield terrage", "Springfield", "CV1 5RP");		
		User user1 = new User("Homer","Simpson","simpson@springfield.com","marge", "012345678");
		user1.setBillingAddress(billingAddress1);
		user1.setShippingAddress(shippingAddress1);
		user1.setUserId(++counter);
		
		BillingAddress billingAddress2 = new BillingAddress("32 forshore avenue", "Springfield", "CV3 5QS");
		ShippingAddress shippingAddress2 = new ShippingAddress("32 forshore avenue", "Springfield", "CV3 5QS");		
		User user2 = new User("Ned","Flander","flanders@springfield.com","lefthand", "111222333");
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
	public void registerNewCustomer(User customer) {

		synchronized(userList) {
			userList.add(customer);
		}
		
	}

}
