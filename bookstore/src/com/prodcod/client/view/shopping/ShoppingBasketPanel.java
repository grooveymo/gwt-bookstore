package com.prodcod.client.view.shopping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.ImageBundle;
import com.prodcod.client.presenter.shopping.ShoppingBasketPresenter;
import com.prodcod.client.presenter.shopping.ShoppingBasketPresenter.ShoppingBasketPanelView;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;
import com.prodcod.shared.domain.OrderItem;

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
	
	@UiField
	HTMLPanel numItemsPanel;

	@UiField
	Image basketImage;

	@UiField
	SpanElement numItems;

	private Map<Item, ShoppingBasketItem> map;
	
	
	public ShoppingBasketPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		ShoppingBasketItemsPanel.getElement().setId("shoppingBasketItemsPanel");
		map = new HashMap<Item, ShoppingBasketItem>();
		
		ImageResource img = ImageBundle.INSTANCE.cartImage();
		basketImage.setUrl(img.getURL());
		basketImage.getElement().setId("basketImage");

		numItemsPanel.getElement().setId("numItemsPanel");
		checkoutButton.getElement().setId("checkoutButton");
	}


	@Override
	public void setPresenter(ShoppingBasketPresenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("checkoutButton")
	void onClick(ClickEvent e) {
			presenter.checkout();
	}

	@Override
	public void addItemToBasket(OrderItem orderItem) {

		String originator = "";
		final Item item = orderItem.getItem();

		//TODO ; refactor to enable reuse following check - also think about using Decorator pattern to relate OrderItem to Item
		if(item.getClass() == Book.class) {
			Book book = (Book)item;
			originator = book.getAuthor();
		}
		else if(item.getClass() == MusicCD.class) {
			MusicCD cd = (MusicCD)item;
			originator = cd.getArtist();
		}

		final ShoppingBasketItem basketItem = new ShoppingBasketItem(item.getTitle(),originator, String.valueOf(item.getPrice()), item);
		basketItem.setPresenter(presenter);
		
		map.put(item, basketItem);
		ShoppingBasketItemsPanel.add(basketItem);
		
	}


	@Override
	public void removeItemFromBasket(OrderItem orderItem) {
		final Item item = orderItem.getItem();
		final ShoppingBasketItem basketItem = map.get(item);
		ShoppingBasketItemsPanel.remove(basketItem);
		map.remove(item);
	}


	@Override
	public void updateItemInBasket(OrderItem orderItem) {
		
		final Item item = orderItem.getItem();
		ShoppingBasketItem shoppingBasketItem = map.get(item);
		shoppingBasketItem.updateQuantity(orderItem.getCount());
	}

	@Override
	public void updateCount(int count) {
		
		numItems.setInnerText("Number of Items: " + count);		
	}


}
