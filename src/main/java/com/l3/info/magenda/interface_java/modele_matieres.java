/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.interface_java;
import com.l3.info.magenda.dao.Examen;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tstegen
 */
public class modele_matieres extends AbstractTableModel {
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
        System.out.println("teste");
        for(Examen examen : liste) {
            System.out.println(examen.description());
            this.add(examen);
        }
    }
    
    public void add(Examen examen){
        int old_size = this.liste.size();
        this.liste.add(examen);
        fireTableRowsInserted(old_size, this.liste.size());
    }
}
