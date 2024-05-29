package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelCTHDSC;
import CM.model.ModelLichSuaChua;
import CM.model.ModelNhanVien;
import CM.model.ModelPhuKien;
import CM.view.admin_component.DialogPanel;
import CM.view.admin_component.PhuKien;
import CM.view.annouce.AnnoucePanelPK;
import com.view.swing.ScrollBarCustom;
import com.view.swing.WrapLayout;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminChoosePKForm extends javax.swing.JPanel {

    private MainForm main;
    private Service service;
    private ArrayList<ModelPhuKien> list;
    private DialogPanel dialog;
    private ArrayList<ModelCTHDSC> listCTHD;
    private ModelNhanVien user;
    private ModelLichSuaChua model;
    
    public AdminChoosePKForm(MainForm main, DialogPanel dialog, ModelNhanVien user, ModelLichSuaChua model, ArrayList<ModelCTHDSC> listCTHD) throws SQLException {
        this.user = user;
        this.main = main;
        this.dialog = dialog;
        this.model = model;
        service = new Service();
        list = service.getListPhuKien();
        this.listCTHD = listCTHD;
        initComponents();
        init();
    }
    
    private void init(){
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new WrapLayout(WrapLayout.LEFT, 50, 15));
        
        if (listCTHD == null)
            for (ModelPhuKien model : list){
                panel.add(new PhuKien(model));
            }
        else {
            for (ModelPhuKien model : list) {
                PhuKien pk = new PhuKien(model);
                for (ModelCTHDSC data: listCTHD){
                    if (data.getMaPK() == pk.getMaPK()){
                        pk.setSoLuong(data.getSoLuong());
                        break;
                    }
                }
                panel.add(pk);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbChonPK = new javax.swing.JLabel();
        cmdCancel = new com.view.swing.Button();
        cmdNext = new com.view.swing.Button();
        scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(251, 238, 215));

        lbChonPK.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbChonPK.setForeground(new java.awt.Color(94, 68, 33));
        lbChonPK.setText("Chọn phụ kiện");

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdNext.setForeground(new java.awt.Color(255, 255, 255));
        cmdNext.setText("Tiếp tục");
        cmdNext.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextActionPerformed(evt);
            }
        });

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        scroll.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdNext, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbChonPK, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbChonPK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        try {
            main.showForm(new AdminLSCForm(main, dialog, user));
        } catch (SQLException ex) {
            Logger.getLogger(AdminChoosePKForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
        if (listCTHD == null) listCTHD = new ArrayList<ModelCTHDSC>();
        listCTHD.clear();
        int t = 0;
        for (Component com : panel.getComponents()){
            if (com instanceof PhuKien){
                try {
                    PhuKien phukien = (PhuKien) com;
                    int maPK = phukien.getMaPK();
                    int maHD = service.getMaHDSC_next();
                    int soLuong = phukien.getSoLuong();
                    if (soLuong == 0) continue;
                    listCTHD.add(new ModelCTHDSC(maHD, maPK, soLuong));
                    t++;
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AdminChoosePKForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (t == 0){
            dialog.showForm(new AnnoucePanelPK(dialog));
        } else{
            try {
                main.showForm(new AdminCofirmBillForm(main, dialog, user, model, listCTHD));
            } catch (SQLException ex) {
                Logger.getLogger(AdminChoosePKForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdCancel;
    private com.view.swing.Button cmdNext;
    private javax.swing.JLabel lbChonPK;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
