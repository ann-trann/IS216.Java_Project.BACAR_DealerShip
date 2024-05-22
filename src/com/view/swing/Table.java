package com.view.swing;

import com.view.swing.customscrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

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
                return com;                
            }
        });
        
    
    
    }
    public void fixTable(JScrollPane scroll){
        scroll.getViewport().setBackground(Color.decode("#FBEED7"));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p =new JPanel();
        p.setBackground(Color.decode("#FBEED7"));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
