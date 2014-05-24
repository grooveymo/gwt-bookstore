package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 * Event that get's fired when we want to navigate to Checkout page.
 * @author mo sayed
 *
 */
public class NavigateToCheckoutPageEvent extends GwtEvent<NavigateToCheckoutPageEventHandler> {
	  public static Type<NavigateToCheckoutPageEventHandler> TYPE = new Type<NavigateToCheckoutPageEventHandler>();
	  
	  @Override
	  public Type<NavigateToCheckoutPageEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(NavigateToCheckoutPageEventHandler handler) {
	    handler.onDisplayCheckoutPage(this);
	  }


}
