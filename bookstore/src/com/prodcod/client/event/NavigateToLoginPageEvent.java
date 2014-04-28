package com.prodcod.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class NavigateToLoginPageEvent extends GwtEvent<NavigateToLoginPageEventHandler> {
	  public static Type<NavigateToLoginPageEventHandler> TYPE = new Type<NavigateToLoginPageEventHandler>();
	  
	  @Override
	  public Type<NavigateToLoginPageEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(NavigateToLoginPageEventHandler handler) {
	    handler.onDisplayLoginPage(this);
	  }

}
