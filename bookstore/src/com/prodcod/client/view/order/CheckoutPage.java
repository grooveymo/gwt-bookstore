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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.order.CheckoutPresenter;
import com.prodcod.client.presenter.order.CheckoutPresenter.CheckoutView;
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
	HTMLPanel orderItemsPanel, submitButtonPanel, summarySectionPanel;

	@UiField
	Button submitOrderButton;
	
	private CheckoutPresenter presenter;	

	private Map<OrderItem, OrderItemWidget> map;

	public CheckoutPage() {
		initWidget(uiBinder.createAndBindUi(this));
		map = new HashMap<OrderItem, OrderItemWidget>();
		checkoutPanel.getElement().setId("checkoutPanel");
		
		checkoutPanel.addStyleName("panel panel-primary");
		
		summarySectionPanel.addStyleName("panel panel-success");

		submitButtonPanel.addStyleName("panel-footer");
		
		numItems.addStyleName("col-sm-2");
		totalCost.addStyleName("col-sm-2");
				
		submitOrderButton.removeStyleName("gwt-Button");
		submitOrderButton.addStyleName("btn btn-primary");
	}


	@UiHandler("submitOrderButton")
	void onClick(ClickEvent e) {
		presenter.completeOrder();
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

		int numItemsValue = 0;
		float totalCostValue = 0.0f;
		
		for(OrderItem orderItem : orderItems) {

			final Item item = orderItem.getItem();
			final String title = item.getTitle();
			final String price = String.valueOf(item.getPrice());
			
			numItemsValue = orderItem.getCount();
			totalCostValue += (numItemsValue * item.getPrice());
					
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
		
		this.numItems.setText(String.valueOf(numItemsValue));
		this.totalCost.setText(String.valueOf(totalCostValue));
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


	@Override
	public void displayOrderConfirmationPopup(List<OrderItem> orderItems) {

		OrderConfirmationPopup popup = new OrderConfirmationPopup(orderItems);
		popup.setPresenter(presenter);
		popup.center();
		popup.show();
		
		
//		final PopupPanel popUp = new PopupPanel(false);
//
//		VerticalPanel panel = new VerticalPanel();
//
//		//add basket items
//
//		for(OrderItem orderItem : orderItems) {			
//			PurchasedOrderItemWidget widget = new PurchasedOrderItemWidget(orderItem);			
//			panel.add(widget);		
//		}
//
//		//add button to close
//		Button confirmButton = new Button("Ok");
//		confirmButton.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				popUp.hide();
//			}
//		});
//		
//		panel.add(confirmButton);
//
//		popUp.setWidget(panel);
//		
//		popUp.center();
//		popUp.show();
	}


}
