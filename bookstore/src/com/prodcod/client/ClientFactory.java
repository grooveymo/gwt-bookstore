package com.prodcod.client;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.shared.domain.ShoppingBasketModel;

public interface ClientFactory {

	HandlerManager getEventBus();
	
	ShoppingBasketModel getShoppingBasketModel();
	
	//TODO create RPC services here and expose them here.
}
