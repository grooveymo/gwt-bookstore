package com.prodcod.client.presenter.registration;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;

public class RegistrationPresenter implements PagePresenter{

	public interface RegistrationView {
		HasClickHandlers getSubmitButton();
		HasText getForename();
		HasText getSurname();
		HasText getFirstLineAddress();
		HasText getCity();
		HasText getPostalcode();

		HasText getEmail();
		HasText getTelephoneNumber();

		HasText getUsername();
		HasText getPassword();
		HasText getPasswordConfirm();
		
		void setValidationMessage(final String message);
		
		Widget asWidget();
	}
	
	private final RegistrationView registrationPage;
	
	public RegistrationPresenter(RegistrationView registrationPage) {
		this.registrationPage = registrationPage;		
	}
	
	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(registrationPage.asWidget());
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub
		
	}


}
