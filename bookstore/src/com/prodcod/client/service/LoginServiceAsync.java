package com.prodcod.client.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.prodcod.shared.ExposePathImpl;
import com.prodcod.shared.domain.User;

public interface LoginServiceAsync {

	void login(String name, String password, AsyncCallback<User> callback);

	void registerNewCustomer(User customer,
			AsyncCallback<Set<ConstraintViolation<User>>> callback);

	void dummyMethod(AsyncCallback<ExposePathImpl> callback);

}
