package CM.view.admin_component;

import CM.model.ModelNhanVien;
import CM.view.card.AdminInsertUpdateSPCard;
import CM.model.ModelXe;
import CM.view.form.MainForm;
import CM.view.annouce.RejectPanel;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPham extends javax.swing.JPanel {

    private ModelXe model;
    private MainForm main;
    private DialogPanel dialog;
    private ModelNhanVien user;

    public SanPham(ModelXe model, MainForm main, DialogPanel dialog, ModelNhanVien user) {
        this.user = user;
        this.dialog = dialog;
        this.main = main;
        this.model = model;
        initComponents();
        init();
    }

    private void init() {
        DecimalFormat df = new DecimalFormat("#,###");
        logo.setIcon(model.getXeImg());
        this.lbTenXe.setText(model.getTenXe());
        this.lbGia.setText(df.format(Long.parseLong(model.getGiaBan())));
        this.lbSoLuong.setText(model.getSoLuong() +"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTenXe = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmdUpdate = new com.view.swing.Button();
        cmdCheck = new com.view.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(183, 150, 107), 5, true));

        lbTenXe.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbTenXe.setText("jLabel1");

        lbGia.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lbGia.setForeground(new java.awt.Color(183, 150, 107));
        lbGia.setText("jLabel1");

        lbSoLuong.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lbSoLuong.setText("1");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Car1.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel1.setText("SL:");

        cmdUpdate.setText("+");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdCheck.setText("-");
        cmdCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(cmdUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addComponent(lbTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        try {
            if (user.getChucVu().equals("Quan ly")|| user.getChucVu().equals("Kho"))
                dialog.showForm(new AdminInsertUpdateSPCard(model, dialog, main, user));
            else dialog.showForm(new RejectPanel(dialog));
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCheckActionPerformed
        
    }//GEN-LAST:event_cmdCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdCheck;
    private com.view.swing.Button cmdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenXe;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables

}
