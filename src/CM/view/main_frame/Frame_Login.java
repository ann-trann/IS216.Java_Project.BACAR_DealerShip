package CM.view.main_frame;

import CM.model.ModelNhanVien;
import CM.view.login_component.PanelLogIn;
import CM.view.login_component.RoundPanelImageLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

public class Frame_Login extends javax.swing.JFrame {

    private MigLayout layout;
    private RoundPanelImageLogin roundPanel;
    private PanelLogIn panelLogin;
    private final double coverSize = 55;
    private final double loginSize = 45;
    private boolean check = false;
    
    public Frame_Login() throws SQLException {
        initComponents();
        setTitle("BACAR Dealership");
        init();
    }
    
    public void end(){
        this.setVisible(false);
    }
    
    private void init() throws SQLException{
               
        ActionListener login = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ModelNhanVien data = panelLogin.checkLogin();
                    if (data != null){
                        if (data.getChucVu().equals("Quan ly")){
                            Frame_Admin.main(data);
                        } else if (data.getChucVu().toLowerCase().equals("sua chua")){
                            Frame_StaffKT.main(data);
                        } else if (data.getChucVu().toLowerCase().equals("ban hang")) {
                            Frame_StaffBH.main(data);
                        } else {
                            Frame_StaffKho.main(data);
                        }
                        end();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        
        layout = new MigLayout("fill, insets 0");
        roundPanel = new RoundPanelImageLogin();
        panelLogin = new PanelLogIn(login);
        
        bg.setLayout(layout);
        bg.add(roundPanel, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(panelLogin, "width " + loginSize + "%, pos 1al 0 n 100%");
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(94, 68, 33));
        setPreferredSize(new java.awt.Dimension(900, 675));

        bg.setBackground(new java.awt.Color(94, 68, 33));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame_Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame_Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
