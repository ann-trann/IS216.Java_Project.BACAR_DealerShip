
package com.model;

import javax.swing.Icon;

public class ModelMenu {
    private String menuName;
    private Icon icon;

    public ModelMenu() {
    }

    public ModelMenu(String menuName) {
        this.menuName = menuName;
    }

    public ModelMenu(Icon icon, String menuName) {
        this.menuName = menuName;
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
}
