/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.emplois_du_temps;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author tstegen
 */
public class Categorie {
    Color background;
    Color foreground;
    Color border;
    
    public Categorie(){
        Random random = new Random();
        float couleur_de_base = random.nextFloat();
        this.background = Color.getHSBColor(couleur_de_base,0.5f,0.8f);
        this.foreground = new Color(couleur_de_base,0.2f,0.2f);
        this.border = Color.getHSBColor(couleur_de_base,0.5f,0.3f);
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }
    
    public Color getBackground() {
        return background;
    }

    public Color getForeground() {
        return foreground;
    }

    public Color getBorder() {
        return border;
    }

    public void setBorder(Color border) {
        this.border = border;
    }
    
}
