package com.prodcod.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.prodcod.shared.User;

public interface LoginServiceAsync {

	void login(String name, String password, AsyncCallback<User> callback);

}
