package com.prodcod.shared.domain;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = -429708360254033010L;

	private String title;

	private String publisher;

	private float price;

	private int yearPublished;

	/**
	 * no arg constructor
	 */
	public Item(){
		
	}
	
	public Item(final String title, final String publisher, final float price, final int yearPublished) {
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.yearPublished = yearPublished;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	
	
	
}
