/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.interface_java;

import com.l3.info.magenda.dao.Examen;
import java.util.Vector;

/**
 *
 * @author tstegen
 */
public class TableModelMatieres extends javax.swing.table.AbstractTableModel {
    String[] header = {"Intitule","Commenaire"};
    Vector<Examen> liste = new Vector();
    
    @Override
    public int getRowCount() {
        return liste.size(); 
    }

    @Override
    public int getColumnCount() {
       return header.length;
    }

    @Override
    public String getColumnName(int column) {        
        return header[column];    
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Examen e = liste.get(rowIndex);
        if(columnIndex == 0){
            return e.getIntitule();
        }
        if(columnIndex == 1){
            return e.getCommentaire();         
        }
        return null;
    }
    
    public void setListe(Vector<Examen> liste){
        this.liste.clear();
        for(Examen examen : liste) {
            this.add(examen);
        }
    }
    
    /**
     * Recupere les examens selectionnés
     * @param index_selectionnes Tableau des index à récupérer
     * @return Vecteur contenant les examens voulus
     */
    public Vector<Examen> RecupererExamenSelectionner(int[] index_selectionnes){
        Vector<Examen> examens_selectionnes = new Vector<>();
        for(int index : index_selectionnes) examens_selectionnes.add(this.liste.get(index));
        return examens_selectionnes;
    }
    
    public void add(Examen examen){
        int old_size = this.liste.size();
        this.liste.add(examen);
        fireTableRowsInserted(old_size, this.liste.size());
    }
}
