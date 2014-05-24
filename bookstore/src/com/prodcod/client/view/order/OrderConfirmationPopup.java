package com.prodcod.client.view.order;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.registration.CheckoutPresenter;
import com.prodcod.shared.domain.OrderItem;

public class OrderConfirmationPopup extends DialogBox {

	private static OrderConfirmationPopupUiBinder uiBinder = GWT
			.create(OrderConfirmationPopupUiBinder.class);

	interface OrderConfirmationPopupUiBinder extends
	UiBinder<Widget, OrderConfirmationPopup> {
	}

	@UiField
	Button okButton;

	@UiField
	HTMLPanel panel;

	private CheckoutPresenter presenter;

	//TODO - no longer need to pass in orderitems
	public OrderConfirmationPopup(List<OrderItem> orderItems) {

		super(false, true);

		setWidget(uiBinder.createAndBindUi(this));

		okButton.removeStyleName("gwt-Button");
		okButton.addStyleName("btn btn-primary");

		setGlassEnabled(true);	

	}



	@UiHandler("okButton")
	void onClick(ClickEvent e) {

		this.hide();
		
		presenter.logout();
	}



	public void setPresenter(CheckoutPresenter presenter) {
	 this.presenter = presenter;	
	}


}
