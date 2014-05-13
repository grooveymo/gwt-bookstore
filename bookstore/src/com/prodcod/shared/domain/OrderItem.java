package com.prodcod.shared.domain;

import java.io.Serializable;

public class OrderItem implements Serializable{

	private static final long serialVersionUID = 8550809367351405777L;
	
	private Item item;
	
	private int count;

	public OrderItem(Item item) {
		this.item = item;
		count = 0;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void incrementQuantity() {
		count++;
	}
	
	public void decrementQuantity() {
		count--;
	}
	public boolean isLastOne() {
		return count == 1;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (count != other.count)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
