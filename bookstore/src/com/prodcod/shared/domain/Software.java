package com.prodcod.shared.domain;

public class Software extends Item{

	private static final long serialVersionUID = -6217859636747384825L;

	private String version;
	
	public Software(){
		super();
	}
	
	public Software(final String title, final String publisher, final float price, final int yearPublished, final String version) {
		super(title, publisher, price, yearPublished);
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
