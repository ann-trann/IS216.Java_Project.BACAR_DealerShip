package com.view.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

public class TableHeader extends JLabel {
    public TableHeader(String text){
        super.setText(text);
        setOpaque(true);
        setFont(new Font("sansserif", 1, 12));
        setForeground(Color.decode("#5E4421"));

        setBackground(new Color(251, 238, 215));
   
    }
    

}
