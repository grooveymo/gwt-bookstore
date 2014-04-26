package com.prodcod.client.presenter.login;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;

public class LoginPresenter implements PagePresenter{

	public interface LoginView {
		HasClickHandlers getSubmitButton();
		HasText getUsername();
		HasText getPassword();
		void setValidationMessage(final String message);
		
		Widget asWidget();
	}
	
	private final LoginView loginPage;
	
	public LoginPresenter(LoginView loginPage) {
		this.loginPage = loginPage;		
	}
	
	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(loginPage.asWidget());
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub
		
	}

}
