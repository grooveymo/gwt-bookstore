package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event that get's fired when we want to navigate to Shopping page
 * @author mo sayed
 *
 */
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
