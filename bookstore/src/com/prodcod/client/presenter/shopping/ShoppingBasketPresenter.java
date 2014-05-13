package com.prodcod.client.presenter.shopping;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.prodcod.client.event.AddToShoppingBasketEvent;
import com.prodcod.client.event.AddToShoppingBasketEventHandler;
import com.prodcod.shared.domain.Item;

public class ShoppingBasketPresenter implements AddToShoppingBasketEventHandler{

	private List<Item> items;
	
	private ShoppingBasketPanelView view;
	
	public interface ShoppingBasketPanelView {
		void addItemToBasket(final Item item);
		void setPresenter(ShoppingBasketPresenter presenter);
	}
	
	public ShoppingBasketPresenter(ShoppingBasketPanelView view){
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void onAddToBasket(AddToShoppingBasketEvent event) {
		final Item item = event.getItemToBeAdded();
		view.addItemToBasket(item);		
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
