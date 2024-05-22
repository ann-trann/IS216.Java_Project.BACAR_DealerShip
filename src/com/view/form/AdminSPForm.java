package com.view.form;

import com.model.ModelCar;
import com.view.admin_component.MenuSanPham;
import com.view.admin_component.SPForm;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class AdminSPForm extends javax.swing.JPanel {

    private MigLayout layout;
    private MenuSanPham menu;
    private SPForm form;
    private MainForm main;
    
    public AdminSPForm(MainForm main) {
        this.main = main;
        initComponents();
        init();
        initSP();
    }

    private void init(){
        layout = new MigLayout("fill, insets 0");
        setLayout(layout);
        form = new SPForm(main);
        menu = new MenuSanPham(main);
        add(menu, "width 20%, pos 0al 0 n 100%");
        add(form, "width 80%, pos 1al 0 n 100%");
    }
    
    private void initSP(){
        form.addSP(new ModelCar("BMW Roadster", "Còn hàng", "3000000000", new ImageIcon(getClass().getResource("/com/view/icon/Car1.png"))));
        form.addSP(new ModelCar("BMW 8 Series Gran Coupé", "Còn hàng", "6900000000", new ImageIcon(getClass().getResource("/com/view/icon/Car2.png"))));
        form.addSP(new ModelCar("BMW i7", "Còn hàng", "7200000000", new ImageIcon(getClass().getResource("/com/view/icon/Car3.png"))));
        form.addSP(new ModelCar("BMW iX3", "Còn hàng", "3500000000", new ImageIcon(getClass().getResource("/com/view/icon/Car4.png"))));
        form.addSP(new ModelCar("BMW i4", "Còn hàng", "6900000000", new ImageIcon(getClass().getResource("/com/view/icon/Car5.png"))));
        form.addSP(new ModelCar("BMW 3 Series", "Còn hàng", "7200000000", new ImageIcon(getClass().getResource("/com/view/icon/Car6.png"))));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
