package CM.view.card;

import CM.controller.service.Service;
import CM.model.ModelKhachHang;
import CM.model.ModelLichSuaChua;
import CM.model.ModelNhanVien;
import CM.view.admin_component.DialogPanel;
import CM.view.form.AdminLSCForm;
import CM.view.form.MainForm;
import com.raven.datechooser.SelectedDate;
import com.view.swing.Combobox;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminInsertUpdateLSCCard extends javax.swing.JPanel {

    
    private MainForm main;
    private DialogPanel dialog;
    private ModelLichSuaChua model;
    private ModelNhanVien user;
    private Service service;
    private SelectedDate currentDate;
    
    public AdminInsertUpdateLSCCard(ModelLichSuaChua model, MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException, SQLException {
        this.model = model;
        this.user = user;
        this.dialog = dialog;
        this.main = main;
        service = new Service();
        LocalDate cDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDate = cDate.format(formatter);
        LocalDate now = LocalDate.parse(formattedDate, formatter);
        currentDate = new SelectedDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
        initComponents();
        this.main = main;
        init();
    }
    
    private void init() throws SQLException{   
        lbReport.setText("");
        if (model != null){
            Service service = new Service();
            String tenKH = service.getKH(model.getMaKH());
            String SDT = service.getKH_SDT(model.getMaKH());
            txtMaXe.setText(model.getMaXe() + "");
            txtTenKH.setText(tenKH);
            txtNgay.setText(model.getNgay());
            txtSDT.setText(SDT);
            lbInsUpd.setText("Sửa lịch");
            cmdAddUpd.setText("Sửa");
        }
    }
    
    private boolean checkDate(SelectedDate d1, SelectedDate d2){
        if (d1.getYear() < d2.getYear()) return false;
        else if (d1.getYear() == d2.getYear()){
            if (d1.getMonth() < d2.getMonth()) return false;
            else if (d1.getMonth() == d2.getMonth()){
                if (d1.getDay() < d2.getDay()) return false;
            }
        }
        return true;
    }
    
    private boolean check() throws SQLException{
        SelectedDate chooseDate = Date.getSelectedDate();
        if (txtMaXe.getText().isEmpty()) return false;
        if (!checkDate(chooseDate, currentDate)) return false;
        if (txtTenKH.getText().isEmpty()) return false;
        if (!txtSDT.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (txtSDT.getText().length() != 10) return false;
        if (!service.compair2date(service.getCurrentDate(), txtNgay.getText())) return false;
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Date = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        lbInsUpd = new javax.swing.JLabel();
        lbTenKH = new java.awt.Label();
        lbSDT = new java.awt.Label();
        lbMaXe = new java.awt.Label();
        lbCa = new java.awt.Label();
        lbNgay = new java.awt.Label();
        txtMaXe = new com.view.swing.TextField();
        txtTenKH = new com.view.swing.TextField();
        txtSDT = new com.view.swing.TextField();
        txtNgay = new com.view.swing.TextField();
        cmdCancel = new com.view.swing.Button();
        cmdAddUpd = new com.view.swing.Button();
        cbCa = new Combobox();
        lbReport = new javax.swing.JLabel();

        Date.setBackground(new java.awt.Color(183, 150, 107));
        Date.setForeground(new java.awt.Color(183, 150, 107));
        Date.setTextRefernce(txtNgay);

        setBackground(new java.awt.Color(251, 238, 215));

        jPanel1.setBackground(new java.awt.Color(251, 238, 215));

        lbInsUpd.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbInsUpd.setForeground(new java.awt.Color(94, 68, 33));
        lbInsUpd.setText("Thêm lịch");

        lbTenKH.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbTenKH.setForeground(new java.awt.Color(153, 112, 58));
        lbTenKH.setText("Tên khách hàng");

        lbSDT.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(153, 112, 58));
        lbSDT.setText("SĐT");

        lbMaXe.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbMaXe.setForeground(new java.awt.Color(153, 112, 58));
        lbMaXe.setText("Mã xe");

        lbCa.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbCa.setForeground(new java.awt.Color(153, 112, 58));
        lbCa.setText("Ca");

        lbNgay.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbNgay.setForeground(new java.awt.Color(153, 112, 58));
        lbNgay.setText("Ngày sửa chữa");

        txtNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNgayMousePressed(evt);
            }
        });

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdAddUpd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAddUpd.setText("Thêm");
        cmdAddUpd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdAddUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddUpdActionPerformed(evt);
            }
        });

        cbCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        cbCa.setSelectedItem((model == null) ? "1" : model.getCa()+"");
        cbCa.setBorder(null);

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbInsUpd)
                                    .addComponent(lbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMaXe, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addGap(150, 150, 150)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(cmdAddUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbInsUpd)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAddUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddUpdActionPerformed
        
        try {
            if (!check()){
                lbReport.setText("Lỗi dữ liệu");
            } else try {
                if (service.checkLSC((String)cbCa.getSelectedItem(), txtNgay.getText())){
                    lbReport.setText("Lịch hôm đó đã đầy");
                } else{
                    try {
                        
                        int maKH = 0;
                        String tenKH = txtTenKH.getText();
                        String SDT = txtSDT.getText();
                        String ngaySC = txtNgay.getText();
                        String ca = (String) cbCa.getSelectedItem();
                        int maXe = Integer.parseInt(txtMaXe.getText());
                        int maLSC = 0;
                        for (ModelKhachHang data : service.getListKH()){
                            if (data.getSoDT().equals(SDT)){
                                if (!data.getTenKH().equals(tenKH)){
                                    lbReport.setText("Số điện thoại đã được sử dụng");
                                    return;
                                }
                                maKH = data.getMaKH();
                            }
                        }
                        if (model == null){
                            if (maKH == 0){
                                
                                maKH = service.getMaKH_next();
                                maLSC = service.getMaLSC_next();
                                ModelKhachHang data = new ModelKhachHang(maKH, tenKH, SDT, "Thuong");
                                service.insertKH(data);
                            }
                            ModelLichSuaChua data1 = new ModelLichSuaChua(maLSC, maKH, maXe, ngaySC, Integer.valueOf(ca), user.getMaNV(), "Chua hoan thanh");
                            service.insertLSC(data1);
                            
                        } else{
                            ModelLichSuaChua data1 = new ModelLichSuaChua(model.getMaLSC(), maKH, maXe, ngaySC, Integer.valueOf(ca), user.getMaNV(), "Chua hoan thanh");
                            service.updateLSC(data1);
                        }
                        dialog.setVisible(false);
                        main.showForm(new AdminLSCForm(main, dialog, user));
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminInsertUpdateLSCCard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SQLException ex) {                
                Logger.getLogger(AdminInsertUpdateLSCCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminInsertUpdateLSCCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdAddUpdActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        dialog.setVisible(false);
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtNgayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayMousePressed
        Date.showPopup();
    }//GEN-LAST:event_txtNgayMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser Date;
    private javax.swing.JComboBox<String> cbCa;
    private com.view.swing.Button cmdAddUpd;
    private com.view.swing.Button cmdCancel;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label lbCa;
    private javax.swing.JLabel lbInsUpd;
    private java.awt.Label lbMaXe;
    private java.awt.Label lbNgay;
    private javax.swing.JLabel lbReport;
    private java.awt.Label lbSDT;
    private java.awt.Label lbTenKH;
    private com.view.swing.TextField txtMaXe;
    private com.view.swing.TextField txtNgay;
    private com.view.swing.TextField txtSDT;
    private com.view.swing.TextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
