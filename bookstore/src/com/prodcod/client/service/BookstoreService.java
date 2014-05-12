package com.prodcod.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.prodcod.shared.domain.BookStore;
import com.prodcod.shared.domain.Item;

@RemoteServiceRelativePath("bookstore")
public interface BookstoreService extends RemoteService {

	BookStore getBookstore();

	List<Item> performSearch(String type, String searchTerms);
}
