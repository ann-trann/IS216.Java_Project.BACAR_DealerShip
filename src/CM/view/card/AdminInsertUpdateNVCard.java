package CM.view.card;

import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import CM.view.admin_component.DialogPanel;
import CM.view.form.AdminNVForm;
import CM.view.form.MainForm;
import com.view.swing.Combobox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminInsertUpdateNVCard extends javax.swing.JPanel {
    
    private DialogPanel dialog;
    private ModelNhanVien model;
    private ModelNhanVien user;
    private MainForm main;
    private Service service;
    
    public AdminInsertUpdateNVCard(ModelNhanVien model, MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException {
        service = new Service();
        this.main = main;
        this.dialog = dialog;
        this.user = user;
        this.model = model;
        initComponents();
        init();
    }
    
    private void init(){
        lbReport.setText("");
        
        cmdCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });
        if (model != null){
            txtTenNV.setText(model.getTenNV());
            txtEmail.setText(model.getEmail());
            txtLuong.setText(model.getLuong());
            txtMatKhau.setText(model.getMatKhau());
            txtSDT.setText(model.getSDT());
            txtTaiKhoan.setText(model.getTaiKhoan());
            lbInsUpd.setText("Sửa nhân viên");
            cmdAddUpd.setText("Sửa");
        }
    }
    
    private boolean check() throws SQLException{
        if (txtTenNV.getText().trim().isEmpty()) return false;
//        if (cmdAddUpd.getText().equals("Sửa")) return true;
        if (!txtSDT.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (txtSDT.getText().length() != 10) return false;
        if (!txtLuong.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (Long.parseLong(txtLuong.getText()) <= 0) return false;
        if (!txtEmail.getText().contains("@gmail.com")) return false;
        
        if (cbTrangThai.getSelectedItem().equals("Dang lam viec")){
            if (txtTaiKhoan.getText().equals("") || txtMatKhau.getText().equals(""))
                return false;
        }
        
        for (ModelNhanVien model : service.getListNV()){
            if (model.getTaiKhoan() == null) continue;
            if (model.getTaiKhoan().equals(txtTaiKhoan.getText())){
                return false;
            }
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbInsUpd = new java.awt.Label();
        txtTenNV = new com.view.swing.TextField();
        txtSDT = new com.view.swing.TextField();
        txtEmail = new com.view.swing.TextField();
        txtLuong = new com.view.swing.TextField();
        lbTenNV = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbLuong = new javax.swing.JLabel();
        lbTaiKhoan = new javax.swing.JLabel();
        txtTaiKhoan = new com.view.swing.TextField();
        lbMatKhau = new javax.swing.JLabel();
        txtMatKhau = new com.view.swing.TextField();
        cmdCancel = new com.view.swing.Button();
        cmdAddUpd = new com.view.swing.Button();
        lbTrangThai = new javax.swing.JLabel();
        cbTrangThai = new Combobox();
        cbChucVu = new Combobox();
        lbReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 238, 215));

        jPanel2.setBackground(new java.awt.Color(251, 238, 215));

        lbInsUpd.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbInsUpd.setForeground(new java.awt.Color(94, 68, 33));
        lbInsUpd.setText("Thêm nhân viên");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });

        lbTenNV.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbTenNV.setForeground(new java.awt.Color(153, 112, 58));
        lbTenNV.setText("Tên nhân viên");

        lbChucVu.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbChucVu.setForeground(new java.awt.Color(153, 112, 58));
        lbChucVu.setText("Chức vụ");

        lbSDT.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(153, 112, 58));
        lbSDT.setText("Số điện thoại");

        lbEmail.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(153, 112, 58));
        lbEmail.setText("Email");

        lbLuong.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbLuong.setForeground(new java.awt.Color(153, 112, 58));
        lbLuong.setText("Lương");

        lbTaiKhoan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbTaiKhoan.setForeground(new java.awt.Color(153, 112, 58));
        lbTaiKhoan.setText("Tài khoản");

        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });

        lbMatKhau.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbMatKhau.setForeground(new java.awt.Color(153, 112, 58));
        lbMatKhau.setText("Mật khẩu");

        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cmdAddUpd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAddUpd.setText("Thêm");
        cmdAddUpd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdAddUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddUpdActionPerformed(evt);
            }
        });

        lbTrangThai.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(153, 112, 58));
        lbTrangThai.setText("Trạng thái");

        cbTrangThai.setForeground(new java.awt.Color(153, 112, 58));
        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dang lam viec", "Da nghi" }));
        cbTrangThai.setSelectedItem((model != null) ? model.getTrangThai() : "Dang lam viec");
        cbTrangThai.setBorder(null);
        cbTrangThai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbTrangThai.setOpaque(true);

        cbChucVu.setForeground(new java.awt.Color(153, 112, 58));
        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ban hang", "Kho", "Sua chua", "Quan ly" }));
        cbChucVu.setSelectedItem((model == null) ? "Ban hang" : model.getChucVu());
        cbChucVu.setBorder(null);
        cbChucVu.setOpaque(true);

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbInsUpd, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(lbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdAddUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbInsUpd, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cbChucVu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSDT)
                    .addComponent(lbTaiKhoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLuong)
                    .addComponent(lbMatKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbReport)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAddUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed

    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdAddUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddUpdActionPerformed
        try {
            if (!check()){
                lbReport.setText("Lỗi dữ liệu");
            } else{
                String tenNV = txtTenNV.getText();
                String SDT = txtSDT.getText();
                String email = txtEmail.getText();
                String Luong = txtLuong.getText();
                String taiKhoan = txtTaiKhoan.getText();
                String matKhau = txtMatKhau.getText();
                String chucVu = (String) cbChucVu.getSelectedItem();
                String trangThai = (String) cbTrangThai.getSelectedItem();
                if (model == null){
                    int maNV = service.getMaNV_next();
                    service.insertNV(new ModelNhanVien(maNV, tenNV, SDT, Luong, chucVu, email, taiKhoan, matKhau, user.getMaNV()));
                } else service.updateNV(new ModelNhanVien(model.getMaNV(), tenNV, SDT, Luong, chucVu, trangThai, email, taiKhoan, matKhau, user.getMaNV()));
                main.showForm(new AdminNVForm(main, dialog, user));
                dialog.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminInsertUpdateNVCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdAddUpdActionPerformed

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaiKhoanActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JComboBox<String> cbTrangThai;
    private com.view.swing.Button cmdAddUpd;
    private com.view.swing.Button cmdCancel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbEmail;
    private java.awt.Label lbInsUpd;
    private javax.swing.JLabel lbLuong;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbReport;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTaiKhoan;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JLabel lbTrangThai;
    private com.view.swing.TextField txtEmail;
    private com.view.swing.TextField txtLuong;
    private com.view.swing.TextField txtMatKhau;
    private com.view.swing.TextField txtSDT;
    private com.view.swing.TextField txtTaiKhoan;
    private com.view.swing.TextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
