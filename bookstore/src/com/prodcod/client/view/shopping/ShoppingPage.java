package com.prodcod.client.view.shopping;

import java.util.List;

import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.prodcod.client.ImageBundle;
import com.prodcod.client.presenter.shopping.ShoppingPresenter;
import com.prodcod.client.presenter.shopping.ShoppingPresenter.ShoppingView;
import com.prodcod.shared.domain.Book;
import com.prodcod.shared.domain.Item;
import com.prodcod.shared.domain.MusicCD;
import com.prodcod.shared.domain.Software;
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

   	@UiField
   	HTMLPanel itemsPanel;


   	@UiField
   	ResizeLayoutPanel tablePanel;

   	@UiField
   	SearchPanel searchPanel;

   	private ShoppingPresenter presenter;
   	

	public ShoppingPage() {
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
		this.searchPanel.setPresenter(presenter);
	}

	@Override
	public void displayItems(List<Item> items) {
		
		tablePanel.clear();
		tablePanel.add(populateDataGrid(items));
		
		searchPanel.updateResultsCount(String.valueOf(items.size()));

	}
	
	private DataGrid<Item> populateDataGrid(List<Item> items) {

		DataGrid<Item> dataGrid = new DataGrid<Item>(items.size(), gwtCssDataGridResources);

		dataGrid.addColumn(createImageColumn(), "Type");
		dataGrid.addColumn(createTitleColumn(), "Title");
		dataGrid.addColumn(createOriginatorColumn(),"Author/Artist");
		dataGrid.addColumn(createPublisherColumn(),"Publisher");
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

	private TextColumn<Item> createPublisherColumn(){
		TextColumn<Item> title = new TextColumn<Item>() {

			@Override
			public String getValue(Item item) {
				return item.getPublisher();
			}			
		};
		
		return title;
	}

	private TextColumn<Item> createPriceColumn(){
		final NumberFormat frmt = NumberFormat.getFormat(".##");
		
		TextColumn<Item> price = new TextColumn<Item>() {

			@Override
			public String getValue(Item item) {
				return String.valueOf(frmt.format(item.getPrice()));
			}			
		};
		
		return price;
	}

	public Column<Item, ImageResource> createImageColumn() {
		Column<Item, ImageResource> imageColumn = new Column<Item, ImageResource>(new ImageResourceCell()) {
		    @Override
		    public ImageResource getValue(Item item) {

		    	ImageResource resource = null;
		    	
		    	if(item.getClass() == Book.class) {
			        resource = ImageBundle.INSTANCE.bookImage();		    			    		
		    	}
		    	else if(item.getClass() == MusicCD.class) {
			        resource = ImageBundle.INSTANCE.musicImage();		    			    		
		    	}
		    	else if(item.getClass() == Software.class) {
			        resource = ImageBundle.INSTANCE.softwareImage();		    			    		
		    	}
		    	
		    	return resource;
		    			
		    }
		  };
		  
		  return imageColumn;
	}
	
	
	@Override
	public void updateDisplay(List<Item> items) {
		displayItems(items);
	}

}
