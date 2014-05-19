package com.prodcod.client.view.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.registration.CheckoutPresenter;
import com.prodcod.client.presenter.registration.CheckoutPresenter.CheckoutView;
import com.prodcod.client.view.shopping.ShoppingBasketItem;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;
import com.prodcod.shared.domain.OrderItem;

public class CheckoutPage extends Composite implements CheckoutView{

	private static CheckoutPageUiBinder uiBinder = GWT
			.create(CheckoutPageUiBinder.class);

	interface CheckoutPageUiBinder extends UiBinder<Widget, CheckoutPage> {
	}

	@UiField
	Label numItems;
	
	@UiField
	Label totalCost;


	@UiField
	HTMLPanel checkoutPanel;

	@UiField
	HTMLPanel orderItemsPanel;

	@UiField
	Button submitOrderButton;

	private CheckoutPresenter presenter;	

	private Map<OrderItem, OrderItemWidget> map;
	
	public CheckoutPage() {
		initWidget(uiBinder.createAndBindUi(this));
		map = new HashMap<OrderItem, OrderItemWidget>();
		checkoutPanel.getElement().setId("checkoutPanel");
	}


	@UiHandler("submitOrderButton")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPresenter(CheckoutPresenter presenter) {
		this.presenter = presenter;
		
	}


	@Override
	public void initialiseDisplay(List<OrderItem> orderItems) {

		orderItemsPanel.clear();

		for(OrderItem orderItem : orderItems) {
	
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

			
			OrderItemWidget widget = new OrderItemWidget(title, originator, price, orderItem);
			widget.setPresenter(presenter);
			
			orderItemsPanel.add(widget);
			map.put(orderItem, widget);
		}
	}


	@Override
	public void removeItemFromBasket(final OrderItem orderItem) {

		final OrderItemWidget basketItem = map.get(orderItem);
		
		orderItemsPanel.remove(basketItem);

		map.remove(orderItem);

	}
	
	


	@Override
	public void updateItemInBasket(final OrderItem orderItem) {
		
		final OrderItemWidget basketItem = map.get(orderItem);
		
		basketItem.updateQuantity();		
	}



}
