/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.view.admin_component;

import com.model.ModelEventPK;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentPK extends javax.swing.JPanel {

    public ComponentPK(ModelEventPK data) {
        initComponents();
        setOpaque(false);
        cmdUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                data.getEvent().update(data.getModel());
            }
            
        });
        
        cmdDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                data.getEvent().delete(data.getModel());
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdDelete = new com.view.swing.ButtonOutLine();
        cmdUpdate = new com.view.swing.ButtonOutLine();

        cmdDelete.setBackground(new java.awt.Color(251, 238, 215));
        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Trash.png"))); // NOI18N

        cmdUpdate.setBackground(new java.awt.Color(251, 238, 215));
        cmdUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/NotePencil.png"))); // NOI18N
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        
    }//GEN-LAST:event_cmdUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ButtonOutLine cmdDelete;
    private com.view.swing.ButtonOutLine cmdUpdate;
    // End of variables declaration//GEN-END:variables
}
