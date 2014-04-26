package com.prodcod.client.presenter.events;

import com.google.gwt.event.shared.EventHandler;

public interface RegisterNewUserEventHandler extends EventHandler {
  void onRegisterNewUser(RegisterNewUserEvent event);
}
