/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.emplois_du_temps;

import com.l3.info.magenda.dao.Examen;

/**
 *
 * @author tstegen
 */
public class Horaire {
    private int ligne = 0;
    private int colonne = 0;
    private double plage_horraire = 0;
    private Examen examen;
   
       
    public Horaire (int ligne, int colonne, Examen examen){
            this.ligne = ligne;
            this.colonne = colonne;
            this.plage_horraire = (examen.getTime()/30);		
            this.examen = examen;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public double getPlage_horraire() {
        return plage_horraire;
    }

    public void setPlage_horraire(double plage_horraire) {
        this.plage_horraire = plage_horraire;
    }

    public Examen getExamen() {
        return this.examen;
    }
    
    @Override
    public String toString() {
        return examen.description();
    }
    
}
