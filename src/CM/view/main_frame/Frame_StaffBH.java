package CM.view.main_frame;

import CM.controller.event.EventAdminMenuSelected;
import CM.model.ModelNhanVien;
import CM.view.admin_component.DialogPanel;
import CM.view.form.MainForm;
import CM.view.admin_component.MenuAdmin;
import CM.view.admin_component.HeaderAdmin;
import CM.view.form.AdminHDForm;
import CM.view.form.AdminSPForm;
import CM.view.form.AdminTTHDForm;
import CM.view.staff_component.MenuStaffBH;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Frame_StaffBH extends javax.swing.JFrame {

    private MenuStaffBH menu;
    private HeaderAdmin header;
    private MigLayout layout;
    private Animator animator;
    private MainForm main;
    private DialogPanel dialog;
    private ModelNhanVien model;
    
    public Frame_StaffBH() throws SQLException {
        initComponents();
        init();
    }
    
    public Frame_StaffBH(ModelNhanVien model) throws SQLException {
        this.model = model;
        setTitle("BACAR Dealership");
        initComponents();
        init();
    }
    
    private void init() throws SQLException{
        main = new MainForm();
        dialog = new DialogPanel();
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new MenuStaffBH();
        header = new HeaderAdmin();
        main.setLayout(new BorderLayout());
        bg.setLayout(layout);
        bg.setLayer(dialog, JLayeredPane.POPUP_LAYER);
        bg.add(dialog, "pos 0 0 100% 100%");
        bg.add(menu, "w 0!, spany 2");
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        
        menu.addEvent(new EventAdminMenuSelected(){
            @Override
            public void eventSelected(int index) {
                switch(index){
                    case 0: {
                        try {
                            main.showForm(new AdminSPForm(main, dialog, model));
                        } catch (SQLException ex) {
                            Logger.getLogger(Frame_StaffBH.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    case 1: {
                        try {
                            main.showForm(new AdminHDForm(main));
                        } catch (SQLException ex) {
                            Logger.getLogger(Frame_StaffBH.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    
                    case 2: {
                        try {
                            main.showForm(new AdminTTHDForm());
                        } catch (SQLException ex) {
                            Logger.getLogger(Frame_StaffBH.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                }
            }
        });
        
        main.showForm(new AdminSPForm(main, dialog, model));
        header.init(main, dialog, model);
        
        TimingTarget target;
        target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction){
                double width;
                if (menu.isShowMenu()){
                    width = 0 + 170 * (1f - fraction);
                } else {
                    width = 0 + 170 * fraction;
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany 2");
                menu.revalidate();
            }
            
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
            }
        };
        
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (!animator.isRunning()){
                    animator.start();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 675));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame_StaffBH().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_StaffBH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static void main(ModelNhanVien model) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame_StaffBH(model).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_StaffBH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
