package CM.view.form;

import CM.controller.event.EventInit;
import CM.controller.event.EventSearchBill;
import CM.view.admin_component.HDForm;
import CM.view.admin_component.MenuHoaDon;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;


public class AdminHDForm extends javax.swing.JPanel {

    private HDForm form;
    private MenuHoaDon menu;
    private MigLayout layout;
    
    public AdminHDForm() throws SQLException {
        initComponents();
        init();
    }
    
    private void init() throws SQLException{
        layout = new MigLayout("fill, insets 0");
        setLayout(layout);
        menu = new MenuHoaDon();
        add(menu, "width 30%, pos 0al 0 n 100%");
        form = new HDForm();
        add(form, "width 70%, pos 1al 0 n 100%");
        menu.addEvent(new EventSearchBill(){
            @Override
            public void eventSeachBill(String str1, String str2) {
                try {
                    form.searchBill(str1, str2);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHDForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        menu.addEvent(new EventInit(){
            @Override
            public void eventInit() {
                try {
                    form.initHD();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHDForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(251, 238, 215));
        setForeground(new java.awt.Color(195, 173, 143));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
