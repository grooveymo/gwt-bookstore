package com.prodcod.client;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.shared.domain.ShoppingBasketModel;

public class ClientFactoryImpl implements ClientFactory{

	public static final ClientFactory INSTANCE = new ClientFactoryImpl();
	
	private HandlerManager eventBus;
	
	private ShoppingBasketModel shoppingBasketModel;

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

}
