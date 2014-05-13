package com.prodcod.client.view.shopping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.shopping.ShoppingBasketPresenter;
import com.prodcod.client.presenter.shopping.ShoppingBasketPresenter.ShoppingBasketPanelView;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;

public class ShoppingBasketPanel extends Composite implements ShoppingBasketPanelView  {

	private static ShoppingBasketPanelUiBinder uiBinder = GWT
			.create(ShoppingBasketPanelUiBinder.class);

	interface ShoppingBasketPanelUiBinder extends
			UiBinder<Widget, ShoppingBasketPanel> {
	}

	@UiField
	Button checkoutButton;

	private ShoppingBasketPresenter presenter;
	
	@UiField
	HTMLPanel ShoppingBasketItemsPanel;
	
	public ShoppingBasketPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		ShoppingBasketItemsPanel.getElement().setId("shoppingBasketItemsPanel");
	}


	@Override
	public void setPresenter(ShoppingBasketPresenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("checkoutButton")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	@Override
	public void addItemToBasket(Item item) {

		String originator = "";
		
		if(item.getClass() == Book.class) {
			Book book = (Book)item;
			originator = book.getAuthor();
		}
		else if(item.getClass() == MusicCD.class) {
			MusicCD cd = (MusicCD)item;
			originator = cd.getArtist();
		}

		final ShoppingBasketItem basketItem = new ShoppingBasketItem(item.getTitle(),originator, String.valueOf(item.getPrice()));
		ShoppingBasketItemsPanel.add(basketItem);
	}


}
