package CM.view.card;

import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import CM.model.ModelXe;
import CM.view.admin_component.DialogPanel;
import CM.view.form.AdminSPForm;
import CM.view.form.MainForm;
import com.view.swing.Combobox;
import com.view.swing.ScrollBarCustom;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminUpdateSPCard extends javax.swing.JPanel {
    
    private ModelXe model;
    private MainForm main;
    private DialogPanel dialog;
    private Service service;
    private ModelNhanVien user;
    
    public AdminUpdateSPCard(ModelXe model, DialogPanel dialog, MainForm main, ModelNhanVien user) throws SQLException {
        service = new Service();
        this.user = user;
        this.dialog = dialog;
        this.main = main;
        this.model = model;
        initComponents();
        
        init();
    }
    
    private void init(){
        lbReport.setText("");
        txtTenXe.setText(model.getTenXe());
        txtGiaBan.setText(model.getGiaBan());
        txtGiaNhap.setText(model.getGiaNhap());
        txtTGBH.setText(model.getThoiGianBH() + "");
        
    }
    
    private boolean check(){
        if (txtTenXe.getText().trim().isEmpty()) return false;
        if (txtGiaBan.getText().trim().isEmpty()) return false;
        if (txtGiaNhap.getText().trim().isEmpty()) return false;
        if (txtTGBH.getText().trim().isEmpty()) return false;
        
        if (!txtGiaBan.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (!txtGiaNhap.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (Long.parseLong(txtGiaBan.getText()) <= 0) return false;
        if (Long.parseLong(txtGiaNhap.getText()) <= 0) return false;
        if (!txtTGBH.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (Integer.valueOf(txtTGBH.getText()) < 0) return false;
        
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        lbTenXe = new java.awt.Label();
        lbGiaBan = new java.awt.Label();
        txtTenXe = new com.view.swing.TextField();
        txtGiaBan = new com.view.swing.TextField();
        lbUpdate = new java.awt.Label();
        lbGiaNhap = new java.awt.Label();
        txtGiaNhap = new com.view.swing.TextField();
        lbTGBH = new java.awt.Label();
        txtTGBH = new com.view.swing.TextField();
        lbLoaiXe = new java.awt.Label();
        cbLoaiXe = new Combobox();
        cmdCancel = new com.view.swing.Button();
        cmdUpd = new com.view.swing.Button();
        lbReport = new javax.swing.JLabel();

        jFileChooser1.setName(""); // NOI18N

        setBackground(new java.awt.Color(251, 238, 215));
        setForeground(new java.awt.Color(251, 238, 215));

        jPanel1.setBackground(new java.awt.Color(251, 238, 215));

        lbTenXe.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTenXe.setForeground(new java.awt.Color(183, 150, 107));
        lbTenXe.setText("Tên xe");

        lbGiaBan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbGiaBan.setForeground(new java.awt.Color(183, 150, 107));
        lbGiaBan.setText("Giá bán");

        txtTenXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenXeActionPerformed(evt);
            }
        });

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        lbUpdate.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbUpdate.setForeground(new java.awt.Color(183, 150, 107));
        lbUpdate.setText("Sửa thông tin xe");

        lbGiaNhap.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbGiaNhap.setForeground(new java.awt.Color(183, 150, 107));
        lbGiaNhap.setText("Giá nhập");

        lbTGBH.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTGBH.setForeground(new java.awt.Color(183, 150, 107));
        lbTGBH.setText("Thời gian bảo hành");

        lbLoaiXe.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbLoaiXe.setForeground(new java.awt.Color(183, 150, 107));
        lbLoaiXe.setText("Loại xe");

        cbLoaiXe.setBackground(new java.awt.Color(251, 238, 215));
        cbLoaiXe.setForeground(new java.awt.Color(195, 173, 143));
        cbLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedan", "Convertible", "Roadster", "Sport activity vehicle", "Gran coupe", "Electric", "Sport activity coupe" }));
        cbLoaiXe.setSelectedItem((model == null) ? "Sedan" : model.getLoaiXe());
        cbLoaiXe.setBorder(null);
        cbLoaiXe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdUpd.setForeground(new java.awt.Color(255, 255, 255));
        cmdUpd.setText("Sửa");
        cmdUpd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdActionPerformed(evt);
            }
        });

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                            .addComponent(lbGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTGBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbLoaiXe, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTGBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbReport)
                        .addGap(123, 123, 123))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTGBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTGBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoaiXe))
                .addGap(20, 20, 20)
                .addComponent(lbGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(lbReport)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancleActionPerformed
        
    }//GEN-LAST:event_cmdCancleActionPerformed

    private void cmdUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdActionPerformed
        if (!check()){
            lbReport.setText("Lỗi dữ liệu");
        } else{
            try {
                ModelXe model1 = new ModelXe(txtTenXe.getText(), (String) cbLoaiXe.getSelectedItem(), txtGiaNhap.getText(), txtGiaBan.getText(), Integer.valueOf(txtTGBH.getText()), user.getMaNV());
                model1.setMaXe(model.getMaXe());
                service.updateDongXe(model1);
                main.showForm(new AdminSPForm(main, dialog, user));
                dialog.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminUpdateSPCard.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        
        
    }//GEN-LAST:event_cmdUpdActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        dialog.setVisible(false);
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void txtTenXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenXeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLoaiXe;
    private com.view.swing.Button cmdCancel;
    private com.view.swing.Button cmdUpd;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label lbGiaBan;
    private java.awt.Label lbGiaNhap;
    private java.awt.Label lbLoaiXe;
    private javax.swing.JLabel lbReport;
    private java.awt.Label lbTGBH;
    private java.awt.Label lbTenXe;
    private java.awt.Label lbUpdate;
    private com.view.swing.TextField txtGiaBan;
    private com.view.swing.TextField txtGiaNhap;
    private com.view.swing.TextField txtTGBH;
    private com.view.swing.TextField txtTenXe;
    // End of variables declaration//GEN-END:variables
}
