package com.prodcod.client.view.shopping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.shopping.ShoppingPresenter;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;

public class ShoppingPage extends Composite implements ShoppingView{

	private static ShoppingPageUiBinder uiBinder = GWT
			.create(ShoppingPageUiBinder.class);

	interface ShoppingPageUiBinder extends UiBinder<Widget, ShoppingPage> {
	}

	public ShoppingPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;


	public ShoppingPage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValidationMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(ShoppingPresenter presenter) {
		// TODO Auto-generated method stub
		
	}

}
