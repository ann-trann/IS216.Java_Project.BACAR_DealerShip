package CM.view.form;

import CM.controller.event.EventAdminMenuSelected;
import CM.controller.event.EventSearch;
import CM.controller.service.Service;
import CM.model.ModelNhanVien;
import CM.model.ModelXe;
import CM.view.admin_component.DialogPanel;
import CM.view.admin_component.MenuSanPham;
import CM.view.admin_component.SPForm;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class AdminSPForm extends javax.swing.JPanel {

    private MigLayout layout;
    private MenuSanPham menu;
    private SPForm form;
    private MainForm main;
    private Service service;
    private ArrayList<ModelXe> list;
    private DialogPanel dialog;
    private final ModelNhanVien user;
    
    public AdminSPForm(MainForm main, DialogPanel dialog, ModelNhanVien user) throws SQLException {
        this.dialog = dialog;
        this.main = main;
        this.user = user;
        initComponents();
        init();
        initSP();
    }

    private void init() throws SQLException{
        service = new Service();
        list = service.getListXe();
        layout = new MigLayout("fill, insets 0");
        setLayout(layout);
        form = new SPForm(main, dialog, user);
        menu = new MenuSanPham(dialog, main, user);
        menu.addEvent(new EventSearch(){
            @Override
            public void eventSearch(String txt) {
                searchXe(txt);
            }
        });
        menu.addEvent(new EventAdminMenuSelected(){
            @Override
            public void eventSelected(int index) {
                switch(index){
                    case 0: searchXe("BMW");
                    break;
                    case 1: searchLoaiXe("Sedan");
                    break;
                    case 2: searchLoaiXe("Convertible");
                    break;
                    case 3: searchLoaiXe("Roadster");
                    break;
                    case 4: searchLoaiXe("Sport activity vehicle");
                    break;
                    case 5: searchLoaiXe("Gran coupe");
                    break;
                    case 6: searchLoaiXe("Electric");
                    break;
                    case 7: searchLoaiXe("Sport activity coupe");
                    break;
                }
            }
        });
        add(menu, "width 20%, pos 0al 0 n 100%");
        add(form, "width 80%, pos 1al 0 n 100%");
    }
    
    private void initSP(){
        int i = 1;
        for (ModelXe data : list){
            data.setXeImg(new ImageIcon(getClass().getResource("/com/view/icon/Car" + i +".png")));
            i = (i % 25) + 1;
            form.addSP(data);
        }
    }
    
    public void searchXe(String txt){
        form.removeAll();
        for (ModelXe data : list){
            if (data.getTenXe().toLowerCase().contains(txt.toLowerCase())){
                form.addSP(data);
            }
        }
        form.rpaint();
    }
    
    public void searchLoaiXe(String txt){
        form.removeAll();
        for (ModelXe data : list){
            if (data.getLoaiXe().contains(txt)){
                form.addSP(data);
            }
        }
        form.rpaint();
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
