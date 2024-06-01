
package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelLichSuaChua;
import CM.model.ModelNhanVien;
import CM.view.admin_component.DialogPanel;
import CM.view.annouce.AnnoucePanelLSC;
import CM.view.annouce.ErrorPanelLSC;
import CM.view.card.AdminInsertUpdateLSCCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLSCForm extends javax.swing.JPanel {

    private MainForm main;
    private Service service;
    private ArrayList<ModelLichSuaChua> list;
    private DialogPanel dialog;
    private ModelNhanVien user;
    
    public AdminLSCForm(MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException {
        initComponents();
        this.user = user;
        this.dialog = dialog;
        this.main = main;
        table.fixTable(scroll);
        initTable();
        init();
    }
    
    private void initTable() throws SQLException{
        service = new Service();
        list = service.getListLSC();
        for (ModelLichSuaChua data : list){
            String tenKH = service.getKH(data.getMaKH());
            String sdt = service.getKH_SDT(data.getMaKH());
            table.addRow(new Object[]{data.getMaLSC(), data.getMaXe(), tenKH, sdt, data.getNgay(), data.getCa(), data.getTrangThai(), data.getMaNV()});
        }
    }
    
    private void init(){
        cmdAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cmdAddActionPerformed(e);
            }
            
        });
        txtSearch.setHint("Tên khách hàng");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLSC = new javax.swing.JLabel();
        txtSearch = new com.view.swing.TextField();
        cmdTaoHD = new com.view.swing.Button();
        cmdAdd = new com.view.swing.Button();
        cmdUpd = new com.view.swing.Button();
        cmDel = new com.view.swing.Button();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();

        setBackground(new java.awt.Color(251, 238, 215));

        lbLSC.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbLSC.setForeground(new java.awt.Color(94, 68, 33));
        lbLSC.setText("Lịch sửa chữa");
        lbLSC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLSC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLSCMouseClicked(evt);
            }
        });

        txtSearch.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Finding.png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        cmdTaoHD.setForeground(new java.awt.Color(255, 255, 255));
        cmdTaoHD.setText("Tạo hóa đơn");
        cmdTaoHD.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        cmdTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTaoHDActionPerformed(evt);
            }
        });

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/+.png"))); // NOI18N
        cmdAdd.setToolTipText("");

        cmdUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/NotePencil.png"))); // NOI18N
        cmdUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdActionPerformed(evt);
            }
        });

        cmDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Trash.png"))); // NOI18N
        cmDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmDelActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel2.setBackground(new java.awt.Color(251, 238, 215));

        scroll.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch", "Mã xe", "Tên khách hàng", "SDT", "Ngày", "Ca", "Trạng thái", "MaNV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        scroll.setViewportView(table);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmdTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLSC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(cmDel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLSC)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        try {
            dialog.showForm(new AdminInsertUpdateLSCCard(null, main, dialog, user));
        } catch (SQLException ex) {
            Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void cmdUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdActionPerformed
        int maLSC = table.getFirstCol_RowSelected(table.getSelectedRow());
        ModelLichSuaChua data = null;
        for (ModelLichSuaChua model : list){
            if (model.getMaLSC() == maLSC){
                data = model;
            }
        }
        if (data != null){
            if (data.getTrangThai().equals("Chua hoan thanh")){
                try {
                    dialog.showForm(new AdminInsertUpdateLSCCard(data, main, dialog, user));
                } catch (SQLException ex) {
                    Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                dialog.showForm(new ErrorPanelLSC(dialog));
            }
        }
    }//GEN-LAST:event_cmdUpdActionPerformed

    private void cmdTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTaoHDActionPerformed

        try {
            int maLSC = table.getFirstCol_RowSelected(table.getSelectedRow());
            ModelLichSuaChua data = null;
            for (ModelLichSuaChua model : list){
                if (model.getMaLSC() == maLSC){
                    data = model;
                }
            }
            if (service.compair2date(service.getCurrentDate(), data.getNgay())){
                dialog.showForm(new AnnoucePanelLSC(dialog));
            }
            else{
                if (data.getTrangThai().equals("Chua hoan thanh")){
                    try {
                        main.showForm(new AdminChoosePKForm(main, dialog, user, data, null));
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    dialog.showForm(new ErrorPanelLSC(dialog));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdTaoHDActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String name = txtSearch.getText().toLowerCase();
        table.removeAllRow();
        for (ModelLichSuaChua data : list){
            String tenKH = null;
            try {
                tenKH = service.getKH(data.getMaKH());
            } catch (SQLException ex) {
                Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sdt = null;
            try {
                sdt = service.getKH_SDT(data.getMaKH());
            } catch (SQLException ex) {
                Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tenKH.toLowerCase().contains(name))
                table.addRow(new Object[]{data.getMaLSC(), data.getMaXe(), tenKH, sdt, data.getNgay(), data.getCa(), data.getTrangThai(), data.getMaNV()});
        }
//        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lbLSCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLSCMouseClicked
        table.removeAllRow();
        try {
            initTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();
        
    }//GEN-LAST:event_lbLSCMouseClicked

    private void cmDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmDelActionPerformed
        try {
            int maLSC = table.getFirstCol_RowSelected(table.getSelectedRow());
            ModelLichSuaChua data = null;
            for (ModelLichSuaChua model : list){
                if (model.getMaLSC() == maLSC){
                    data = model;
                }
            }
            if (data != null){
                if (data.getTrangThai().equals("Chua hoan thanh")){
                    service.deleteLSC(data);
                    table.removeAllRow();
                    initTable();
                } else{
                    dialog.showForm(new ErrorPanelLSC(dialog));
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(AdminLSCForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmDelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmDel;
    private com.view.swing.Button cmdAdd;
    private com.view.swing.Button cmdTaoHD;
    private com.view.swing.Button cmdUpd;
    private javax.swing.JLabel lbLSC;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
