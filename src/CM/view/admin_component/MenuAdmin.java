package CM.view.admin_component;

import CM.controller.event.EventAdminMenuSelected;
import CM.model.ModelMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

public class MenuAdmin extends javax.swing.JPanel {

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public boolean isShowMenu() {
        return showMenu;
    }


    
    private EventAdminMenuSelected event;
    private boolean showMenu = false;
    
    public void addEvent(EventAdminMenuSelected event){
        this.event = event;
        listMenu1.addEvent(event);
    }
    
    
    public MenuAdmin() {
        initComponents();
        setOpaque(false);
        init();
        initItem();
    }
    
    private void init(){
        panelTop.setOpaque(false);
        listMenu1.setOpaque(false);
        nameLabel.setFont(new Font("sansserif", 1, 18));
        nameLabel.setForeground(Color.decode("#C3AD8F"));
    }
    
    private void initItem(){
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/TK.png")), "    Thống kê"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/SP.png")), "    Sản phẩm"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/PK.png")), "    Phụ kiện"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/LSC.png")), "    Lịch sửa chữa"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/HDon.png")), "    Hóa đơn"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/NV.png")), "    Nhân viên"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/KH.png")), "    Khách hàng"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/HDong.png")), "    Hợp đồng"));
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTop = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        listMenu1 = new com.view.swing.ListMenu<>();

        nameLabel.setText("Car Shop");

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        listMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#FFF9F1"));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ListMenu<String> listMenu1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables
}
