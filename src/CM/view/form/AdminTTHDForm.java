package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelHopDongMuaXe;
import CM.model.ModelKhachHang;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminTTHDForm extends javax.swing.JPanel {

    private Service service;
    private ArrayList<ModelHopDongMuaXe> list;
    
    public AdminTTHDForm() throws SQLException {
        service = new Service();
        list = service.getListHDMX();
        initComponents();
        init();
    }
    
    private void init() throws SQLException{
        txtSearch.setHint("Tên khách hàng ...");
        table.fixTable(scroll);
        DecimalFormat df = new DecimalFormat("#,###");
        for (ModelHopDongMuaXe data: list){
            int maHD = data.getMaHDMX();
            int maKH = data.getMaKH();
            int maNV = data.getMaNV();
            String tenXe = data.getTenXE();
            String ngay = data.getNgay();
            String gia = df.format(Long.parseLong(data.getTriGia()));
            String tenKH = "";
            
            for (ModelKhachHang kh: service.getListKH()){
                if (maKH == kh.getMaKH()){
                    tenKH = kh.getTenKH();
                    break;
                }
            }
            
            table.addRow(new Object[]{maHD, tenKH, tenXe, gia, ngay, maNV});
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTTHD = new javax.swing.JLabel();
        txtSearch = new com.view.swing.TextField();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();

        setBackground(new java.awt.Color(251, 238, 215));

        lbTTHD.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbTTHD.setForeground(new java.awt.Color(94, 68, 33));
        lbTTHD.setText("Thông tin hợp đồng");
        lbTTHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTTHDMouseClicked(evt);
            }
        });

        txtSearch.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Finding.png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(183, 150, 107));

        roundPanel2.setBackground(new java.awt.Color(251, 238, 215));

        scroll.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hợp đồng", "Tên khách hàng", "Tên xe", "Trị giá", "Ngày", "Mã nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
                .addComponent(scroll)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
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
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(284, 284, 284)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTTHD)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbTTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTTHDMouseClicked
        try {
            table.removeAllRow();
            init();
            txtSearch.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(AdminTTHDForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbTTHDMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        try {
            String name = txtSearch.getText().toLowerCase();
            ArrayList<Integer> listMaKH = new ArrayList<Integer>();
            ArrayList<String> listTenKH = new ArrayList<String>();
            DecimalFormat df = new DecimalFormat("#,###");
            table.removeAllRow();
            for (ModelKhachHang data : service.getListKH()){
                if (data.getTenKH().toLowerCase().contains(name)){
                    listMaKH.add(data.getMaKH());
                    listTenKH.add(data.getTenKH());
                    
                }
            }
            
            for (ModelHopDongMuaXe data : list){
                for (int i = 0; i < listTenKH.size(); i++){
                    String gia = df.format(Long.parseLong(data.getTriGia()));
                    
                    if (data.getMaKH() == listMaKH.get(i)){
                        table.addRow(new Object[]{data.getMaHDMX(), listTenKH.get(i), data.getTenXE(), data.getNgay(), gia, data.getMaNV()});
                    }
                }
            }
//            txtSearch.setText("");
//            txtSearch.setHint("Tên khách hàng ...");
        } catch (SQLException ex) {
            Logger.getLogger(AdminTTHDForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTTHD;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
