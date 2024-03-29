package com.prodcod.client.presenter.shopping;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.client.ClientFactoryImpl;
import com.prodcod.client.event.AddToShoppingBasketEvent;
import com.prodcod.client.event.AddToShoppingBasketEventHandler;
import com.prodcod.client.event.NavigateToCheckoutPageEvent;
import com.prodcod.client.event.RemoveFromShoppingBasketEvent;
import com.prodcod.client.event.RemoveFromShoppingBasketEventHandler;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.OrderItem;

public class ShoppingBasketPresenter implements AddToShoppingBasketEventHandler, RemoveFromShoppingBasketEventHandler {
	
	private ShoppingBasketPanelView view;
	
	private final HandlerManager eventBus;

	//Declare interface for corresponding View
	public interface ShoppingBasketPanelView {
		void addItemToBasket(final OrderItem item);
		void removeItemFromBasket(final OrderItem item);
		void updateItemInBasket(final OrderItem item);
		void updateCount(final int count);
		void setPresenter(ShoppingBasketPresenter presenter);
	}
	
	public ShoppingBasketPresenter(ShoppingBasketPanelView view, HandlerManager eventBus){
		this.view = view;
		this.eventBus = eventBus;
		view.setPresenter(this);
	}

	@Override
	public void onAddToBasket(AddToShoppingBasketEvent event) {

		final Item item = event.getItemToBeAdded();

		//update model
		final OrderItem orderItem = ClientFactoryImpl.INSTANCE.getShoppingBasketModel().addToBasket(item);

		//update view
		if(orderItem.getCount() > 1) {
			view.updateItemInBasket(orderItem);
		}
		else {
			view.addItemToBasket(orderItem);		
		} 
	
		view.updateCount(ClientFactoryImpl.INSTANCE.getShoppingBasketModel().getNumberOfItems());

	}

	/**
	 * Fires an event to remove item from the  shopping basket
	 * This should update the model and views respectively.
	 * @param item
	 */
	public void removeFromBasket(final Item item) {

		//update model
		final OrderItem orderItem = ClientFactoryImpl.INSTANCE.getShoppingBasketModel().removeFromBasket(item);

		final RemoveFromShoppingBasketEvent event = new RemoveFromShoppingBasketEvent();
		event.setItemToBeRemoved(orderItem);
		eventBus.fireEvent(event);
	}

	@Override
	public void onRemoveFromBasket(RemoveFromShoppingBasketEvent event) {
		final OrderItem orderItem = event.getItemToBeRemoved();
		
//		//update model
//		final OrderItem orderItem = ClientFactoryImpl.INSTANCE.getShoppingBasketModel().removeFromBasket(item);

		//update view
		if (orderItem.getCount() == 0) {
			view.removeItemFromBasket(orderItem);
		}
		else {
			view.updateItemInBasket(orderItem);
		}

		view.updateCount(ClientFactoryImpl.INSTANCE.getShoppingBasketModel().getNumberOfItems());
	}

	/**
	 * User has clicked on 'checkout' button
	 */
	public void checkout() {
		eventBus.fireEvent(new NavigateToCheckoutPageEvent());						

	}
	
}
