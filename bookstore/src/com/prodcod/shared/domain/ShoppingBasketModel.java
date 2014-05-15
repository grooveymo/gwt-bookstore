package com.prodcod.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model representing the items in a shopping basket
 * @author BruceWayne
 *
 */
public class ShoppingBasketModel implements Serializable{

	private static final long serialVersionUID = -9085139706209713209L;

	private Map<Item, OrderItem> basketItems;
	
	public ShoppingBasketModel() {
		basketItems = new HashMap<Item, OrderItem>();
	}

	/**
	 * Adds an item to basket
	 * @param item
	 * @return isMultiple Boolean indicating that this item already present in shopping basket
	 */
	public OrderItem addToBasket(final Item item) {
				
		OrderItem orderItem = basketItems.get(item);
		
		if(orderItem == null) {
			orderItem = new OrderItem(item);
			basketItems.put(item, orderItem);
		} 
		else {
			orderItem.incrementQuantity();
		}
		
		return orderItem;
	}
	
	public OrderItem removeFromBasket(final Item item) {
			
		OrderItem orderItem = basketItems.get(item);
		
		if (orderItem.isLastOne()) {
			basketItems.remove(item);			
		}
		
		orderItem.decrementQuantity();

		return orderItem;

	}
	
	public List<OrderItem> getOrderItems() {
		return new ArrayList<OrderItem>(basketItems.values());
	}
	
}
