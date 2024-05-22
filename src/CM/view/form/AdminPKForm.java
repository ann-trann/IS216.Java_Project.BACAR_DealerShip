package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import CM.model.ModelPhuKien;
import CM.view.admin_component.DialogPanel;
import CM.view.card.AdminInsertUpdatePKCard;
import CM.view.annouce.RejectPanel;
import com.view.swing.ScrollBarCustom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminPKForm extends javax.swing.JPanel {

    private final MainForm main;
    private Service service;
    private DialogPanel dialog;
    private ArrayList<ModelPhuKien> list;
    private ModelNhanVien user;
    
    public AdminPKForm(MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException {
        this.main = main;
        this.dialog = dialog;
        this.user = user;
        this.service = new Service();
        list = service.getListPhuKien();
        initComponents();
        init();
    }

    private void init(){
        table.fixTable(scroll);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        txtSearch.setHint("Tìm kiếm tên ...");
        
        for (ModelPhuKien data : list){
            table.addRow(new Object[]{data.getMaPK(), data.getTenPK(), data.getXuatXu(), data.getSoLuong(), data.getGiaBan()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PK = new javax.swing.JLabel();
        txtSearch = new com.view.swing.TextField();
        cmdAdd = new com.view.swing.Button();
        cmdUpd = new com.view.swing.Button();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();

        setBackground(new java.awt.Color(251, 238, 215));

        PK.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        PK.setForeground(new java.awt.Color(94, 68, 33));
        PK.setText("Phụ kiện");
        PK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PKMouseClicked(evt);
            }
        });

        txtSearch.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Finding.png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/+.png"))); // NOI18N
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/NotePencil.png"))); // NOI18N
        cmdUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(183, 150, 107));

        roundPanel2.setBackground(new java.awt.Color(251, 238, 215));

        scroll.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phụ kiện", "Tên phụ kiện", "Xuất xứ", "Số lượng", "Giá"
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
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addComponent(scroll)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
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
                        .addComponent(PK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PK)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        table.removeAllRow();
        for (ModelPhuKien data : list){
            if (data.getTenPK().contains(txtSearch.getText())){
                table.addRow(new Object[]{data.getMaPK(), data.getTenPK(), data.getXuatXu(), data.getSoLuong(), data.getGiaBan()});
            }
        }
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        if (user.getChucVu().equals("Quan ly")|| user.getChucVu().equals("Kho")){
            try {
                dialog.showForm(new AdminInsertUpdatePKCard(null, main, dialog, user));
            } catch (SQLException ex) {
                Logger.getLogger(AdminPKForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else dialog.showForm(new RejectPanel(dialog));
    }//GEN-LAST:event_cmdAddActionPerformed

    private void PKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PKMouseClicked
        table.removeAllRow();
        txtSearch.setText("");
        init();
    }//GEN-LAST:event_PKMouseClicked

    private void cmdUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdActionPerformed
        if (user.getChucVu().equals("Quan ly")|| user.getChucVu().equals("Kho")){
            int maPK = table.getFirstCol_RowSelected(table.getSelectedRow());
            ModelPhuKien model = null;
            for (ModelPhuKien data : list){
                if (maPK == data.getMaPK()){
                    model = data;
                    break;
                }
            }
            if (model != null){
                try {
                    dialog.showForm(new AdminInsertUpdatePKCard(model, main, dialog, user));
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPKForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else dialog.showForm(new RejectPanel(dialog));
    }//GEN-LAST:event_cmdUpdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PK;
    private com.view.swing.Button cmdAdd;
    private com.view.swing.Button cmdUpd;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
