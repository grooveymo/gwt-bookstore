package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.prodcod.shared.domain.Item;

public class RemoveFromShoppingBasketEvent  extends GwtEvent<RemoveFromShoppingBasketEventHandler> {

	public static Type<RemoveFromShoppingBasketEventHandler> TYPE = new Type<RemoveFromShoppingBasketEventHandler>();
	  
	  private Item itemToBeRemoved;
	  
	  @Override
	  public Type<RemoveFromShoppingBasketEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(RemoveFromShoppingBasketEventHandler handler) {
	    handler.onRemoveFromBasket(this);
	  }

	public Item getItemToBeRemoved() {
		return itemToBeRemoved;
	}

	public void setItemToBeRemoved(Item itemToBeRemove) {
		this.itemToBeRemoved = itemToBeRemove;
	}

}
