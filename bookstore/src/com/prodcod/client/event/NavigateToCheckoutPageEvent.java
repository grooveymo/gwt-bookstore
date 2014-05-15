package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

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
