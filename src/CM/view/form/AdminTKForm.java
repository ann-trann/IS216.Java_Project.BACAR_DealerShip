package CM.view.form;

import CM.controller.service.Service;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;

public class AdminTKForm extends javax.swing.JPanel {

    private Service service;
    
    public AdminTKForm() throws SQLException {
        initComponents();
        service = new Service();
        init();
    }
    
    private void init() throws SQLException{
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        lbThang.setText(service.getCurrentDate());
        double[] arrDT = new double[currentMonth ];
        double[] arrCP = new double[currentMonth ];
        double[] arrLN = new double[currentMonth ];
        String[] listMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        for (int i = 0; i < currentMonth; i++){
            arrDT[i] = service.getDoanhThu(i + 1);
            arrCP[i] = service.getChiPhi(i + 1);
            arrLN[i] = arrDT[i] - arrCP[i];
        }
        
        lineChart.addLegend("Doanh thu", Color.decode("#4F6F52"), Color.decode("#4F6F52"));
        lineChart.addLegend("Chi phí", Color.decode("#AF8260"), Color.decode("#AF8260"));
        lineChart.addLegend("Lợi nhuận", Color.decode("#803D3B"), Color.decode("#803D3B"));
        
        for (int i = 0; i < currentMonth; i++){
            double[] values = new double[3];
            values[0] = arrDT[i];
            values[1] = arrCP[i];
            values[2] = arrLN[i];
            lineChart.addData(new ModelChart(listMonth[i], values));
            lineChart.start();
        }
        DecimalFormat df = new DecimalFormat("#,###.##");
        CardDT.initCard("Doanh thu", df.format(arrDT[currentMonth - 1]));
        CardCP.initCard("Chi phí", df.format(arrCP[currentMonth - 1]));
        CardLN.initCard("Lợi nhuận", df.format(arrLN[currentMonth - 1]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CardLN = new CM.view.card.TKCard();
        CardDT = new CM.view.card.TKCard();
        CardCP = new CM.view.card.TKCard();
        cmdTK = new javax.swing.JLabel();
        lbThang = new javax.swing.JLabel();
        roundPanel1 = new com.view.swing.RoundPanel();
        lineChart = new com.raven.chart.LineChart();
        cmdBieuDo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 238, 215));

        CardLN.setBackground(new java.awt.Color(149, 126, 97));
        CardLN.setGradientColor(new java.awt.Color(183, 150, 107));
        CardLN.setMaximumSize(new java.awt.Dimension(222, 134));
        CardLN.setMinimumSize(new java.awt.Dimension(222, 134));

        CardDT.setBackground(new java.awt.Color(183, 150, 107));
        CardDT.setGradientColor(new java.awt.Color(138, 113, 81));
        CardDT.setMaximumSize(new java.awt.Dimension(222, 134));
        CardDT.setMinimumSize(new java.awt.Dimension(222, 134));

        CardCP.setBackground(new java.awt.Color(138, 113, 81));
        CardCP.setGradientColor(new java.awt.Color(149, 126, 97));
        CardCP.setMaximumSize(new java.awt.Dimension(222, 134));
        CardCP.setMinimumSize(new java.awt.Dimension(222, 134));

        cmdTK.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        cmdTK.setForeground(new java.awt.Color(94, 68, 33));
        cmdTK.setText("Thống kê");

        lbThang.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbThang.setForeground(new java.awt.Color(94, 68, 33));
        lbThang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThang.setText("Tháng 5");

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        cmdBieuDo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cmdBieuDo.setForeground(new java.awt.Color(94, 68, 33));
        cmdBieuDo.setText("Biểu đồ tăng trưởng ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdTK, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addGap(745, 745, 745))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdBieuDo)
                                .addGap(583, 583, 583)
                                .addComponent(lbThang, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CardDT, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(CardCP, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(CardLN, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdTK, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CardLN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardCP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbThang, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CM.view.card.TKCard CardCP;
    private CM.view.card.TKCard CardDT;
    private CM.view.card.TKCard CardLN;
    private javax.swing.JLabel cmdBieuDo;
    private javax.swing.JLabel cmdTK;
    private javax.swing.JLabel lbThang;
    private com.raven.chart.LineChart lineChart;
    private com.view.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
