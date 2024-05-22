
package com.view.login_component;

import com.view.swing.Button;
import com.view.swing.PasswordField;
import com.view.swing.TextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLogIn extends javax.swing.JPanel {
    
    private JLabel DN;
    private Button signIn;
    private TextField txtUser;
    private PasswordField txtPass;
    private MigLayout layout;
    
    public PanelLogIn(ActionListener cmdForget) {
        initComponents();
        init(cmdForget);
    }
    
    private void init(ActionListener cmdForget){
        layout = new MigLayout("wrap", "push[CENTER]push", "push[]20[]20[]10[]30[]push");
        this.setLayout(layout);
        DN = new JLabel("Đăng nhập");
        DN.setFont(new Font("sansserif", 1, 30));
        DN.setForeground(Color.WHITE);
        this.add(DN);
        txtUser = new TextField();
        txtUser.setHint("Username");
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/view/icon/user.png")));
        this.add(txtUser, "w 65%");
        txtPass = new PasswordField();
        txtPass.setHint("Password");
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/view/icon/key.png")));
        this.add(txtPass, "w 65%");
        JButton forPass = new JButton();
        forPass.setContentAreaFilled(false);
        forPass.setText("Quên mật khẩu?");
        forPass.setFont(new Font("sansserif", 0, 12));
        forPass.setForeground(Color.WHITE);
        forPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forPass.addActionListener(cmdForget);
        this.add(forPass);
        signIn = new Button();
        signIn.setText("Đăng nhập");
        signIn.setFont(new Font("sansserif", 1, 17));
        signIn.setForeground(Color.decode("#634824"));
        
        this.add(signIn, "w 65%");      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(94, 68, 33));

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
