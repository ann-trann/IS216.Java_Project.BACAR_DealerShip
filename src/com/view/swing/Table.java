package com.view.swing;

import com.view.swing.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
    public Table(){
        setOpaque(false);
        getTableHeader().setBackground(Color.decode("#FBEED7"));
        setShowHorizontalLines(false);
        setRowHeight(40);
        setGridColor(Color.decode("#FBEED"));
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
              TableHeader header = new TableHeader(o + "");
              header.setBackground(new Color(251, 238, 215));
              return header;
            }
        });
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                com.setBackground(new Color(251, 238, 215));
                setBorder(noFocusBorder);
                com.setForeground(Color.decode("#5E4421"));
                if (selected) {
                    com.setForeground(Color.decode("#C3AD8F"));
                } 
                return com;                
            }
        });
        
    
    
    }
    public void fixTable(JScrollPane scroll){
        scroll.getViewport().setOpaque(true);
        scroll.getViewport().setBackground(new Color(251, 238, 215));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p =new JPanel();
        p.setBackground(new Color(251, 238, 215));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void removeAllRow() {
        DefaultTableModel dm = (DefaultTableModel) getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
    }
    
    public int getFirstCol_RowSelected(int row){
        row=Math.max(row, 0);
        int id;
        DefaultTableModel dm = (DefaultTableModel) getModel();
        id=(Integer)dm.getValueAt(row, 0);
        return id;
    }
}
