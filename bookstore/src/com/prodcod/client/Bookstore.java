package com.prodcod.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Bookstore implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		//Declare & initialise Eventbus
	    HandlerManager eventBus = new HandlerManager(null);
	    
	    //Declare & initialise AppController 
	    //TODO would declare services here as well and pass into App Controller which in turn would pass
	    //into individual presenters.
//	    AppController appViewer = new AppController(rpcService, eventBus);
	    AppController appViewer = new AppController(eventBus);
	    appViewer.go(RootPanel.get());

	}
	
}
