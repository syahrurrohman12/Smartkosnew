
package com.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Bkamar extends javax.swing.JPanel {

    
    public Bkamar() {
        initComponents();
        setOpaque(false);
    }

    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbIcon = new javax.swing.JLabel();
        IbTitle = new javax.swing.JLabel();
        jumlahKamar1 = new com.swing.jumlahKamar();

        setBackground(new java.awt.Color(254, 204, 203));

        IbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/kamar.png"))); // NOI18N

        IbTitle.setBackground(new java.awt.Color(144, 95, 136));
        IbTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        IbTitle.setForeground(new java.awt.Color(44, 95, 136));
        IbTitle.setText("Kamar");

        jumlahKamar1.setForeground(new java.awt.Color(204, 102, 255));
        jumlahKamar1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(IbTitle)
                            .addComponent(IbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jumlahKamar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(IbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jumlahKamar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(IbTitle)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents
@Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2=(Graphics2D)grphcs ;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0,getWidth(), getHeight(), 40, 40);
        super.paintComponent(grphcs); 
    }
    public void SetData(com.model.Model_Kamar data){
        IbIcon.setIcon(data.getIcon());
        IbTitle.setText(data.getTitle());
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbIcon;
    private javax.swing.JLabel IbTitle;
    private com.swing.jumlahKamar jumlahKamar1;
    // End of variables declaration//GEN-END:variables
}
