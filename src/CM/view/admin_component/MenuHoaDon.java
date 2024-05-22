
package CM.view.admin_component;

import CM.controller.event.EventInit;
import CM.controller.event.EventSearchBill;
import com.raven.datechooser.SelectedDate;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.miginfocom.swing.MigLayout;

public class MenuHoaDon extends javax.swing.JPanel {
    
    private MigLayout layout;
    private EventSearchBill event;
    private EventInit evt;

    public MenuHoaDon() {
        
        initComponents();
        init();
    }
    
    public void addEvent(EventSearchBill event){
        this.event = event;
        cmdSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.eventSeachBill(txtDateStart.getText(), txtDateEnd.getText());
            }
            
        });
    }
    
    public void addEvent(EventInit evt){
        this.evt = evt;
        lbHD.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                evt.eventInit();
            }
        });
    }
    
    private void init(){
        layout = new MigLayout("wrap", "push[CENTER]push", "push[]10[]25[]10[]10[]push");
        this.setLayout(layout);
        lbReport.setText("");
        
        this.removeAll();
        this.add(lbHD);
        this.add(panel, "w 75%");
        this.add(lbReport, "w 75%");
        lbHD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.repaint();
        this.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateStart = new com.raven.datechooser.DateChooser();
        dateEnd = new com.raven.datechooser.DateChooser();
        lbReport = new javax.swing.JLabel();
        panel = new com.view.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDateStart = new com.view.swing.TextField();
        txtDateEnd = new com.view.swing.TextField();
        cmdSearch = new com.view.swing.Button();
        lbHD = new javax.swing.JLabel();

        dateStart.setForeground(new java.awt.Color(183, 150, 107));
        dateStart.setTextRefernce(txtDateStart);

        dateEnd.setForeground(new java.awt.Color(183, 150, 107));
        dateEnd.setTextRefernce(txtDateEnd);

        setBackground(new java.awt.Color(251, 238, 215));

        lbReport.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("abc");

        panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Thời gian");

        txtDateStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDateStartMousePressed(evt);
            }
        });

        txtDateEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDateEndMousePressed(evt);
            }
        });

        cmdSearch.setText("Tìm kiếm");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lbHD.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbHD.setForeground(new java.awt.Color(94, 68, 33));
        lbHD.setText("Hóa đơn");
        lbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lbReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(145, 145, 145)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(lbReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(116, 116, 116))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdAddActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        SelectedDate start = dateStart.getSelectedDate();
        SelectedDate end = dateEnd.getSelectedDate();
        lbReport.setText("456");
        if (start.getYear() > end.getYear()){
            lbReport.setText("Lỗi ngày");
        } else if (start.getYear() == end.getYear()){
            if (start.getMonth() > end.getMonth()){
                lbReport.setText("Lỗi ngày");
            } else if (start.getMonth() == end.getMonth()){
                if (start.getDay() > end.getDay()){
                    lbReport.setText("Lỗi ngày");
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

    private void lbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHDMouseClicked
        this.evt.eventInit();
    }//GEN-LAST:event_lbHDMouseClicked

    private void txtDateStartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateStartMousePressed
        dateStart.showPopup();
    }//GEN-LAST:event_txtDateStartMousePressed

    private void txtDateEndMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateEndMousePressed
        dateEnd.showPopup();
    }//GEN-LAST:event_txtDateEndMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdSearch;
    private com.raven.datechooser.DateChooser dateEnd;
    private com.raven.datechooser.DateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbHD;
    private javax.swing.JLabel lbReport;
    private com.view.swing.RoundPanel panel;
    private com.view.swing.TextField txtDateEnd;
    private com.view.swing.TextField txtDateStart;
    // End of variables declaration//GEN-END:variables
}
