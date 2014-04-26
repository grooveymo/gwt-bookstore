package com.prodcod.client.presenter.login;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.presenter.events.RegisterNewUserEvent;

public class LoginPresenter implements PagePresenter{

	private final HandlerManager eventBus;
	
	public interface LoginView {
		HasClickHandlers getSubmitButton();
		HasText getUsername();
		HasText getPassword();
		void setValidationMessage(final String message);
		
		void setPresenter(LoginPresenter presenter);
		
		Widget asWidget();
	}
	
	private final LoginView loginPage;
	
	public LoginPresenter(LoginView loginPage, HandlerManager eventBus) {
		this.loginPage = loginPage;		
		this.eventBus = eventBus;
		loginPage.setPresenter(this);
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
	
	public void navigateToRegistrationPage() {
		eventBus.fireEvent(new RegisterNewUserEvent());
	}

}
