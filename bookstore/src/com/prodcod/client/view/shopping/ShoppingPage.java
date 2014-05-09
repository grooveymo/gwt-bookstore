package com.prodcod.client.view.shopping;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.presenter.shopping.ShoppingPresenter;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;

public class ShoppingPage extends Composite implements ShoppingView{

	private static ShoppingPageUiBinder uiBinder = GWT
			.create(ShoppingPageUiBinder.class);

	interface ShoppingPageUiBinder extends UiBinder<Widget, ShoppingPage> {
	}

	//Inject in custom styles for DataGrid
	public static final DataGridResources gwtCssDataGridResources = GWT.create(DataGridResources.class);
    
	static {
          gwtCssDataGridResources.dataGridStyle().ensureInjected();
       };

	public ShoppingPage() {
		initWidget(uiBinder.createAndBindUi(this));
		itemsPanel.getElement().setId("itemsPanel");
		tablePanel.getElement().setId("tablePanel");		
	}

	@UiField
	HTMLPanel itemsPanel;


	@UiField
	ResizeLayoutPanel tablePanel;

	private ShoppingPresenter presenter;
	
	public ShoppingPage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		itemsPanel.getElement().setId("itemsPanel");
		tablePanel.getElement().setId("tablePanel");
	}

	@Override
	public void setValidationMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(ShoppingPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void displayItems(List<Item> items) {
		

		tablePanel.setSize("800px", "600px");
		tablePanel.add(populateDataGrid(items));

	}
	
	private DataGrid<Item> populateDataGrid(List<Item> items) {

		DataGrid<Item> dataGrid = new DataGrid<Item>(items.size(), gwtCssDataGridResources);

		dataGrid.addColumn(createTitleColumn(), "Title");
		dataGrid.addColumn(createOriginatorColumn(),"Author/Artist");
		dataGrid.addColumn(createPriceColumn(),"Price");
		
		dataGrid.setRowCount(items.size());
		
		dataGrid.setRowData(0, items);
		return dataGrid;
	}
	
	private TextColumn<Item> createTitleColumn(){
		TextColumn<Item> title = new TextColumn<Item>() {

			@Override
			public String getValue(Item item) {
				return item.getTitle();
			}			
		};
		
		return title;
	}

	private TextColumn<Item> createOriginatorColumn(){
		TextColumn<Item> originator = new TextColumn<Item>() {

			@Override
			public String getValue(Item item) {
				String value = "";
				
				if(item instanceof Book) {
					value = ((Book) item).getAuthor();
				}
				else if(item instanceof MusicCD) {
					value = ((MusicCD) item).getArtist();
				}
				return value;
			}			
		};
		
		return originator;
	}

	private TextColumn<Item> createPriceColumn(){
		TextColumn<Item> price = new TextColumn<Item>() {

			@Override
			public String getValue(Item item) {
				return String.valueOf(item.getPrice());
			}			
		};
		
		return price;
	}

}
