package com.view.admin_component;

import java.awt.Cursor;
import java.awt.event.ActionListener;


public class HeaderAdmin extends javax.swing.JPanel {

    public void addMenuEvent(ActionListener event){
        cmdMenu.addActionListener(event);
    }
    
    public HeaderAdmin() {
        initComponents();
        cmdMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new com.view.swing.Button();

        setBackground(new java.awt.Color(183, 150, 107));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/GetIn.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdMenu;
    // End of variables declaration//GEN-END:variables
}
