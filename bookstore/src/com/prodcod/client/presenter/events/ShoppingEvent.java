package com.prodcod.client.presenter.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ShoppingEvent extends GwtEvent<ShoppingEventHandler> {
	  public static Type<ShoppingEventHandler> TYPE = new Type<ShoppingEventHandler>();
	  
	  @Override
	  public Type<ShoppingEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShoppingEventHandler handler) {
	    handler.onShopping(this);
	  }
}
