package com.prodcod.client.view.registration;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.registration.RegistrationPresenter;
import com.prodcod.client.presenter.registration.RegistrationPresenter.RegistrationView;
import com.prodcod.shared.BillingAddress;
import com.prodcod.shared.ShippingAddress;
import com.prodcod.shared.User;

public class RegistrationPage extends Composite implements RegistrationView {

	private static RegistrationPageUiBinder uiBinder = GWT
			.create(RegistrationPageUiBinder.class);

	interface RegistrationPageUiBinder extends
			UiBinder<Widget, RegistrationPage> {
	}

	@UiField
	HTMLPanel validationMessage;

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
	TextBox password;

	@UiField
	TextBox confirmPassword;
	
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
	void onClickSubmitButton(ClickEvent e) {
		presenter.registerNewCustomer();
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
	public HasText getPassword() {
		return password;
	}

	@Override
	public HasText getPasswordConfirm() {
		return confirmPassword;
	}

	@Override
	public void setValidationMessages(List<String> messages) {
		
		validationMessage.clear();
		for (String mess : messages) {
            validationMessage.add(new Label(mess));
		}
	}


	@Override
	public void setPresenter(RegistrationPresenter presenter) {
		this.presenter = presenter;
	}


	@Override
	public User getNewCustomer() {
		
		final ShippingAddress shippingAddress = new ShippingAddress(firstLineAddress.getValue(), city.getValue(), postalCode.getValue());
		final BillingAddress billingAddress = new BillingAddress(firstLineAddress.getValue(), city.getValue(), postalCode.getValue());
		
		final User newCustomer = new User(forename.getValue(), surname.getValue(), email.getValue(), password.getValue(), phone.getValue());
		newCustomer.setBillingAddress(billingAddress);
		newCustomer.setShippingAddress(shippingAddress);
		
		return newCustomer;
		
	}

}
