package com.prodcod.client.view.shopping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.shopping.ShoppingBasketPresenter;
import com.prodcod.shared.domain.Item;

public class ShoppingBasketItem extends Composite {

	private static ShoppingBasketItemUiBinder uiBinder = GWT
			.create(ShoppingBasketItemUiBinder.class);

	interface ShoppingBasketItemUiBinder extends
	UiBinder<Widget, ShoppingBasketItem> {
	}

	private static final String TITLE = "title: ";
	private static final String ARTIST= "artist/author: ";
	private static final String PRICE = "price: ";

	@UiField
	Button removeButton;

	@UiField
	SpanElement titleField, originatorField, priceField;

	@UiField 
	HTMLPanel fieldsPanel;

	private ShoppingBasketPresenter presenter;

	private Item item;
//	public ShoppingBasketItem() {
//		initWidget(uiBinder.createAndBindUi(this));
//		fieldsPanel.addStyleName("basketItem");
//	}


	public ShoppingBasketItem(final String title, final String originator, final String price, final Item item) {

		initWidget(uiBinder.createAndBindUi(this));
		
		this.item = item;
		
		titleField.setInnerHTML(TITLE + title);
		originatorField.setInnerHTML(ARTIST + originator);
		priceField.setInnerHTML(PRICE + price);
		fieldsPanel.addStyleName("basketItem");
	}

	public void setPresenter (final ShoppingBasketPresenter presenter){ 
		this.presenter = presenter;
	}

	@UiHandler("removeButton")
	void onClick(ClickEvent e) {
		presenter.removeFromBasket(item);
	}

}
