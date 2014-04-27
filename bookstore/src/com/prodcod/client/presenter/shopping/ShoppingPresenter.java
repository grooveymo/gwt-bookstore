package com.prodcod.client.presenter.shopping;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.PagePresenter;

public class ShoppingPresenter implements PagePresenter{

		private final HandlerManager eventBus;
		
		public interface ShoppingView {
			HasClickHandlers getSubmitButton();
			void setValidationMessage(final String message);			
			void setPresenter(ShoppingPresenter presenter);
			
			Widget asWidget();
		}
		
		private final ShoppingView shoppingPage;
		
		public ShoppingPresenter(ShoppingView shoppingPage, HandlerManager eventBus) {
			this.shoppingPage = shoppingPage;		
			this.eventBus = eventBus;
			shoppingPage.setPresenter(this);
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
		
//		public void navigateToRegistrationPage() {
//			eventBus.fireEvent(new RegisterNewUserEvent());
//		}

}
