package com.view.swing;

import com.model.ModelEventLSC;
import com.view.admin_component.ComponentLSC;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellLSC extends DefaultCellEditor {

    private ModelEventLSC data;

    public TableCellLSC() {
        super(new JCheckBox());
    }

    public Component getTableCellEditorComponent(JTable jTable, Object o, boolean bln, int i, int i1) {
        data = (ModelEventLSC) o;
        ComponentLSC cell = new ComponentLSC(data);
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
