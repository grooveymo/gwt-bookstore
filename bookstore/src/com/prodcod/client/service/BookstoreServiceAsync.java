package com.prodcod.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.prodcod.shared.domain.BookStore;

public interface BookstoreServiceAsync {

	void getBookstore(AsyncCallback<BookStore> callback);

}
