package com.prodcod.shared.domain;

public class Book extends Item{

	private static final long serialVersionUID = 3299079753642372160L;

	private String author;
	
	public Book(){
		super();
	}
	
	public Book(final String title, final String publisher, final float price, final int yearPublished, final String author) {
		super(title, publisher, price, yearPublished);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
