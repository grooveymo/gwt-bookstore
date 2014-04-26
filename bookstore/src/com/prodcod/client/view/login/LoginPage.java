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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.presenter.login.LoginPresenter;

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
	
	private LoginPresenter presenter;
	
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
	
	public void setPresenter(LoginPresenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("registrationLink")
	public void onClickRegistration(ClickEvent e) {
//		RegistrationView registrationView = new RegistrationPage();
//		RegistrationPresenter registrationPresenter = new RegistrationPresenter(registrationView);
//		
//		registrationPresenter.go(RootPanel.get());
		presenter.navigateToRegistrationPage();

	}

}
