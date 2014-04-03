package com.tschool.railwayapp.client.gui;

import javax.swing.table.DefaultTableModel;

public class NotEditTableModel extends DefaultTableModel {

    public NotEditTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
   
    public NotEditTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
