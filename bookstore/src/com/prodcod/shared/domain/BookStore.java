package com.prodcod.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookStore implements Serializable{

	private static final long serialVersionUID = -3536932780968923538L;

	private String name;
	
	private List<Item> items = new ArrayList<Item>();
	
	public BookStore(){
		
	}
	
	public BookStore(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
