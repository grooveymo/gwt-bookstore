package com.prodcod.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.prodcod.shared.domain.BookStore;
import com.prodcod.shared.domain.Item;

public interface BookstoreServiceAsync {

	void getBookstore(AsyncCallback<BookStore> callback);

	void performSearch(String type, String searchTerms,
			AsyncCallback<List<Item>> callback);

}
