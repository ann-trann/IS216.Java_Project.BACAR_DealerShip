package com.view.swing;

import com.event.EventAdminMenuSelected;
import com.model.ModelMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMenu<E extends Object> extends JList<E> {
    
    private final DefaultListModel model = new DefaultListModel();
    private int selectedIndex = -1;
    private EventAdminMenuSelected event;
    
    public void addEvent(EventAdminMenuSelected event){
        this.event = event;
        
    }
    
    public ListMenu(){
        setModel(model);
        addMouseListener(new MouseAdapter(){
           @Override
           public void mousePressed(MouseEvent me){
               if (SwingUtilities.isLeftMouseButton(me)){
                   int index = locationToIndex(me.getPoint());
                   Object o = model.getElementAt(index);
                   selectedIndex = index;
                   if (event != null){
                       event.eventSelected(index);
                   }
                   repaint();
               }
           } 
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jList, Object o, int index, boolean selected, boolean focus){
                ModelMenu data;
                if (o instanceof ModelMenu){
                    data = (ModelMenu) o;
                } else{
                    data = new ModelMenu(o + "");
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                
                return item;
                
            };
            
        };
    }
    
    public void addItem(ModelMenu data){
        model.addElement(data);
    }
}
