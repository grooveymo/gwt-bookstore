package com.prodcod.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.login.LoginPresenter;
import com.prodcod.client.presenter.login.LoginPresenter.LoginView;
import com.prodcod.client.presenter.registration.RegistrationPresenter;
import com.prodcod.client.presenter.registration.RegistrationPresenter.RegistrationView;
import com.prodcod.client.view.registration.RegistrationPage;

public class LoginPage extends Composite implements LoginPresenter.LoginView{

	private static LoginPageUiBinder uiBinder = GWT
			.create(LoginPageUiBinder.class);

	interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
	}

	@UiField
	Label validationMessage;

	@UiField
	TextBox userName;
	
	@UiField
	TextBox password;

	@UiField
	Anchor registrationLink;

	@UiField
	Button submitButton;
	
	public LoginPage() {
		initWidget(uiBinder.createAndBindUi(this));
		userName.addStyleName("fieldInput");
		password.addStyleName("fieldInput");
		registrationLink.addStyleName("registrationPanel");
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		return submitButton;
	}

	@Override
	public HasText getUsername() {
		return userName;
	}

	@Override
	public HasText getPassword() {
		return password;
	}

	@Override
	public void setValidationMessage(final String message) {
		validationMessage.setText(message);
	}

	@Override
	public Widget asWidget() {
		return this;
	}
	
	@UiHandler("registrationLink")
	public void onClickRegistration(ClickEvent e) {
		//TODO - navigate to registration page.
		RegistrationView registrationView = new RegistrationPage();
		RegistrationPresenter registrationPresenter = new RegistrationPresenter(registrationView);
		
		registrationPresenter.go(RootPanel.get());

	}

}
