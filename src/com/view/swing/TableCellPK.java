package com.view.swing;

import com.view.admin_component.ComponentPK;
import com.model.ModelEventPK;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellPK extends DefaultCellEditor {
    
    private ModelEventPK data;
    
    public TableCellPK() {
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
        data = (ModelEventPK) o;
        ComponentPK cell = new ComponentPK(data);
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
