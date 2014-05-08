package com.prodcod.client.presenter.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.validation.client.impl.Validation;
import com.prodcod.client.event.NavigateToLoginPageEvent;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.service.LoginService;
import com.prodcod.client.service.LoginServiceAsync;
import com.prodcod.shared.User;

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

		HasText getPassword();
		HasText getPasswordConfirm();
		
		void setValidationMessages(final List<String> messages);		
		void setPresenter(RegistrationPresenter presenter);
		
		User getNewCustomer();

		Widget asWidget();
	}
	
	private final RegistrationView registrationPage;
	
	private final HandlerManager eventBus;
	
	//GWT create the service
	//TODO: do this elsewhere and pass in (or inject) otherwise be difficult to unit test this code
    private LoginServiceAsync loginService = GWT.create(LoginService.class);

	public RegistrationPresenter(RegistrationView registrationPage, HandlerManager eventBus) {
		this.registrationPage = registrationPage;		
		this.eventBus = eventBus;
		registrationPage.setPresenter(this);
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

	/**
	 * Validates the registration form before saving new Customer details. The user
	 * is subsequently directed to the login page to enter authentication details.
	 *  
	 * User cannot progress until all validation issues have been corrected.
	 * 
	 */
	public void registerNewCustomer() {

		//get new Customer details
		User newCustomer = registrationPage.getNewCustomer();
		
		//first validate form before saving new Customer details - Note this is client side validation
		Set<ConstraintViolation<User>> violations = validateRegistrationForm(newCustomer);
				
		if(violations.isEmpty()) {
			//Having pass validation - create new Customer
			loginService.registerNewCustomer(newCustomer, new AsyncCallback<Set<ConstraintViolation<User>>>() {
				
				@Override
				public void onSuccess(Set<ConstraintViolation<User>> serverViolations) {
					
					//Having successfully created new user account - navigate to login page
					if(serverViolations.isEmpty()) {
						eventBus.fireEvent(new NavigateToLoginPageEvent());						
					}
					//Otherwise display server side validation failures
					else {
						//dedupe address violations and store result in map
						final Map<String, ConstraintViolation<User>> dedupedServerViolations = convertToMap(serverViolations);

						displayValidationMessages(dedupedServerViolations);						
					}
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub					
				}
			});				
			
		}
		else {
			//dedupe address violations and store result in map
			final Map<String, ConstraintViolation<User>> dedupedViolations = convertToMap(violations);
			
			//show validation messages
			displayValidationMessages(dedupedViolations);
		}
	}
	
	private  Map<String, ConstraintViolation<User>>  convertToMap(Set<ConstraintViolation<User>> violations) {

		final Map<String, ConstraintViolation<User>> dedupedViolations = new HashMap<String, ConstraintViolation<User>>();
		
		for (ConstraintViolation<User> v : violations) {
			if(dedupedViolations.get(v.getMessage()) == null) {
				dedupedViolations.put(v.getMessage(), v);
			}
		}
		return dedupedViolations;
	}
	/**
	 * Perform client side validation
	 * @param newCustomer User details
	 * @return Set of validation failures
	 */
	private Set<ConstraintViolation<User>> validateRegistrationForm(User newCustomer) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		final Set<ConstraintViolation<User>> violations = validator.validate(newCustomer);
		return violations;
	}
	
	/**
	 * Displays Validation Errors if any exist.
	 * @param violations Map of validation failures
	 */
	private void displayValidationMessages(Map<String, ConstraintViolation<User>> violations) {
		final List<String> messages = new ArrayList<String>();
		
		for(String message : violations.keySet()) {
			messages.add(message);
		}
		
		registrationPage.setValidationMessages(messages);
	}
	
}
