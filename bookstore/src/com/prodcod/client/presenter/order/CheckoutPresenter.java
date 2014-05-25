package com.prodcod.client.presenter.order;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.ClientFactoryImpl;
import com.prodcod.client.event.RemoveFromShoppingBasketEvent;
import com.prodcod.client.event.RemoveFromShoppingBasketEventHandler;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.OrderItem;

public class CheckoutPresenter implements PagePresenter, RemoveFromShoppingBasketEventHandler{

	public interface CheckoutView {

		void initialiseDisplay(List<OrderItem> orderItems);

		HasClickHandlers getSubmitButton();
		void setPresenter(CheckoutPresenter presenter);		
		
		void removeItemFromBasket(final OrderItem orderItem);

		void updateItemInBasket(final OrderItem orderItem);
		
		void displayOrderConfirmationPopup(final List<OrderItem> orderItems);
		
		Widget asWidget();
	}
	
	private final CheckoutView checkoutPage;
	
	private final HandlerManager eventBus;

	private static HandlerRegistration removeItemHandler;

	//GWT create the service
	//TODO: do this elsewhere and pass in (or inject) otherwise be difficult to unit test this code
//    private LoginServiceAsync loginService = GWT.create(LoginService.class);

	public CheckoutPresenter(CheckoutView checkoutPage, HandlerManager eventBus) {
		this.checkoutPage = checkoutPage;		
		this.eventBus = eventBus;
		
		checkoutPage.setPresenter(this);
	}
	
	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(checkoutPage.asWidget());
		checkoutPage.initialiseDisplay(ClientFactoryImpl.INSTANCE.getShoppingBasketModel().getOrderItems());
	}

	@Override
	public void bind() {
		if(removeItemHandler != null) {
			removeItemHandler.removeHandler();			
		}
		
		removeItemHandler = eventBus.addHandler(RemoveFromShoppingBasketEvent.TYPE, this);  

	}

	/**
	 * Remove item from shopping basket
	 * @param orderItem
	 */
	public void removeItem(final OrderItem orderItem) {
		
		//update model
		ClientFactoryImpl.INSTANCE.getShoppingBasketModel().removeFromBasket(orderItem.getItem());

		final RemoveFromShoppingBasketEvent event = new RemoveFromShoppingBasketEvent();
		event.setItemToBeRemoved(orderItem);
		eventBus.fireEvent(event);	
	}

	@Override
	public void onRemoveFromBasket(RemoveFromShoppingBasketEvent event) {

		final OrderItem orderItem = event.getItemToBeRemoved();
		
		//update view
		if (orderItem.getCount() == 0) {
			checkoutPage.removeItemFromBasket(orderItem);
		}
		else {
			checkoutPage.updateItemInBasket(orderItem);
		}

//		checkoutPage.updateCount(ClientFactoryImpl.INSTANCE.getShoppingBasketModel().getNumberOfItems());

		
	}

	/**
	 * Customer has placed order. Display dialog to confirm this
	 */
	public void completeOrder() {
		checkoutPage.displayOrderConfirmationPopup(ClientFactoryImpl.INSTANCE.getShoppingBasketModel().getOrderItems());
	}
	
	
	public void logout() {
		History.newItem("login");
	}
}
