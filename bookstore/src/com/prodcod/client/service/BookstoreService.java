package com.prodcod.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.prodcod.shared.domain.BookStore;

@RemoteServiceRelativePath("bookstore")
public interface BookstoreService extends RemoteService {

	BookStore getBookstore();

}
