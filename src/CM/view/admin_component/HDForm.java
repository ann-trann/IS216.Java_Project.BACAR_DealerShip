
package CM.view.admin_component;

import CM.controller.service.Service;
import CM.model.ModelHoaDonSuaChua;
import CM.model.ModelKhachHang;
import CM.model.ModelLichSuaChua;
import CM.view.form.AdminCTHDForm;
import CM.view.form.MainForm;
import com.view.swing.ScrollBarCustom;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HDForm extends javax.swing.JPanel {

    private Service service;
    private ArrayList<ModelHoaDonSuaChua> list;
    private MainForm main;
    
    public HDForm(MainForm main) throws SQLException {
        initComponents();
        service = new Service();
        list = service.listHDSC();
        this.main = main;
        initHD();
    }
    
    public void initHD() throws SQLException{
        table.fixTable(scroll);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getViewport().setOpaque(false);
        txtSearch.setHint("Tìm kiếm . . .");
        table.removeAllRow();
        DecimalFormat df = new DecimalFormat("#,###");
        for (ModelHoaDonSuaChua data : list){
            String tenKH = "";
            int maKH = 0;
            for (ModelLichSuaChua data1 : service.getListLSC()){
                if (data1.getMaLSC() == data.getMaHD()){
                    maKH = data1.getMaKH();
                    break;
                }
            }
            for (ModelKhachHang data1 : service.getListKH()){
                if (data1.getMaKH() == maKH){
                    tenKH = data1.getTenKH();
                    break;
                }
            }
            table.addRow(new Object[]{data.getMaHD(), tenKH, data.getNgay(), df.format(Long.parseLong(data.getThanhTien())), data.getMaNV()});
        }
    }
    
    public void searchBill(String str1, String str2) throws SQLException{
        table.removeAllRow();
        if (service.checkHDSC_AToB(str1, str2)){
            DecimalFormat df = new DecimalFormat("#,###");
            ArrayList<ModelHoaDonSuaChua> list1 = new ArrayList<ModelHoaDonSuaChua>();
            list1 = service.listHDSC_AToB(str1, str2);
            for (ModelHoaDonSuaChua data : list1){
                String tenKH = "";
            int maKH = 0;
            for (ModelLichSuaChua data1 : service.getListLSC()){
                if (data1.getMaLSC() == data.getMaHD()){
                    maKH = data1.getMaKH();
                    break;
                }
            }
            for (ModelKhachHang data1 : service.getListKH()){
                if (data1.getMaKH() == maKH){
                    tenKH = data1.getTenKH();
                    break;
                }
            }
            table.addRow(new Object[]{data.getMaHD(), tenKH, data.getNgay(), df.format(Long.parseLong(data.getThanhTien())), data.getMaNV()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new com.view.swing.TextField();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();
        cmdCTHD = new com.view.swing.Button();

        setBackground(new java.awt.Color(251, 238, 215));

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
                "MaHD", "Tên khách hàng", "Ngày", "Trị giá", "MaNV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
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

        cmdCTHD.setForeground(new java.awt.Color(255, 255, 255));
        cmdCTHD.setText("Xem CTHD");
        cmdCTHD.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmdCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(385, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        table.removeAllRow();
        DecimalFormat df = new DecimalFormat("#,###");
        for (ModelHoaDonSuaChua data : list){
            try {
                ModelLichSuaChua modelLSC = service.getLSCFromID(data.getMaLSC());
                String tenKH = service.getKH(modelLSC.getMaKH());
                if (tenKH.toLowerCase().contains(txtSearch.getText().toLowerCase()))
                table.addRow(new Object[]{data.getMaHD(), tenKH, data.getNgay(), df.format(Long.parseLong(data.getThanhTien())), data.getMaNV()});
            
            } catch (SQLException ex) {
                Logger.getLogger(HDForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtSearch.setText("");
        txtSearch.setHint("Tìm kiếm . . .");
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCTHDActionPerformed
        int maHD = table.getFirstCol_RowSelected(table.getSelectedRow());
        try {
            main.showForm(new AdminCTHDForm(main, maHD));
        } catch (SQLException ex) {
            Logger.getLogger(HDForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCTHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdCTHD;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
