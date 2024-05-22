package com.view.swing;

import com.model.ModelEventKH;
import com.view.admin_component.ComponentKH;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellKH extends DefaultCellEditor {
    
    private ModelEventKH data;
    
    public TableCellKH() {
        super(new JCheckBox());
    }
    
    /**
     *
     * @param jTable
     * @param o
     * @param bln
     * @param i
     * @param i1
     * @return
     */
    public Component getTableCellEditorComponent(JTable jTable, Object o, boolean bln, int i, int i1) {
        data = (ModelEventKH) o;
        ComponentKH cell = new ComponentKH(data);
        return cell;
    }
    
    /**
     *
     * @return
     */
    public Object getCellEditorValue() {
        return data;
    }
}
