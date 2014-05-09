package com.prodcod.client.view.shopping;

//import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.DataGrid;

public interface DataGridResources extends DataGrid.Resources {
    
    interface Style extends DataGrid.Style { }

    @Source(value = {DataGrid.Style.DEFAULT_CSS, "BookstoreDataGrid.css"})
    public Style dataGridStyle();
}