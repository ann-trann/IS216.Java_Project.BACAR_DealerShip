package CM.view.admin_component;

import CM.model.ModelNhanVien;
import CM.view.card.InformationOfNVCard;
import CM.view.form.MainForm;
import java.awt.Cursor;
import java.awt.event.ActionListener;


public class HeaderAdmin extends javax.swing.JPanel {

    private MainForm main;
    private DialogPanel dialog;
    private ModelNhanVien user;
    
    public void addMenuEvent(ActionListener event){
        cmdMenu.addActionListener(event);
    }
    
    public HeaderAdmin() {
        initComponents();
        cmdMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
   
    public void init(MainForm main, DialogPanel dialog, ModelNhanVien user){
        this.user = user;
        this.main = main;
        this.dialog = dialog;
        lbTen.setText(user.getTenNV());
        lbChucvu.setText(user.getChucVu());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new com.view.swing.Button();
        buttonOutLine1 = new com.view.swing.ButtonOutLine();
        lbTen = new javax.swing.JLabel();
        lbChucvu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(183, 150, 107));

        cmdMenu.setBackground(new java.awt.Color(183, 150, 107));
        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/GetIn.png"))); // NOI18N
        cmdMenu.setMaximumSize(new java.awt.Dimension(30, 30));
        cmdMenu.setMinimumSize(new java.awt.Dimension(30, 30));
        cmdMenu.setPreferredSize(new java.awt.Dimension(30, 30));

        buttonOutLine1.setBackground(new java.awt.Color(183, 150, 107));
        buttonOutLine1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/user.png"))); // NOI18N
        buttonOutLine1.setMaximumSize(new java.awt.Dimension(30, 30));
        buttonOutLine1.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonOutLine1.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });

        lbTen.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbTen.setForeground(new java.awt.Color(251, 238, 215));
        lbTen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTen.setText("Nguyễn Thái Bảo");

        lbChucvu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbChucvu.setForeground(new java.awt.Color(251, 238, 215));
        lbChucvu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChucvu.setText("Quản lý");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lbChucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonOutLine1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbTen)
                        .addGap(4, 4, 4)
                        .addComponent(lbChucvu, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        dialog.showForm(new InformationOfNVCard(main, dialog, user));
    }//GEN-LAST:event_buttonOutLine1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ButtonOutLine buttonOutLine1;
    private com.view.swing.Button cmdMenu;
    private javax.swing.JLabel lbChucvu;
    private javax.swing.JLabel lbTen;
    // End of variables declaration//GEN-END:variables
}
