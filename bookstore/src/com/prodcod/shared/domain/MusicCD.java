package com.prodcod.shared.domain;

public class MusicCD extends Item{

	private static final long serialVersionUID = -1218825207603759861L;

	private String artist;
	
	public MusicCD(){
		super();
	}
	
	public MusicCD(final String title, final String publisher, final float price, final int yearPublished, final String artist) {
		super(title, publisher, price, yearPublished);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
