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
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;
import com.prodcod.shared.domain.OrderItem;

public class PurchasedOrderItemWidget extends Composite {

	private static PurchasedOrderItemWidgetUiBinder uiBinder = GWT
			.create(PurchasedOrderItemWidgetUiBinder.class);

	interface PurchasedOrderItemWidgetUiBinder extends
			UiBinder<Widget, PurchasedOrderItemWidget> {
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

	private final OrderItem orderItem;

	public PurchasedOrderItemWidget(OrderItem orderItem) {
		initWidget(uiBinder.createAndBindUi(this));
		this.orderItem = orderItem;
		
		final Item item = orderItem.getItem();
		final String title = item.getTitle();
		final String price = String.valueOf(item.getPrice());

		String originator = "";
		if(item.getClass() == Book.class) {
			Book book = (Book)item;
			originator = book.getAuthor();
		}
		else if(item.getClass() == MusicCD.class) {
			MusicCD cd = (MusicCD)item;
			originator = cd.getArtist();
		}
		
		titleField.setInnerHTML(TITLE + title);
		originatorField.setInnerHTML(ARTIST + originator);
		priceField.setInnerHTML(PRICE + price);
		quantityField.setInnerHTML(QUANTITY + orderItem.getCount());
		orderItemContainer.addStyleName("orderItemContainer");

	}


}
