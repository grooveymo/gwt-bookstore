package com.prodcod.client;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.client.presenter.login.LoginPresenter.LoginView;
import com.prodcod.client.presenter.order.CheckoutPresenter.CheckoutView;
import com.prodcod.client.presenter.registration.RegistrationPresenter.RegistrationView;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;
import com.prodcod.shared.domain.ShoppingBasketModel;

public interface ClientFactory {

	HandlerManager getEventBus();
	
	ShoppingBasketModel getShoppingBasketModel();
	
	//TODO create RPC services here and expose them here.
	
	//Views are expensive and so useful to cache
	LoginView getLoginPage();
	
	RegistrationView getRegistrationPage();
	
	ShoppingView getShoppingPage();
	
	CheckoutView getCheckoutPage();
	
	
}
