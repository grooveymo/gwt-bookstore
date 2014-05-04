package com.prodcod.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.prodcod.shared.User;

/**
 * The client side stub for the RPC service.
 * This service will authenticate the user
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	User login(String name, String password) throws IllegalArgumentException;
}

