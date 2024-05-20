
package com.component;

import com.event.EventMenuSelected;
import com.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;


public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
    this.event=event;
    listMenu1.addEventMenuSelected(event);
}
    
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
private void init(){
    listMenu1.addItem(new Model_Menu("1", "Beranda", Model_Menu.MenuType.MENU));
    listMenu1.addItem(new Model_Menu("2", "Kamar", Model_Menu.MenuType.MENU));
    listMenu1.addItem(new Model_Menu("3", "Profil", Model_Menu.MenuType.MENU));
    listMenu1.addItem(new Model_Menu("4", "Keuangan", Model_Menu.MenuType.MENU));
    listMenu1.addItem(new Model_Menu("5", "Transaksi", Model_Menu.MenuType.MENU));
    listMenu1.addItem(new Model_Menu("6", "Riwayat Transaksi", Model_Menu.MenuType.MENU));
    listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
//    listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
//    listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));

    listMenu1.addItem(new Model_Menu("7", "Keluar", Model_Menu.MenuType.MENU));
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.swing.ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/logo (100px).png"))); // NOI18N

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
         Graphics2D g2=(Graphics2D)grphcs ;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#F96D9A"), 0, getHeight(), Color.decode("#DE51B7"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0,getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs); 
        
    }
    
    private int x;
    private int y;
    
public void initMoving(JFrame fram){
    panelMoving.addMouseListener(new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent me) {
           x = me.getX();
           y = me.getY();
        }
    
});
    panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent me) {
           fram.setLocation(me.getXOnScreen()-x, me.getYOnScreen()-y);
        }
        
    });
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
