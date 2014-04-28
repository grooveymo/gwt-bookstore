package com.prodcod.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.presenter.events.NavigateToRegisterNewUserPageEvent;
import com.prodcod.client.presenter.events.NavigateToRegisterNewUserPageEventHandler;
import com.prodcod.client.presenter.events.NavigateToShoppingPageEvent;
import com.prodcod.client.presenter.events.NavigateToShoppingPageEventHandler;
import com.prodcod.client.presenter.login.LoginPresenter;
import com.prodcod.client.presenter.login.LoginPresenter.LoginView;
import com.prodcod.client.presenter.registration.RegistrationPresenter;
import com.prodcod.client.presenter.registration.RegistrationPresenter.RegistrationView;
import com.prodcod.client.presenter.shopping.ShoppingPresenter;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;
import com.prodcod.client.view.login.LoginPage;
import com.prodcod.client.view.registration.RegistrationPage;
import com.prodcod.client.view.shopping.ShoppingPage;

/**
 * PagePresenter exposes go() method which enables page navigation
 * ValueChangeHandler<String> supports the History mechanism
 * @author BruceWayne
 *
 */
public class AppController implements PagePresenter, ValueChangeHandler<String> {//, RegisterNewUserEventHandler {
	  private final HandlerManager eventBus;
	  private HasWidgets container;
	  
//	  public AppController(ContactsServiceAsync rpcService, HandlerManager eventBus) {
//	    this.eventBus = eventBus;
//	    this.rpcService = rpcService;
//	    bind();
//	  }

	  public AppController(HandlerManager eventBus) {
		    this.eventBus = eventBus;
		    bind();		    
		  }

//	  public void bind() {
//	    History.addValueChangeHandler(this);

//	    eventBus.addHandler(AddContactEvent.TYPE,
//	        new AddContactEventHandler() {
//	          public void onAddContact(AddContactEvent event) {
//	            doAddNewContact();
//	          }
//	        });  

//	  }
	  
//	  private void doAddNewContact() {
//	    History.newItem("add");
//	  }
	  
//	  private void doEditContact(String id) {
//	    History.newItem("edit", false);
//	    Presenter presenter = new EditContactPresenter(rpcService, eventBus, new EditContactView(), id);
//	    presenter.go(container);
//	  }
	  
	  
//	  public void go(final HasWidgets container) {
//	    this.container = container;
//	    
//	    if ("".equals(History.getToken())) {
//	      History.newItem("list");
//	    }
//	    else {
//	      History.fireCurrentHistoryState();
//	    }
//	  }

//	  public void onValueChange(ValueChangeEvent<String> event) {
//	    String token = event.getValue();
//	    
//	    if (token != null) {
//	      Presenter presenter = null;
//
//	      if (token.equals("list")) {
//	        presenter = new ContactsPresenter(rpcService, eventBus, new ContactsView());
//	      }
//	      else if (token.equals("add")) {
//	        presenter = new EditContactPresenter(rpcService, eventBus, new EditContactView());
//	      }
//	      else if (token.equals("edit")) {
//	        presenter = new EditContactPresenter(rpcService, eventBus, new EditContactView());
//	      }
//	      
//	      if (presenter != null) {
//	        presenter.go(container);
//	      }
//	    }
//	  }

	  /**
	   * Supports History mechanism
	   */
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

		String token = event.getValue();
	    
	    if (token != null) {
	      PagePresenter presenter = null;

	      if (token.equals("login")) {	        
			LoginView loginView = new LoginPage();
			presenter = new LoginPresenter(loginView, eventBus);			
	      }
	      else if (token.equals("registration")) {
			RegistrationView registrationView = new RegistrationPage();
			presenter = new RegistrationPresenter(registrationView, eventBus);				
	      }
	      else if (token.equals("shopping")) {
			ShoppingView shoppingView = new ShoppingPage();
			presenter = new ShoppingPresenter(shoppingView, eventBus);				
	      }
	      
	      if (presenter != null) {
	        presenter.go(container);
	      }
	    }
		
	}

	  /**
	   * @param container RootPanel element. 'Pages' are attached/detached from this main panel
	   */
	@Override
	public void go(HasWidgets container) {

	    this.container = container;

	    if ("".equals(History.getToken())) {
	      History.newItem("login");
	    }
	    else {
	      History.fireCurrentHistoryState();
	    }

//		LoginView loginView = new LoginPage();
//		LoginPresenter loginPresenter = new LoginPresenter(loginView);
//		
//		loginPresenter.go(container);
//		
	}

	@Override
	public void bind() {
	    History.addValueChangeHandler(this);
	    
	    eventBus.addHandler(NavigateToRegisterNewUserPageEvent.TYPE,
	            new NavigateToRegisterNewUserPageEventHandler() {
	              public void onRegisterNewUser(NavigateToRegisterNewUserPageEvent event) {
//	                doEditContact(event.getId());
	        	      History.newItem("registration");		
	              }
	            });  


	    eventBus.addHandler(NavigateToShoppingPageEvent.TYPE,
	            new NavigateToShoppingPageEventHandler() {
	              public void onDisplayShoppingPage(NavigateToShoppingPageEvent event) {
//	                doEditContact(event.getId());
	        	      History.newItem("shopping");		
	              }
	            });  

	}

//	@Override
//	public void onRegisterNewUser(RegisterNewUserEvent event) {
//	      History.newItem("registration");		
//	} 
}
