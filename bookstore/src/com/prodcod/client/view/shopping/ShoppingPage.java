package com.prodcod.client.view.shopping;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.shopping.ShoppingPresenter;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;
import com.prodcod.shared.domain.Item;

public class ShoppingPage extends Composite implements ShoppingView{

	private static ShoppingPageUiBinder uiBinder = GWT
			.create(ShoppingPageUiBinder.class);

	interface ShoppingPageUiBinder extends UiBinder<Widget, ShoppingPage> {
	}

	public ShoppingPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	HTMLPanel itemsPanel;


	private ShoppingPresenter presenter;
	
	public ShoppingPage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setValidationMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(ShoppingPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void displayItems(List<Item> items) {
		for (Item item : items) {
			HTML html = new HTML(item.getTitle());
			itemsPanel.add(html);
		}
	}

}
