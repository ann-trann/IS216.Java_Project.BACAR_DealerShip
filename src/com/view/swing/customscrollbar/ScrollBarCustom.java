package com.view.swing.customscrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(Color.decode("#C3AD8F"));
        setUnitIncrement(20);
        setOpaque(false);
    }
}