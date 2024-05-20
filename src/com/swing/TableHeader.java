
package com.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    public TableHeader(String text) {
    super(text);
        setOpaque(true); 
        setBackground(Color.WHITE);
        setFont(new Font("montserrat bold", 1, 11));
        setForeground(new Color(80, 80, 80));
        setBorder(new EmptyBorder(10,10, 10, 10));
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(230, 230, 230));
        g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
    }
    
    
}
