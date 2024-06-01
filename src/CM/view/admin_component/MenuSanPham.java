
package CM.view.admin_component;

import CM.controller.event.EventAdminMenuSelected;
import CM.controller.event.EventSearch;
import CM.model.ModelMenu;
import CM.model.ModelNhanVien;
import CM.view.form.MainForm;
import CM.view.annouce.RejectPanel;
import CM.view.card.AdminInsertSPCard;
import CM.view.form.AdminChooseSPForm;
import com.view.swing.Button;
import com.view.swing.TextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class MenuSanPham extends javax.swing.JPanel {
    
    private MigLayout layout;
    private Button cmdAdd;
    private TextField txtSearch;
    private MainForm main;
    private EventSearch event;
    private EventAdminMenuSelected eventA;
    private DialogPanel dialog;
    private ModelNhanVien user;
    
    public MenuSanPham(DialogPanel dialog, MainForm main, ModelNhanVien user) {
        this.user = user;
        this.main = main;
        this.dialog = dialog;
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("wrap", "push[CENTER]push", "push[]10[]20[]25[]10[]push");
        panel.setLayout(layout);
        cmdAdd = new Button();
        cmdAdd.setText("Thêm sản phẩm");
        cmdAdd.setFont(new java.awt.Font("sansserif", 0, 13));
        cmdAdd.setForeground(new Color(255, 255, 255));
        cmdAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    System.out.print(user.getChucVu());
                    if (user.getChucVu().equals("Quan ly")|| user.getChucVu().equals("Kho"))
                        dialog.showForm(new AdminInsertSPCard(main, dialog, user));
                    else dialog.showForm(new RejectPanel(dialog));
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        cmdAdd.setIcon(new ImageIcon(getClass().getResource("/com/view/icon/+.png")));
        panel.add(cmdAdd, "w 75%");
        
        Button cmdBuy = new Button();
        cmdBuy.setText("Mua xe");
        cmdBuy.setFont(new java.awt.Font("sansserif", 0, 13));
        cmdBuy.setForeground(new Color(255, 255, 255));
        cmdBuy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.print(user.getChucVu());
                    if (user.getChucVu().equals("Quan ly")|| user.getChucVu().equals("Ban hang"))
                        main.showForm(new AdminChooseSPForm(main, dialog, user));
                    else dialog.showForm(new RejectPanel(dialog));
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        cmdBuy.setIcon(new ImageIcon(getClass().getResource("/com/view/icon/+.png")));
        panel.add(cmdBuy, "w 75%");
        
        txtSearch = new TextField();
        txtSearch.setHint("Tìm kiếm");
        txtSearch.setPrefixIcon(new ImageIcon(getClass().getResource("/com/view/icon/Finding.png")));
        panel.add(txtSearch, "w 75%");
        
        listMenu1.setOpaque(false);
        listMenu1.addItem(new ModelMenu("Tất cả"));
        listMenu1.addItem(new ModelMenu("Sedan"));
        listMenu1.addItem(new ModelMenu("Convertible"));
        listMenu1.addItem(new ModelMenu("Roadster"));
        listMenu1.addItem(new ModelMenu("Sport activity vehicle"));
        listMenu1.addItem(new ModelMenu("Gran coupe"));
        listMenu1.addItem(new ModelMenu("Electric")); 
        listMenu1.addItem(new ModelMenu("Sport activity coupe"));
    }
    
    public void addEvent(EventSearch event){
        this.event = event;
        txtSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (event != null){
                    event.eventSearch(txtSearch.getText());
                }
                txtSearch.setText("");
            }
            
            
        });
    }
    
    public void addEvent(EventAdminMenuSelected event){
        this.eventA = event;
        listMenu1.addEvent(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu1 = new com.view.swing.ListMenu<>();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(251, 238, 215));

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
