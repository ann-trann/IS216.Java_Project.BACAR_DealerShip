
package com.view.admin_component;

import com.model.ModelMenu;
import com.raven.datechooser.SelectedDate;
import net.miginfocom.swing.MigLayout;

public class MenuHoaDon extends javax.swing.JPanel {
    
    private MigLayout layout;

    public MenuHoaDon() {
        initComponents();
        init();
    }
    
    private void init(){
        layout = new MigLayout("wrap", "push[CENTER]push", "push[]20[]25[]10[]10[]push");
        this.setLayout(layout);
        lbReport.setText("");
        
        this.removeAll();
        this.add(cmdAdd, "w 75%");
        this.add(timeSearch, "w 75%");
        this.add(lbReport, "w 75%");
        this.add(listMenu, "w 75%");
        
        
        listMenu.addItem(new ModelMenu("    Tất cả"));
        listMenu.addItem(new ModelMenu("    Mua xe"));
        listMenu.addItem(new ModelMenu("    Sửa chữa"));
        
        this.repaint();
        this.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateStart = new com.raven.datechooser.DateChooser();
        dateEnd = new com.raven.datechooser.DateChooser();
        cmdAdd = new com.view.swing.Button();
        timeSearch = new com.view.swing.RoundPanel();
        txtDateEnd = new com.view.swing.TextField();
        txtDateStart = new com.view.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        button2 = new com.view.swing.Button();
        listMenu = new com.view.swing.ListMenu<>();
        lbReport = new javax.swing.JLabel();

        dateStart.setForeground(new java.awt.Color(183, 150, 107));
        dateStart.setTextRefernce(txtDateStart);

        dateEnd.setForeground(new java.awt.Color(183, 150, 107));
        dateEnd.setTextRefernce(txtDateEnd);

        setBackground(new java.awt.Color(251, 238, 215));

        cmdAdd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/+.png"))); // NOI18N
        cmdAdd.setText("Thêm hóa đơn");
        cmdAdd.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        timeSearch.setBackground(new java.awt.Color(232, 214, 185));

        txtDateEnd.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtDateEnd.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Calendar.png"))); // NOI18N

        txtDateStart.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtDateStart.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Calendar.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(183, 150, 107));
        jLabel1.setText("Thời gian");

        button2.setBackground(new java.awt.Color(183, 150, 107));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Tìm kiếm");
        button2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timeSearchLayout = new javax.swing.GroupLayout(timeSearch);
        timeSearch.setLayout(timeSearchLayout);
        timeSearchLayout.setHorizontalGroup(
            timeSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timeSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(timeSearchLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timeSearchLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        timeSearchLayout.setVerticalGroup(
            timeSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timeSearchLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listMenu.setOpaque(false);

        lbReport.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("abc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lbReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(timeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdAddActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        SelectedDate start = dateStart.getSelectedDate();
        SelectedDate end = dateEnd.getSelectedDate();
        System.out.println(start.getDay() + "-" + start.getMonth() + "-" + start.getYear());
        System.out.println(end.getDay() + "-" + end.getMonth() + "-" + end.getYear());
        lbReport.setText("456");
        if (start.getYear() > end.getYear()){
            lbReport.setText("Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
        } else if (start.getYear() == end.getYear()){
            if (start.getMonth() > end.getMonth()){
                lbReport.setText("Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
            } else if (start.getMonth() == end.getMonth()){
                if (start.getDay() > end.getDay()){
                    lbReport.setText("Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
                }
                else {
                    lbReport.setText("");
                }
            } else {
                lbReport.setText("");
            }
        } else{
            lbReport.setText("");
        }
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button button2;
    private com.view.swing.Button cmdAdd;
    private com.raven.datechooser.DateChooser dateEnd;
    private com.raven.datechooser.DateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbReport;
    private com.view.swing.ListMenu<String> listMenu;
    private com.view.swing.RoundPanel timeSearch;
    private com.view.swing.TextField txtDateEnd;
    private com.view.swing.TextField txtDateStart;
    // End of variables declaration//GEN-END:variables
}
