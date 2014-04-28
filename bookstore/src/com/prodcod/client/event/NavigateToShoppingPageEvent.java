package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class NavigateToShoppingPageEvent extends GwtEvent<NavigateToShoppingPageEventHandler> {
	  public static Type<NavigateToShoppingPageEventHandler> TYPE = new Type<NavigateToShoppingPageEventHandler>();
	  
	  @Override
	  public Type<NavigateToShoppingPageEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(NavigateToShoppingPageEventHandler handler) {
	    handler.onDisplayShoppingPage(this);
	  }
}
