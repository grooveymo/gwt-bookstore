package com.prodcod.client.view.order;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.OrderItem;

public class OrderItemWidget extends Composite{

	private static OrderItemWidgetUiBinder uiBinder = GWT
			.create(OrderItemWidgetUiBinder.class);

	interface OrderItemWidgetUiBinder extends UiBinder<Widget, OrderItemWidget> {
	}


	private static final String TITLE = "title: ";
	private static final String ARTIST= "artist/author: ";
	private static final String PRICE = "price: ";
	private static final String QUANTITY = "quantity: ";

	@UiField 
	HTMLPanel orderItemContainer;

	@UiField 
	HTMLPanel orderItemfieldsPanel;

	@UiField
	SpanElement titleField, originatorField, priceField, quantityField;

	@UiField
	Button removeButton;

	private final OrderItem orderItem;
	
	//TODO ; refactor to remove fields and just use OrderItem class
	public OrderItemWidget(final String title, final String originator, final String price, final OrderItem item) {

		initWidget(uiBinder.createAndBindUi(this));
		
		this.orderItem = item;
		
		titleField.setInnerHTML(TITLE + title);
		originatorField.setInnerHTML(ARTIST + originator);
		priceField.setInnerHTML(PRICE + price);
		quantityField.setInnerHTML(QUANTITY + orderItem.getCount());

//		orderItemfieldsPanel.addStyleName("basketItem");

		orderItemContainer.addStyleName("orderItemContainer");
	}

	@UiHandler("removeButton")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

}
