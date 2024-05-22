package com.view.swing;

import com.model.ModelEventNV;
import com.view.admin_component.ComponentNV;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellNV extends DefaultCellEditor {
    
    private ModelEventNV data;
    
    public TableCellNV() {
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
    public Component getTableCellEditorComponent(JTable jTable, Object o, boolean bln, int i, int i1){
        data = (ModelEventNV) o;
        ComponentNV cell = new ComponentNV(data);
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
