
package CM.view.login_component;

import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import com.view.swing.Button;
import com.view.swing.PasswordField;
import com.view.swing.TextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLogIn extends javax.swing.JPanel {
    
    private JLabel DN;
    private Button signIn;
    private TextField txtUser;
    private PasswordField txtPass;
    private JLabel lbReport;
    private MigLayout layout;
    private Service service;
    
    public PanelLogIn(ActionListener login) throws SQLException {
        service =new Service();
        initComponents();
        init(login);
    }
    
    private void init(ActionListener login){
        layout = new MigLayout("wrap", "push[CENTER]push", "push[]20[]20[]10[]10[]30[]push");
        this.setLayout(layout);
        DN = new JLabel("Đăng nhập");
        DN.setFont(new Font("sansserif", 1, 30));
        DN.setForeground(Color.WHITE);
        this.add(DN);
        txtUser = new TextField();
        txtUser.setHint("Username");
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/view/icon/Vector.png")));
        this.add(txtUser, "w 65%");
        txtPass = new PasswordField();
        txtPass.setHint("Password");
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/view/icon/Key.png")));
        this.add(txtPass, "w 65%");
        lbReport = new JLabel("");
        lbReport.setFont(new Font("sansserif", 1, 12));
        lbReport.setForeground(Color.WHITE);
        lbReport.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbReport, "w 65%");
        signIn = new Button();
        signIn.setText("Đăng nhập");
        signIn.setFont(new Font("sansserif", 1, 17));
        signIn.setForeground(Color.decode("#634824"));
        signIn.addActionListener(login);
        this.add(signIn, "w 65%"); 
        
        KeyAdapter enterKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    signIn.doClick();  // Trigger the login button click
                }
            }
        };

        txtUser.addKeyListener(enterKeyAdapter);
        txtPass.addKeyListener(enterKeyAdapter);
    }
    
    public void showReport(){
        lbReport.setText("Tài khoản hoặc mật khẩu sai");
    }
    
    public ModelNhanVien checkLogin() throws SQLException{
        ModelNhanVien model = null;
        lbReport.setText("");
        String user = txtUser.getText();
        String pass = txtPass.getText();
        if (user.isBlank() || pass.isBlank()){
            showReport();
            return model;
        }
        for (ModelNhanVien data : service.getListNV()){
            if (data.getTaiKhoan() == null) continue;
            if (data.getTaiKhoan().equals(user) && data.getMatKhau().equals(pass)){
                model = data;
            }
        }
        if (model ==  null){
            showReport();
        }
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(94, 68, 33));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
