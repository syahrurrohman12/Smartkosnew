
package com.model;

import javax.swing.Icon;


public class Model_Kamar {

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the values
     */
    public String getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(String values) {
        this.values = values;
    }

    public Model_Kamar() {
    }

    public Model_Kamar(Icon icon, String title, String values) {
        this.icon = icon;
        this.title = title;
        this.values = values;
    }
    

        private Icon icon;
        private String title;
        private String values;
    
}
