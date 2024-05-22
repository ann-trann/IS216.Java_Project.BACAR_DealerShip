package com.view.swing;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class TableLSC extends Table {
    public TableLSC(){
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i == 4){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
    }
    
    /**
     *
     * @param row
     * @param col
     * @return
     */
    public TableCellEditor getCellEditor(int row, int col){
        if (col == 4){
            return new TableCellLSC();
        } return super.getCellEditor();
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }
}
