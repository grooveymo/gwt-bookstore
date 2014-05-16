package com.prodcod.client;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.client.presenter.login.LoginPresenter.LoginView;
import com.prodcod.client.presenter.registration.CheckoutPresenter.CheckoutView;
import com.prodcod.client.presenter.registration.RegistrationPresenter.RegistrationView;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;
import com.prodcod.client.view.login.LoginPage;
import com.prodcod.client.view.order.CheckoutPage;
import com.prodcod.client.view.registration.RegistrationPage;
import com.prodcod.client.view.shopping.ShoppingPage;
import com.prodcod.shared.domain.ShoppingBasketModel;

public class ClientFactoryImpl implements ClientFactory{

	public static final ClientFactory INSTANCE = new ClientFactoryImpl();
	
	private HandlerManager eventBus;
	
	private ShoppingBasketModel shoppingBasketModel;

	private LoginView loginView;
	
	private RegistrationView registrationView;
	
	private ShoppingView shoppingView;
	
	private CheckoutView checkoutView;
	
//  private LoginServiceAsync loginService = GWT.create(LoginService.class);

	private ClientFactoryImpl(){
		
	}
	
	@Override
	public HandlerManager getEventBus() {
		// TODO Auto-generated method stub
		return eventBus;
	}

	@Override
	public ShoppingBasketModel getShoppingBasketModel() {
		if(shoppingBasketModel == null) {
			shoppingBasketModel = new ShoppingBasketModel();
		}
		return shoppingBasketModel;
	}

	@Override
	public LoginView getLoginPage() {
		
		if (loginView == null) {
			loginView = new LoginPage();
		}
		return loginView;
	}

	@Override
	public RegistrationView getRegistrationPage() {
		if (registrationView == null) {
			registrationView = new RegistrationPage();
		}
		return registrationView;
	}

	@Override
	public ShoppingView getShoppingPage() {
		if(shoppingView == null) {
			shoppingView = new ShoppingPage();
		}
		return shoppingView;
	}

	@Override
	public CheckoutView getCheckoutPage() {
		if(checkoutView == null) {
			checkoutView = new CheckoutPage();
		}
		return checkoutView;
	}

}
