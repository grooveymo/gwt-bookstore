package com.prodcod.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

public abstract interface PagePresenter {
  public abstract void go(final HasWidgets container);  
  public abstract void bind();
}
