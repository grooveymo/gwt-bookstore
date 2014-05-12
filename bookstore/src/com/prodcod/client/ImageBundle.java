package com.prodcod.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public interface ImageBundle extends ClientBundle{

	public static final ImageBundle INSTANCE = GWT.create(ImageBundle.class);

	@Source("double_note.png")
	@ImageOptions(height=45, width=45)
	ImageResource musicImage();

	
	@Source("drive-optical.png")
	@ImageOptions(height=45, width=65)
	ImageResource softwareImage();

	@Source("book.png")
	@ImageOptions(height=45, width=95)
	ImageResource bookImage();

}

