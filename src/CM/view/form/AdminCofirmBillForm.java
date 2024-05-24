
package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelCTHDSC;
import CM.model.ModelHoaDonSuaChua;
import CM.model.ModelHopDongMuaXe;
import CM.model.ModelKhachHang;
import CM.model.ModelLichSuaChua;
import CM.model.ModelNhanVien;
import CM.model.ModelPhieuBaoHanh;
import CM.model.ModelPhuKien;
import CM.view.admin_component.DialogPanel;
import CM.view.annouce.SuccessPanel;
import com.view.swing.ScrollBarCustom;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class AdminCofirmBillForm extends javax.swing.JPanel {
    
    private MainForm main;
    private DialogPanel dialog;
    private ModelNhanVien user;
    private ArrayList<ModelCTHDSC> listCTHD;
    private ModelLichSuaChua model;
    private int maHD;
    private Service service;
    
    public AdminCofirmBillForm(MainForm main, DialogPanel dialog, ModelNhanVien user, ModelLichSuaChua model, ArrayList<ModelCTHDSC> listCTHD ) throws SQLException {
        this.main = main;
        service = new Service();
        this.dialog = dialog;
        this.user = user;
        this.model = model;
        this.listCTHD = listCTHD;
        initComponents();
        init();
    }
    
    private void init() throws SQLException{
        table.removeAllRow();
        table.fixTable(scroll);
        DecimalFormat df = new DecimalFormat("#,###");
        txtPBH.setHint("Mã phiếu bảo hành");
        long tongTien = 0;
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        for (ModelCTHDSC data : listCTHD){
            String tenPK = "";
            String gia = "";
            maHD = data.getMaHD();
            for (ModelPhuKien dataPK : service.getListPhuKien()){
                if (data.getMaPK() == dataPK.getMaPK()){
                    tenPK = dataPK.getTenPK();
                    gia = dataPK.getGiaBan();
                    tongTien += Long.parseLong(gia) * data.getSoLuong();
                    break;
                }
            }
            table.addRow(new Object[]{tenPK, data.getSoLuong(), df.format(Long.parseLong(gia))});
            
        }
        
        String tenKH = "";
        for (ModelKhachHang data : service.getListKH()){
            if (data.getMaKH() == model.getMaKH()){
                tenKH = data.getTenKH();
                break;
            }
        }
        lbReport.setText("");
        lbTenKH.setText(tenKH);
        lbMaXe.setText(model.getMaXe() + "");
        lbMaLich.setText(model.getMaLSC() + "");
        lbMaHD.setText(maHD + "");
        lbTongTien.setText(df.format(tongTien));
        lbTienPhaiTra.setText(lbTongTien.getText());
    }
    
    private void insertHD() throws SQLException{
        String maPBH = null;
        ArrayList<ModelPhieuBaoHanh> listPBH = service.getListPBH();

        for (ModelPhieuBaoHanh data: listPBH){
            if (data.getMaPBH().equals(txtPBH.getText().trim())){
                maPBH = data.getMaPBH();
                break;
            }
        }
        int maLSC = model.getMaLSC();
        String thanhTien = lbTienPhaiTra.getText();
        maPBH = txtPBH.getText();
        int maNV = user.getMaNV();
        service.insertHDSC(new ModelHoaDonSuaChua(maHD, maLSC, maPBH, thanhTien, maNV));
    }
    
    private void insertCTHDSC() throws SQLException{
        for (ModelCTHDSC data : listCTHD){
            service.insertCTHDSC(data);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        lbMaXe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbMaLich = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();
        cmdOk = new com.view.swing.Button();
        cmdCancel = new com.view.swing.Button();
        cmdBack = new com.view.swing.ButtonOutLine();
        txtPBH = new com.view.swing.TextField();
        roundPanel3 = new com.view.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        lbMaBH = new javax.swing.JLabel();
        lbTienPhaiTra = new javax.swing.JLabel();
        lbReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 238, 215));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(94, 68, 33));
        jLabel1.setText("Xác nhận thanh toán");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Khách hàng:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Mã xe: ");

        lbTenKH.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbTenKH.setText("Nguyễn Văn A");

        lbMaXe.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaXe.setText("100");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Mã lịch: ");

        lbMaLich.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaLich.setText("100");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Mã hóa đơn:");

        lbMaHD.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaHD.setText("100");

        roundPanel1.setBackground(new java.awt.Color(181, 150, 107));

        roundPanel2.setBackground(new java.awt.Color(251, 238, 215));

        scroll.setBorder(null);
        scroll.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ten phu kien", "So luong", "Gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        cmdOk.setForeground(new java.awt.Color(255, 255, 255));
        cmdOk.setText("Xác nhận");
        cmdOk.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOkActionPerformed(evt);
            }
        });

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/back.png"))); // NOI18N
        cmdBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackActionPerformed(evt);
            }
        });

        txtPBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPBHActionPerformed(evt);
            }
        });

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Tổng tiền: ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Mã bảo hành:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Số tiền phải trả: ");

        lbTongTien.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTongTien.setText("10000000");

        lbMaBH.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbMaBH.setText("0");

        lbTienPhaiTra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTienPhaiTra.setText("0");

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(lbTienPhaiTra)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbMaBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbMaBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTienPhaiTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbReport)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cmdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(lbMaXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbMaLich, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPBH, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdOk, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPBH, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMaLich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)))
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdOk, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackActionPerformed
        try {
            main.showForm(new AdminChoosePKForm(main, dialog, user, model, listCTHD));
        } catch (SQLException ex) {
            Logger.getLogger(AdminCofirmBillForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdBackActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        try {
            main.showForm(new AdminLSCForm(main, dialog, user));
        } catch (SQLException ex) {
            Logger.getLogger(AdminCofirmBillForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtPBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPBHActionPerformed
        try {
            boolean check = false;
            ModelPhieuBaoHanh model = null;
            
            ArrayList<ModelPhieuBaoHanh> listPBH = service.getListPBH();
            
            for (ModelPhieuBaoHanh data: listPBH){
                if (data.getMaPBH().equals(txtPBH.getText())){
                    check = true;
                    model = data;
                    break;
                }
            }
            
            if (!check){
                lbReport.setText("Mã phiếu không tồn tại");
                txtPBH.setText("");
            } else if (!service.checkPBHDate(model)){
                lbReport.setText("Mã phiếu đã hết hạn");
                txtPBH.setText("");
            } else{
                if (service.checkPBHXE(model, Integer.parseInt(lbMaXe.getText()))){
                    lbTongTien.setText("0");
                    lbMaBH.setText(txtPBH.getText());
                    lbTienPhaiTra.setText("0");
                } else {
                    lbReport.setText("Mã phiếu không đúng với xe");
                    txtPBH.setText("");
                }
            }
                } catch (SQLException ex) {
            Logger.getLogger(AdminCofirmBillForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPBHActionPerformed

    private void cmdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOkActionPerformed
        //Tạo Document
        PDDocument invc = new PDDocument();
        //Tạo trang trống
        PDPage newpage = new PDPage();
        //Thêm trang trống
        invc.addPage(newpage);
        String title = "BACA Car Dealership ";
        String subtitle = "INVOICE";
        String footer="THANK YOU FOR YOU PURCHASE";
        String tenKH = lbTenKH.getText();
        
        DefaultTableModel table1 = (DefaultTableModel) table.getModel();
        PDFont font = PDType1Font.TIMES_ROMAN;
        //Thêm dữ liệu vào file pdf
        PDPage mypage = invc.getPage(0);
        try {
            PDPageContentStream cs = new PDPageContentStream(invc, mypage);
            //Viết tiêu đề Hóa đơn
            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 22);
            cs.newLineAtOffset(165, 750);
            cs.showText(title);
            cs.endText();

            cs.beginText();
            cs.setFont(font, 18);
            cs.newLineAtOffset(220, 690);
            cs.showText(subtitle);
            cs.endText();
            //Thêm thông tin khách hàng
            cs.beginText();
            cs.setFont(font, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(60, 610);
            cs.showText("Ma Hoa Don: ");
            cs.newLine();
            cs.showText("Ngay: ");
            cs.newLine();
            cs.showText("Khach Hang: ");
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(170, 610);
            cs.showText(maHD + "");
            cs.newLine();
            cs.showText(service.getCurrentDate());
            cs.newLine();
            cs.showText(tenKH);
            cs.endText();

            //Thêm CTHD
            //Cột
            int x = 80;
            for (int col = 0; col < table1.getColumnCount(); col++) {
                cs.beginText();
                cs.setFont(font, 14);
                cs.newLineAtOffset(x, 520);
                cs.showText(table1.getColumnName(col));
                cs.endText();
                if (col == 0) {
                    x += 200;
                } else {
                    x += 120;
                }
            }
            //Hàng
            x = 80;
            for (int col = 0; col < table1.getColumnCount(); col++) {
                cs.beginText();
                cs.setFont(font, 14);
                cs.setLeading(20f);
                cs.newLineAtOffset(x, 500);
                for (int row = 0; row < table1.getRowCount(); row++) {
                    cs.showText(table1.getValueAt(row, col).toString());
                    cs.newLine();
                }
                cs.endText();
                if (col == 0) {
                    x += 200;
                } else {
                    x += 120;
                }

            }
            //Thêm dữ liệu phần thanh toán
            cs.beginText();
            cs.setFont(font, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(280, 480 - (table1.getRowCount() * 20));
            cs.showText("Tong tien sua chua: ");
            cs.newLine();
            cs.showText("Ma phieu bao hanh: ");
            cs.newLine();
            cs.showText("Tong tien phai tra: ");
            cs.newLine();
            cs.endText();

            cs.beginText();
            cs.setFont(font, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(400, 480 - (table1.getRowCount() * 20));
            cs.showText(lbTongTien.getText());
            cs.newLine();
            cs.showText(lbMaBH.getText());
            cs.newLine();
            cs.showText(lbTienPhaiTra.getText());
            cs.endText();
            //Cuối Hóa đơn
            cs.beginText();
            cs.setFont(PDType1Font.TIMES_BOLD, 20);
            cs.newLineAtOffset(150, 350 - (table1.getRowCount() * 20));
            cs.showText(footer);
            cs.endText();
            //Đóng file
            cs.close();
            //Lưu file
            invc.save(".\\src\\CM\\view\\export_bill\\HoaDon_ID-" + maHD + ".pdf");
            File file=new File("src\\CM\\view\\export_bill\\HoaDon_ID-" + maHD + ".pdf");
            this.insertHD();
            this.insertCTHDSC();
            dialog.showForm(new SuccessPanel(dialog));
            main.showForm(new AdminLSCForm(main, dialog, user));

        } catch (IOException ex) {
            Logger.getLogger(AdminCofirmBillForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminCofirmBillForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ButtonOutLine cmdBack;
    private com.view.swing.Button cmdCancel;
    private com.view.swing.Button cmdOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbMaBH;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbMaLich;
    private javax.swing.JLabel lbMaXe;
    private javax.swing.JLabel lbReport;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTienPhaiTra;
    private javax.swing.JLabel lbTongTien;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private com.view.swing.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scroll;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtPBH;
    // End of variables declaration//GEN-END:variables
}
