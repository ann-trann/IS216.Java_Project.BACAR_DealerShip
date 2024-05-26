
package CM.view.staff_component;



import CM.controller.event.EventAdminMenuSelected;
import CM.model.ModelMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

public class MenuStaffBH extends javax.swing.JPanel {

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
    
    
    public MenuStaffBH() {
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
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/SP.png")), "    Sản phẩm"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/HDon.png")), "    Hóa đơn"));
        listMenu1.addItem(new ModelMenu(new ImageIcon(getClass().getResource("/com/view/icon/HDong.png")), "    Hợp đồng"));
    }   



    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#FFF9F1"));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu1 = new com.view.swing.ListMenu<>();
        panelTop = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();

        listMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nameLabel.setText("Car Shop");

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addContainerGap(30, Short.MAX_VALUE))
        );

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
                .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.ListMenu<String> listMenu1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables
}
