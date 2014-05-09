package com.prodcod.client.presenter.shopping;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;
import com.prodcod.client.service.BookstoreService;
import com.prodcod.client.service.BookstoreServiceAsync;
import com.prodcod.shared.domain.BookStore;
import com.prodcod.shared.domain.Item;

public class ShoppingPresenter implements PagePresenter{

	//GWT create the service
	//TODO: do this elsewhere and pass in (or inject) otherwise be difficult to unit test this code
	private BookstoreServiceAsync bookstoreService = GWT.create(BookstoreService.class);

	private final HandlerManager eventBus;

	public interface ShoppingView {
		void setValidationMessage(final String message);			
		void setPresenter(ShoppingPresenter presenter);

		void displayItems(List<Item> items);
		Widget asWidget();
	}

	private final ShoppingView shoppingPage;

	public ShoppingPresenter(ShoppingView shoppingPage, HandlerManager eventBus) {
		this.shoppingPage = shoppingPage;		
		this.eventBus = eventBus;
		shoppingPage.setPresenter(this);
		retrieveItems();
	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(shoppingPage.asWidget());
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub

	}


	private void retrieveItems() {
		bookstoreService.getBookstore(new AsyncCallback<BookStore>() {
			
			@Override
			public void onSuccess(BookStore bookstore) {
				shoppingPage.displayItems(bookstore.getItems());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
