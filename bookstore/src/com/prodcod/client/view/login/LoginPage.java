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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.login.LoginPresenter;

public class LoginPage extends Composite implements LoginPresenter.LoginView{

	private static LoginPageUiBinder uiBinder = GWT
			.create(LoginPageUiBinder.class);

	interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
	}

	@UiField 
	HTMLPanel validationPanel;
	
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
		
		
		userName.setWidth("260px");
		userName.addStyleName("form-control");

		password.setWidth("260px");
		password.addStyleName("form-control");

		validationPanel.addStyleName("alert alert-danger");
		//		registrationLink.addStyleName("btn");
//		registrationLink.addStyleName("btn-large");
//		registrationLink.addStyleName("btn-success");
	

		submitButton.addStyleName("btn btn-large btn-default");

		validationPanel.getElement().setId("validationPanel");
		validationPanel.addStyleName("hidden");

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
		validationPanel.removeStyleName("hidden");
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
		presenter.navigateToRegistrationPage();

	}

	@UiHandler("submitButton")
	public void onClickSubmit(ClickEvent e) {
		presenter.login(userName.getValue(), password.getValue());
		
	}
}
