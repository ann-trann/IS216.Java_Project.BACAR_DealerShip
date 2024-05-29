package CM.view.admin_component;

import CM.model.ModelPhuKien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class PhuKien extends javax.swing.JPanel {

    private ModelPhuKien model;
    
    public PhuKien(ModelPhuKien model) {
        this.model = model;
        initComponents();
        init();
    }
    
    public int getMaPK(){
        return this.model.getMaPK();
    }
    
    private void init(){
        DecimalFormat  df = new DecimalFormat ("#,###");
        lbGia.setText(df.format(Long.parseLong(model.getGiaBan())));
        lbTenPK.setText(model.getTenPK());
        lbSoLuong.setText("0");
        lbXuatXu.setText(model.getXuatXu());
        
        cmdUp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int soLuongMax = model.getSoLuong();
                int soLuong = Integer.valueOf(lbSoLuong.getText());
                if (soLuong == soLuongMax){
                    soLuong = soLuong - 1;
                }
                soLuong++;
                lbSoLuong.setText(soLuong + "");
            }
            
        });
        
        cmdDown.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int soLuong = Integer.valueOf(lbSoLuong.getText());
                if (soLuong == 0){
                    soLuong = soLuong + 1;
                }
                soLuong--;
                lbSoLuong.setText(soLuong + "");
            }
            
        });
    }
    
    public int getSoLuong(){
        int soLuong = Integer.parseInt(lbSoLuong.getText());
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        lbSoLuong.setText(soLuong + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgPK = new javax.swing.JLabel();
        lbTenPK = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        cmdDown = new com.view.swing.ButtonOutLine();
        cmdUp = new com.view.swing.ButtonOutLine();
        lbXuatXu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        imgPK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/PhuKien.png"))); // NOI18N

        lbTenPK.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTenPK.setForeground(new java.awt.Color(183, 150, 107));
        lbTenPK.setText("Tên PK");

        lbGia.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbGia.setForeground(new java.awt.Color(183, 150, 107));
        lbGia.setText("Giá");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSoLuong.setText("1");

        cmdDown.setBackground(new java.awt.Color(102, 102, 0));
        cmdDown.setText("-");
        cmdDown.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        cmdUp.setBackground(new java.awt.Color(102, 102, 0));
        cmdUp.setText("+");
        cmdUp.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        lbXuatXu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbXuatXu.setForeground(new java.awt.Color(183, 150, 107));
        lbXuatXu.setText("Xuất xứ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPK, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTenPK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(cmdDown, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(cmdUp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                                .addGap(37, 37, 37)))
                        .addGap(17, 17, 17))
                    .addComponent(lbXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgPK, javax.swing.GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTenPK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(lbXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                    .addComponent(cmdDown, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmdUp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ButtonOutLine cmdDown;
    private com.view.swing.ButtonOutLine cmdUp;
    private javax.swing.JLabel imgPK;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenPK;
    private javax.swing.JLabel lbXuatXu;
    // End of variables declaration//GEN-END:variables
}
