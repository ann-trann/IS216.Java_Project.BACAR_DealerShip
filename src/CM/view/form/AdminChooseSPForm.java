
package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import CM.model.ModelXe;
import CM.view.admin_component.DialogPanel;
import CM.view.annouce.DoubleCheckPanel;
import com.view.swing.ScrollBarCustom;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminChooseSPForm extends javax.swing.JPanel {

    private Service service;
    private ArrayList<ModelXe> listXe;
    private MainForm main;
    private DialogPanel dialog;
    private ModelNhanVien user;
    
    public AdminChooseSPForm(MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException {
        initComponents();
        this.dialog = dialog;
        service = new Service();
        listXe = service.getListXeTrongKho();
        this.main = main;
        this.user = user;
        init();
    }
    
    private void init(){
        lbReport.setText("");
        txtSearch.setHint("Tìm kiếm . . .");
        table.fixTable(scroll);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scrollPanel.setVerticalScrollBar(new ScrollBarCustom());
        DecimalFormat df = new DecimalFormat("#,###");
        for (ModelXe data : listXe){
            table.addRow(new Object[]{data.getMaXe(), data.getTenXe(), data.getLoaiXe(), df.format(Long.parseLong(data.getGiaBan()))});
        }
    }
    
    private boolean check(){
        if (txtTenKH.getText().isBlank()) return false;
        if (!txtSDT.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (txtTenKH.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (txtSDT.getText().length() != 10) return false;
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lbChonXe = new javax.swing.JLabel();
        txtSearch = new com.view.swing.TextField();
        cmdCancel = new com.view.swing.Button();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();
        lbTenKH = new javax.swing.JLabel();
        txtTenKH = new com.view.swing.TextField();
        lbSDT = new javax.swing.JLabel();
        txtSDT = new com.view.swing.TextField();
        cmdCreate = new com.view.swing.Button();
        lbReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 238, 215));

        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(251, 238, 215));

        lbChonXe.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbChonXe.setForeground(new java.awt.Color(123, 100, 67));
        lbChonXe.setText("Chọn xe");
        lbChonXe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbChonXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChonXeMouseClicked(evt);
            }
        });

        txtSearch.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Finding.png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
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

        roundPanel1.setBackground(new java.awt.Color(183, 150, 107));

        roundPanel2.setBackground(new java.awt.Color(251, 238, 215));

        scroll.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dòng xe", "Tên dòng xe", "Loại xe", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        lbTenKH.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTenKH.setForeground(new java.awt.Color(123, 100, 67));
        lbTenKH.setText("Tên khách hàng:");
        lbTenKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTenKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTenKHMouseClicked(evt);
            }
        });

        lbSDT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(123, 100, 67));
        lbSDT.setText("Số điện thoại     :");
        lbSDT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSDTMouseClicked(evt);
            }
        });

        cmdCreate.setForeground(new java.awt.Color(255, 255, 255));
        cmdCreate.setText("Tạo hợp đồng");
        cmdCreate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCreateActionPerformed(evt);
            }
        });

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(lbChonXe, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(275, 275, 275)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addGap(83, 83, 83))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(lbSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(20, 20, 20))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbChonXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSDT))
                .addGap(14, 14, 14)
                .addComponent(lbReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        scrollPanel.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbChonXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChonXeMouseClicked
        table.removeAllRow();
        txtSearch.setText("");
        init();
    }//GEN-LAST:event_lbChonXeMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String name = txtSearch.getText().toLowerCase();
        table.removeAllRow();
        DecimalFormat df = new DecimalFormat("#,###");
        for (ModelXe data : listXe){
            if (data.getTenXe().toLowerCase().contains(name.toLowerCase().trim())){
                table.addRow(new Object[]{data.getMaXe(), data.getTenXe(), data.getLoaiXe(), df.format(Long.parseLong(data.getGiaBan()))});
            }
        }
        txtSearch.setText("");
        txtSearch.setHint("Tìm kiếm");
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        try {
            main.showForm(new AdminSPForm(main, dialog, user));
        } catch (SQLException ex) {
            Logger.getLogger(AdminChooseSPForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void lbTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTenKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTenKHMouseClicked

    private void lbSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSDTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSDTMouseClicked

    private void cmdCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCreateActionPerformed
        if (!check()){
            lbReport.setText("Lỗi dữ liệu");
        } else{
            try {
                int maXe = table.getFirstCol_RowSelected(table.getSelectedRow());
                ModelXe xe = null;
                for (ModelXe data : listXe){
                    if (data.getMaXe() == maXe){
                        xe = data;
                        break;
                    }
                }
                dialog.showForm(new DoubleCheckPanel(main, dialog, user, xe, txtTenKH.getText(), txtSDT.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(AdminChooseSPForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdCancel;
    private com.view.swing.Button cmdCreate;
    private javax.swing.JLabel lbChonXe;
    private javax.swing.JLabel lbReport;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JPanel panel;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollPanel;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtSDT;
    private com.view.swing.TextField txtSearch;
    private com.view.swing.TextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
