package CM.view.annouce;

import CM.model.ModelXe;
import CM.view.admin_component.DialogPanel;
import java.text.DecimalFormat;

public class InformationSP extends javax.swing.JPanel {

    private DialogPanel dialog;
    private ModelXe model;
    
    public InformationSP(DialogPanel dialog, ModelXe model) {
        this.dialog = dialog;
        this.model = model;
        initComponents();
        lbMaXe.setText(model.getMaXe() + "");
        lbTenXe.setText(model.getTenXe());
        lbLoaiXe.setText(model.getLoaiXe());
        img.setIcon(model.getXeImg());
        DecimalFormat df = new DecimalFormat("#,###");
        lbGia.setText(df.format(Long.parseLong(model.getGiaBan())));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.view.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        lbMaXe = new javax.swing.JLabel();
        lbTenXe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbLoaiXe = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        roundPanel2 = new com.view.swing.RoundPanel();
        img = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmdExit = new com.view.swing.ButtonOutLine();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel1.setText("Mã xe:");

        lbMaXe.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbMaXe.setText("BMW Z1");

        lbTenXe.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTenXe.setText("Tên nhân viên: ");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel4.setText("Tên xe:");

        lbLoaiXe.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbLoaiXe.setText("Tên nhân viên: ");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setText("Loại xe:");

        lbGia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbGia.setText("Tên nhân viên: ");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel8.setText("Giá bán");

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setMaximumSize(new java.awt.Dimension(152, 222));
        roundPanel2.setMinimumSize(new java.awt.Dimension(152, 222));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Car1.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(94, 68, 33));
        jLabel2.setText("Thông tin xe");

        cmdExit.setBackground(new java.awt.Color(255, 51, 51));
        cmdExit.setForeground(new java.awt.Color(102, 102, 102));
        cmdExit.setText("Thoát");
        cmdExit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLoaiXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(lbMaXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addComponent(cmdExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbMaXe))
                        .addGap(20, 20, 20)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbTenXe))
                        .addGap(20, 20, 20)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbLoaiXe))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbGia))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(cmdExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dialog.setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ButtonOutLine cmdExit;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbLoaiXe;
    private javax.swing.JLabel lbMaXe;
    private javax.swing.JLabel lbTenXe;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
