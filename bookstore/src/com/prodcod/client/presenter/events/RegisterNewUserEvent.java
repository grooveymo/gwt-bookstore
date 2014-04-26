package com.prodcod.client.presenter.events;

import com.google.gwt.event.shared.GwtEvent;

public class RegisterNewUserEvent extends GwtEvent<RegisterNewUserEventHandler> {
  public static Type<RegisterNewUserEventHandler> TYPE = new Type<RegisterNewUserEventHandler>();
  
  @Override
  public Type<RegisterNewUserEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(RegisterNewUserEventHandler handler) {
    handler.onRegisterNewUser(this);
  }
}
