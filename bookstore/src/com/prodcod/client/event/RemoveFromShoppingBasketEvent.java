package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.prodcod.shared.domain.OrderItem;

/**
 * Event that get's fired when we want to remove an item from the shopping basket
 * @author mo sayed
 *
 */
public class RemoveFromShoppingBasketEvent  extends GwtEvent<RemoveFromShoppingBasketEventHandler> {

	public static Type<RemoveFromShoppingBasketEventHandler> TYPE = new Type<RemoveFromShoppingBasketEventHandler>();
	  
	  private OrderItem itemToBeRemoved;
	  
	  @Override
	  public Type<RemoveFromShoppingBasketEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(RemoveFromShoppingBasketEventHandler handler) {
	    handler.onRemoveFromBasket(this);
	  }

	public OrderItem getItemToBeRemoved() {
		return itemToBeRemoved;
	}

	public void setItemToBeRemoved(OrderItem itemToBeRemove) {
		this.itemToBeRemoved = itemToBeRemove;
	}

}
