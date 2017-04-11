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
    Vector<Examen> liste = new Vector();
    
    @Override
    public int getRowCount() {
        return liste.size(); 
    }

    @Override
    public int getColumnCount() {
       return 2;
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
        this.liste = liste;
        fireTableDataChanged();
    }
    
}
