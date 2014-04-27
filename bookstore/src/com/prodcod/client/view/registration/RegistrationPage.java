package com.prodcod.client.view.registration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.registration.RegistrationPresenter;
import com.prodcod.client.presenter.registration.RegistrationPresenter.RegistrationView;

public class RegistrationPage extends Composite implements RegistrationView {

	private static RegistrationPageUiBinder uiBinder = GWT
			.create(RegistrationPageUiBinder.class);

	interface RegistrationPageUiBinder extends
			UiBinder<Widget, RegistrationPage> {
	}

	@UiField
	Label validationMessage;

	@UiField
	TextBox forename;

	@UiField
	TextBox surname;

	@UiField
	TextBox firstLineAddress;

	@UiField
	TextBox city;

	@UiField
	TextBox postalCode;

	@UiField
	TextBox phone;

	@UiField
	TextBox email;

	@UiField
	TextBox username;
	
	@UiField
	TextBox password;

	@UiField
	TextBox confirmPassword;
	
	@UiField
	Anchor shoppingLink;

	@UiField
	Button submitButton;

	private RegistrationPresenter presenter;
	
	public RegistrationPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public RegistrationPage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("submitButton")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	@UiHandler("shoppingLink")
	void onClickShopping(ClickEvent e) {
		presenter.navigateToShoppingPage();
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		return submitButton;
	}

	@Override
	public HasText getForename() {
		return forename;
	}

	@Override
	public HasText getSurname() {
		return surname;
	}

	@Override
	public HasText getFirstLineAddress() {
		return firstLineAddress;
	}

	@Override
	public HasText getCity() {
		return city;
	}

	@Override
	public HasText getPostalcode() {
		return postalCode;
	}

	@Override
	public HasText getEmail() {
		return email;
	}

	@Override
	public HasText getTelephoneNumber() {
		return phone;
	}

	@Override
	public HasText getUsername() {
		return username;
	}

	@Override
	public HasText getPassword() {
		return password;
	}

	@Override
	public HasText getPasswordConfirm() {
		return confirmPassword;
	}

	@Override
	public void setValidationMessage(String message) {
		validationMessage.setText(message);
	}


	@Override
	public void setPresenter(RegistrationPresenter presenter) {
		this.presenter = presenter;
	}

}
