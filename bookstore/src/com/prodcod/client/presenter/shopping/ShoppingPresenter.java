package com.prodcod.client.presenter.shopping;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.event.AddToShoppingBasketEvent;
import com.prodcod.client.event.RemoveFromShoppingBasketEvent;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.service.BookstoreService;
import com.prodcod.client.service.BookstoreServiceAsync;
import com.prodcod.shared.domain.BookStore;
import com.prodcod.shared.domain.Item;

public class ShoppingPresenter implements PagePresenter{

	//GWT create the service
	//TODO: do this elsewhere and pass in (or inject) otherwise be difficult to unit test this code
	private BookstoreServiceAsync bookstoreService = GWT.create(BookstoreService.class);

	private final HandlerManager eventBus;

	public interface ShoppingView {
		void setValidationMessage(final String message);			
		void setPresenter(ShoppingPresenter presenter);

		void displayItems(List<Item> items);
		
		void updateDisplay(List<Item> items);
		
		ShoppingBasketPresenter getShoppingBasketPresenter();
		
		Widget asWidget();
	}

	private final ShoppingView shoppingPage;

	private HandlerRegistration addItemHandler;
	private HandlerRegistration removeItemHandler;
	
	public ShoppingPresenter(ShoppingView shoppingPage, HandlerManager eventBus) {
		this.shoppingPage = shoppingPage;		
		this.eventBus = eventBus;
		shoppingPage.setPresenter(this);
		retrieveItems();
	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(shoppingPage.asWidget());
	}

	@Override
	public void bind() {
//		eventBus.removeHandler(AddToShoppingBasketEvent.TYPE, addItemHandler);
		
		if(addItemHandler != null) {
			addItemHandler.removeHandler();			
		}
		if(removeItemHandler != null) {
			removeItemHandler.removeHandler();			
		}
		
		addItemHandler = eventBus.addHandler(AddToShoppingBasketEvent.TYPE, shoppingPage.getShoppingBasketPresenter());  
		removeItemHandler = eventBus.addHandler(RemoveFromShoppingBasketEvent.TYPE, shoppingPage.getShoppingBasketPresenter());  
	}


	private void retrieveItems() {
		bookstoreService.getBookstore(new AsyncCallback<BookStore>() {
			
			@Override
			public void onSuccess(BookStore bookstore) {
				shoppingPage.displayItems(bookstore.getItems());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * @param type Type of search. Can have values, 'All', 'title', 'originator', 'publisher'
	 * @param searchWords The search terms
	 */
	public void performSearch(final String type, final String searchTerms) {

		bookstoreService.performSearch(type, searchTerms, new AsyncCallback<List<Item>>() {
			
			@Override
			public void onSuccess(List<Item> items) {
				shoppingPage.updateDisplay(items);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * Fires an event to add item to shopping basket
	 * This should update the model and views respectively.
	 * @param item
	 */
	public void addToBasket(final Item item) {
		final AddToShoppingBasketEvent event = new AddToShoppingBasketEvent();
		event.setItemToBeAdded(item);
		eventBus.fireEvent(event);
	}

	public HandlerManager getEventBus() {
		return eventBus;
	}
	
//	/**
//	 * Fires an event to remove item from the  shopping basket
//	 * This should update the model and views respectively.
//	 * @param item
//	 */
//	public void removeFromBasket(final Item item) {
//		final RemoveFromShoppingBasketEvent event = new RemoveFromShoppingBasketEvent();
//		event.setItemToBeRemoved(item);
//		eventBus.fireEvent(event);
//	}

}
