package com.view.form;

import com.view.admin_component.HDForm;
import com.view.admin_component.MenuHoaDon;
import net.miginfocom.swing.MigLayout;


public class AdminHDForm extends javax.swing.JPanel {

    private HDForm form;
    private MenuHoaDon menu;
    private MigLayout layout;
    
    public AdminHDForm() {
        initComponents();
        init();
    }
    
    private void init(){
        layout = new MigLayout("fill, insets 0");
        setLayout(layout);
        menu = new MenuHoaDon();
        add(menu, "width 30%, pos 0al 0 n 100%");
        form = new HDForm();
        add(form, "width 70%, pos 1al 0 n 100%");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(251, 238, 215));
        setForeground(new java.awt.Color(195, 173, 143));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
