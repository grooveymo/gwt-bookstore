package com.prodcod.client.presenter.shopping;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.HandlerManager;
import com.prodcod.client.event.AddToShoppingBasketEvent;
import com.prodcod.client.event.AddToShoppingBasketEventHandler;
import com.prodcod.client.event.RemoveFromShoppingBasketEvent;
import com.prodcod.client.event.RemoveFromShoppingBasketEventHandler;
import com.prodcod.shared.domain.Item;

public class ShoppingBasketPresenter implements AddToShoppingBasketEventHandler, RemoveFromShoppingBasketEventHandler {
	
	private ShoppingBasketPanelView view;
	
	private List<Item> basketItems;
	
	private final HandlerManager eventBus;

	public interface ShoppingBasketPanelView {
		void addItemToBasket(final Item item);
		void removeItemFromBasket(final Item item);
		void setPresenter(ShoppingBasketPresenter presenter);
	}
	
	public ShoppingBasketPresenter(ShoppingBasketPanelView view, HandlerManager eventBus){
		this.view = view;
		this.eventBus = eventBus;
		view.setPresenter(this);
		basketItems = new ArrayList<Item>();
	}

	@Override
	public void onAddToBasket(AddToShoppingBasketEvent event) {
		final Item item = event.getItemToBeAdded();
		basketItems.add(item);
		view.addItemToBasket(item);		
	}

	public List<Item> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(List<Item> items) {
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
		basketItems.remove(item);
		view.removeItemFromBasket(item);
	}
	
}
