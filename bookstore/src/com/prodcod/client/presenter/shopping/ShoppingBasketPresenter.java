package com.prodcod.client.presenter.shopping;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.client.event.AddToShoppingBasketEvent;
import com.prodcod.client.event.AddToShoppingBasketEventHandler;
import com.prodcod.client.event.RemoveFromShoppingBasketEvent;
import com.prodcod.client.event.RemoveFromShoppingBasketEventHandler;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.OrderItem;

public class ShoppingBasketPresenter implements AddToShoppingBasketEventHandler, RemoveFromShoppingBasketEventHandler {
	
	private ShoppingBasketPanelView view;
	
	private Map<Item, OrderItem> basketItems;
	
	private final HandlerManager eventBus;

	public interface ShoppingBasketPanelView {
		void addItemToBasket(final OrderItem item);
		void removeItemFromBasket(final OrderItem item);
		void updateItemInBasket(final OrderItem item);
		void updateCount();
		void setPresenter(ShoppingBasketPresenter presenter);
	}
	
	public ShoppingBasketPresenter(ShoppingBasketPanelView view, HandlerManager eventBus){
		this.view = view;
		this.eventBus = eventBus;
		view.setPresenter(this);
		basketItems = new HashMap<Item, OrderItem>();
	}

	@Override
	public void onAddToBasket(AddToShoppingBasketEvent event) {

		final Item item = event.getItemToBeAdded();

		OrderItem orderItem = basketItems.get(item);
		
		if(orderItem == null) {
			orderItem = new OrderItem(item);
			basketItems.put(item, orderItem);
			view.addItemToBasket(orderItem);		
		} 
		else {
			view.updateItemInBasket(orderItem);
		}
		
			
		orderItem.incrementQuantity();
	
		view.updateCount();

	}

	public Map<Item, OrderItem> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(Map<Item, OrderItem> items) {
		this.basketItems = items;
	}

	/**
	 * Fires an event to remove item from the  shopping basket
	 * This should update the model and views respectively.
	 * @param item
	 */
	public void removeFromBasket(final Item item) {
		final RemoveFromShoppingBasketEvent event = new RemoveFromShoppingBasketEvent();
		event.setItemToBeRemoved(item);
		eventBus.fireEvent(event);
	}

	@Override
	public void onRemoveFromBasket(RemoveFromShoppingBasketEvent event) {
		final Item item = event.getItemToBeRemoved();
		
		OrderItem orderItem = basketItems.get(item);
		
		if (orderItem.isLastOne()) {
			basketItems.remove(item);			
			view.removeItemFromBasket(orderItem);
		}
		else {
			orderItem.decrementQuantity();
			view.updateItemInBasket(orderItem);
		}


		view.updateCount();
	}
	
}
