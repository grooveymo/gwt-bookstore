package com.prodcod.client.view.shopping;



import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.shopping.ShoppingPresenter;

public class SearchPanel extends Composite {

	private static SearchPanelUiBinder uiBinder = GWT
			.create(SearchPanelUiBinder.class);

	interface SearchPanelUiBinder extends UiBinder<Widget, SearchPanel> {
	}

	@UiField
	TextBox searchInput;

	@UiField
	Button searchButton;
	
	@UiField
	RadioButton all, title, authorOrArtist, publisher;
	
	@UiField
	SpanElement resultsCount;
	
	private ShoppingPresenter presenter;
	
	public SearchPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		searchInput.addStyleName("middle");
		searchButton.addStyleName("right");
		resultsCount.setId("resultsCountPanel");
	}


	public void setPresenter(ShoppingPresenter presenter) {
		this.presenter = presenter;
	}
	@UiHandler("searchButton")
	void onClick(ClickEvent e) {
		String type = null;
		
		if(all.getValue()) {
			type = "all";
		}
		else if(title.getValue()) {
			type = "title";
		}
		else if(publisher.getValue()) {
			type = "publisher";
		}
		else if(authorOrArtist.getValue()) {
			type = "originator";
		}
		
		String searchTerms = searchInput.getValue();
		
		presenter.performSearch(type, searchTerms);
	}


	public void updateResultsCount(final String count) {
		resultsCount.setInnerHTML("Number of results: " + count);
	}
}
