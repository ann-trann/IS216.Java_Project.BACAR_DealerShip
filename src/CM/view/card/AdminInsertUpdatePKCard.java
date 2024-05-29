package CM.view.card;

import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import CM.model.ModelPhuKien;
import CM.view.admin_component.DialogPanel;
import CM.view.form.AdminPKForm;
import CM.view.form.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminInsertUpdatePKCard extends javax.swing.JPanel {

    private MainForm main;
    private ModelPhuKien model;
    private DialogPanel dialog;
    private Service service;
    private ModelNhanVien user;
    
    public AdminInsertUpdatePKCard(ModelPhuKien model, MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException {
        initComponents();
        service = new Service();
        this.main = main;
        this.dialog = dialog;
        this.model = model;
        this.user = user;
        if (model != null){
            lbInsUpd.setText("Sửa phụ kiện");
            cmdAddUpd.setText("Sửa");
            txtTenPK.setText(model.getTenPK());
            txtGiaBan.setText(model.getGiaBan());
            txtGiaNhap.setText(model.getGiaNhap());
            txtXuatXu.setText(model.getXuatXu());
            txtSoLuong.setText(model.getSoLuong() + "");
        }
        init();
    }
    
    private void init(){
        lbReport.setText("");
        cmdCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cmdCancelActionPerformed(e);
            }
        });
        cmdAddUpd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cmdAddActionPerformed(e);
            }
            
        });
    }
    
    private boolean check(){
        if (txtTenPK.getText().trim().isEmpty()) return false;
        if (txtXuatXu.getText().trim().isEmpty()) return false;
        
        if (!txtSoLuong.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (!txtGiaBan.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (!txtGiaNhap.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (Long.parseLong(txtGiaBan.getText()) <= 0) return false;
        if (Long.parseLong(txtGiaNhap.getText()) <= 0) return false;
        if (Long.valueOf(txtGiaBan.getText()) * Long.valueOf(txtGiaNhap.getText()) < 0) return false;
        if (Integer.valueOf(txtSoLuong.getText()) < 0) return false;
        
        return true;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        lbInsUpd = new java.awt.Label();
        txtTenPK = new com.view.swing.TextField();
        txtGiaBan = new com.view.swing.TextField();
        txtSoLuong = new com.view.swing.TextField();
        lbTenPK = new javax.swing.JLabel();
        lbGiaNhap = new javax.swing.JLabel();
        lbGiaBan = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        txtGiaNhap = new com.view.swing.TextField();
        txtXuatXu = new com.view.swing.TextField();
        lbXuatXu = new javax.swing.JLabel();
        cmdCancel = new com.view.swing.Button();
        cmdAddUpd = new com.view.swing.Button();
        lbReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 238, 215));

        jPanel1.setBackground(new java.awt.Color(251, 238, 215));

        lbInsUpd.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbInsUpd.setForeground(new java.awt.Color(94, 68, 33));
        lbInsUpd.setText("Thêm phụ kiện");

        lbTenPK.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbTenPK.setForeground(new java.awt.Color(153, 112, 58));
        lbTenPK.setText("Tên phụ kiện");

        lbGiaNhap.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbGiaNhap.setForeground(new java.awt.Color(153, 112, 58));
        lbGiaNhap.setText("Giá nhập");

        lbGiaBan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbGiaBan.setForeground(new java.awt.Color(153, 112, 58));
        lbGiaBan.setText("Giá bán");

        lbSoLuong.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbSoLuong.setForeground(new java.awt.Color(153, 112, 58));
        lbSoLuong.setText("Số lượng");

        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });

        lbXuatXu.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbXuatXu.setForeground(new java.awt.Color(153, 112, 58));
        lbXuatXu.setText("Xuất xứ");

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cmdAddUpd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAddUpd.setText("Thêm");
        cmdAddUpd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbInsUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenPK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenPK, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 58, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbXuatXu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtXuatXu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdAddUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbInsUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenPK, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txtTenPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lbXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdAddUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbReport)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        dialog.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancel2ActionPerformed

        String ten = txtTenPK.getText();
        String xuatXu = txtXuatXu.getText();
        int soLuong = Integer.valueOf(txtSoLuong.getText());
        String giaBan = txtGiaBan.getText();
        String giaNhap = txtGiaNhap.getText();
        if (!check()){
            lbReport.setText("Lỗi dữ liệu");
        } else{
            if (model == null){
                try {
                    boolean check = true;
                    for (ModelPhuKien data: service.getListPhuKien()){
                        if (data.getTenPK().toLowerCase().equals(txtTenPK.getText().toLowerCase()) && data.getXuatXu().toLowerCase().equals(txtXuatXu.getText().toLowerCase())){
                            lbReport.setText("Phụ kiện đã có sẵn");
                            check = false;
                            break;
                        }
                    }
                    if (check){
                        try {
                            int maPK = service.getMaPK_Next();
                            ModelPhuKien data = new ModelPhuKien(maPK, ten, xuatXu, soLuong, giaNhap, giaBan);
                            service.insertPhuKien(data);
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminInsertUpdatePKCard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdminInsertUpdatePKCard.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                int maPK = model.getMaPK();
                ModelPhuKien data = new ModelPhuKien(maPK, ten, xuatXu, soLuong, giaNhap, giaBan);
                try {
                    service.updatePhuKien(data);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminInsertUpdatePKCard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dialog.setVisible(false);
            try {
                main.showForm(new AdminPKForm(main, dialog, user));
            } catch (SQLException ex) {
                Logger.getLogger(AdminInsertUpdatePKCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_cmdCancel2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdAddUpd;
    private com.view.swing.Button cmdCancel;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbGiaBan;
    private javax.swing.JLabel lbGiaNhap;
    private java.awt.Label lbInsUpd;
    private javax.swing.JLabel lbReport;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenPK;
    private javax.swing.JLabel lbXuatXu;
    private com.view.swing.TextField txtGiaBan;
    private com.view.swing.TextField txtGiaNhap;
    private com.view.swing.TextField txtSoLuong;
    private com.view.swing.TextField txtTenPK;
    private com.view.swing.TextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
