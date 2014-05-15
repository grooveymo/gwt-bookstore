package com.prodcod.client.presenter.registration;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.ClientFactoryImpl;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.shared.domain.OrderItem;

public class CheckoutPresenter implements PagePresenter{

	public interface CheckoutView {

		void initialiseDisplay(List<OrderItem> orderItems);

		HasClickHandlers getSubmitButton();
		void setPresenter(CheckoutPresenter presenter);		
		Widget asWidget();
	}
	
	private final CheckoutView checkoutPage;
	
	private final HandlerManager eventBus;


	//GWT create the service
	//TODO: do this elsewhere and pass in (or inject) otherwise be difficult to unit test this code
//    private LoginServiceAsync loginService = GWT.create(LoginService.class);

	public CheckoutPresenter(CheckoutView checkoutPage, HandlerManager eventBus) {
		this.checkoutPage = checkoutPage;		
		this.eventBus = eventBus;
		
		checkoutPage.setPresenter(this);
	}
	
	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(checkoutPage.asWidget());
		checkoutPage.initialiseDisplay(ClientFactoryImpl.INSTANCE.getShoppingBasketModel().getOrderItems());
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub		
	}

}
