package com.prodcod.client.presenter.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.service.LoginService;
import com.prodcod.client.service.LoginServiceAsync;
import com.prodcod.client.event.NavigateToRegisterNewUserPageEvent;
import com.prodcod.client.event.NavigateToShoppingPageEvent;
import com.prodcod.shared.User;

public class LoginPresenter implements PagePresenter{

	private final HandlerManager eventBus;
	
	//GWT create the service
	//TODO: do this elsewhere and pass in (or inject) otherwise be difficult to unit test this code
    private LoginServiceAsync loginService = GWT.create(LoginService.class);
	 
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
		eventBus.fireEvent(new NavigateToRegisterNewUserPageEvent());
	}
	
	//Call LoginService to authenticate user
	public void login(final String username, final String password) {

		loginService.login(username, password, new AsyncCallback<User>() {
			
			@Override
			public void onSuccess(User result) {

				if(result == null) {
					loginPage.setValidationMessage("Please provide valid authentication credentials");
				}
				else {
//					loginPage.setValidationMessage("Welcome: " + result.getForename());		
					eventBus.fireEvent(new NavigateToShoppingPageEvent());

				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
