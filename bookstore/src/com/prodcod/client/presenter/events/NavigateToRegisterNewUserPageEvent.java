package com.prodcod.client.presenter.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Fire this event when you want to navigate to the page to register a new Customer
 * @author BruceWayne
 *
 */
public class NavigateToRegisterNewUserPageEvent extends GwtEvent<NavigateToRegisterNewUserPageEventHandler> {
  public static Type<NavigateToRegisterNewUserPageEventHandler> TYPE = new Type<NavigateToRegisterNewUserPageEventHandler>();
  
  @Override
  public Type<NavigateToRegisterNewUserPageEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(NavigateToRegisterNewUserPageEventHandler handler) {
    handler.onRegisterNewUser(this);
  }
}
