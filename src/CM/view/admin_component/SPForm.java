package CM.view.admin_component;

import CM.model.ModelNhanVien;
import CM.model.ModelXe;
import CM.view.form.MainForm;
import com.view.swing.WrapLayout;
import com.view.swing.ScrollBarCustom;
import java.awt.Color;

public class SPForm extends javax.swing.JPanel {
    
    private MainForm main;
    private DialogPanel dialog;
    private ModelNhanVien user;
    
    public SPForm(MainForm main, DialogPanel dialog,ModelNhanVien user) {
        this.user = user;
        this.dialog = dialog;
        this.main = main;
        initComponents();
        init();
    }
    
    private void init(){
        panel.setLayout(new WrapLayout(WrapLayout.LEFT, 40, 15));
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.getViewport().setBackground(Color.decode("#FBEED7"));
        
    }
    
    public void addSP(ModelXe model){
        SanPham sanpham = new SanPham(model, main, dialog, user);
        panel.add(sanpham);
        
    }
    
    /**
     *
     */
    public void removeAll(){
        panel.removeAll();
    }
    
    public void rpaint(){
        panel.repaint();
        panel.revalidate();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(251, 238, 215));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
