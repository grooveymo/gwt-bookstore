package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Fire this event when you want to navigate to Order Summary Page
 * @author BruceWayne
 *
 */
public class NavigateToOrderSummaryPageEvent extends GwtEvent<NavigateToOrderSummaryPageEventHandler> {
	  public static Type<NavigateToOrderSummaryPageEventHandler> TYPE = new Type<NavigateToOrderSummaryPageEventHandler>();
	  
	  @Override
	  public Type<NavigateToOrderSummaryPageEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(NavigateToOrderSummaryPageEventHandler handler) {
	    handler.onCheckout(this);
	  }

}
