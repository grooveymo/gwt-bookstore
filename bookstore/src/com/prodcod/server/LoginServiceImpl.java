package com.prodcod.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.prodcod.client.service.LoginService;
import com.prodcod.shared.User;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	private static final long serialVersionUID = -6838579386240977104L;

	public static List<User> list = new ArrayList<User>();

	static {
		list.add(new User(1,"Homer","Simpson","simpson@springfield.com","marge", "012345678"));
		list.add(new User(1,"Ned","Flander","flanders@springfield.com","lefthand", "111222333"));		
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

}
