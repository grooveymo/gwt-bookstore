package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.prodcod.shared.domain.Item;

public class AddToShoppingBasketEvent extends GwtEvent<AddToShoppingBasketEventHandler> {
	  public static Type<AddToShoppingBasketEventHandler> TYPE = new Type<AddToShoppingBasketEventHandler>();
	  
	  private Item itemToBeAdded;
	  
	  @Override
	  public Type<AddToShoppingBasketEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(AddToShoppingBasketEventHandler handler) {
	    handler.onAddToBasket(this);
	  }

	public Item getItemToBeAdded() {
		return itemToBeAdded;
	}

	public void setItemToBeAdded(Item itemToBeAdded) {
		this.itemToBeAdded = itemToBeAdded;
	}
	  

}
