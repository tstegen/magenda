/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.emplois_du_temps;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;
import com.l3.info.magenda.dao.Examen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;


/**
 *
 * @author thomas
 */
public class Jour {
    public static final int LARGEUR_CELLULE = 64;
    public static final int HAUTEUR_CELLULE = LARGEUR_CELLULE;
       
    private final int END_HOUR_OF_DAY = 20;
    private final int START_HOUR_OF_DAY = 7;
    private final int HALF_HOUR_OF_DAY = (END_HOUR_OF_DAY-START_HOUR_OF_DAY)*2 + 1;
    
    // parametres pour le nom
    private final String nom_jour;
    private String date_jour;
    
    // parametres pour les examens
    private Vector<Boolean[]> plages_horaire_occupees;
    private Vector<Horaire> horaire_du_jour;
    
    private Map<String,Categorie> cat;
    
    public Jour(int num_jour, Map<String,Categorie> cat) {
        String[] tab_jour = {"Lundi","Mardi","Mercredi", "Jeudi", "Vendredi", "Samedi","Dimanche"};
        this.nom_jour = tab_jour[num_jour];
        this.cat = cat;
        initComponents();
    }
    
    private void initComponents (){
        // tableau des lignes utilis�es pour les examens
        plages_horaire_occupees = new Vector<>(); // BOOLEAN[][]
        horaire_du_jour = new Vector<>();
        // le minimimum de ligne pour un jour
        for(int i=0; i<2; i++) ajouterPlageHorraire();
    }
    
    public int getNbrLigne() {
        return this.plages_horaire_occupees.size();
    }
    
    public Boolean examExist(Examen examen){
        for(Horaire horaire : horaire_du_jour){
            if(horaire.getExamen().equals(examen)){
                return true;
            }
        }
        return false;
    }
    
    public Boolean plageHoraireUtilise(int ligne, int debut, int fin){
        // On parcourt les cases requises par l'examen.
        // Si start_col = 10 et end_col 12 > i=10 i=11 i=12 > on sort si i � 13 ou si une case est utilis�e
        for( int i=debut; i<fin; i++){
            if(plages_horaire_occupees.get(ligne)[i]){
                return true;
            }
        } // for(int i=start_col; i<=end_col; i++)
        return false;
    }
    
    public void ajouterPlageHorraire(){
        plages_horaire_occupees.add(new Boolean [HALF_HOUR_OF_DAY]);
        Arrays.fill(plages_horaire_occupees.get(plages_horaire_occupees.size()-1), Boolean.FALSE);
    }
    
    public Boolean addExamen (Examen examen) {
        int ligne=0;
        Boolean verif = true;
        // Num�ro de la colonne repr�sentant le d�but de l'examen 
        int start_col = (int) ((examen.getStartHour() - START_HOUR_OF_DAY * 60) /30);
        // Num�ro de la colonne repr�sentant la fin de l'examen 
        int end_col = (int) ((examen.getEndHour() - START_HOUR_OF_DAY * 60) /30);
        //Si l'examen est déjà présent on retourne false
        if( examExist(examen) ) return false;
        // Tant que l'on a pas d�pass� le nombre de ligne cr��e et que les cases sont occup�es.
        for(; ligne < plages_horaire_occupees.size(); ligne ++){
            //la plage horaire est-elle déjà utilisée?
            if((verif = plageHoraireUtilise(ligne, start_col, end_col)) == false){
                break;
            }
        } // while(line < used_lines.size() && verif)
        if( verif ) ajouterPlageHorraire();
        
        for(int i=start_col; i<end_col; i++){
            plages_horaire_occupees.get(ligne)[i] = true;
        } // for(int i=start_col; i<=end_col; i++)

        horaire_du_jour.add(new Horaire(ligne,start_col,examen));
        return true;
    }
    	
    void writeInSheet(Workbook workbook, Sheet sheet, int x_sem, int y_sem) {
        Row[] row = new Row[1+this.getNbrLigne()];
        row[0] = sheet.createRow(y_sem);
        for(int i=1; i<1+this.getNbrLigne(); i++){
            row[i] = sheet.createRow(y_sem+i);
            row[i].setHeight(Workbook.PixelsToTwips(64));
        }
        
        int x = x_sem, y = 0;
        Cell cell = row[y].createCell(x);
        cell.setCellValue(this.nom_jour);
        cell.setCellStyle(workbook.getCellStyle("nom_du_jour"));
        x ++;
        for(int i=START_HOUR_OF_DAY; i<=END_HOUR_OF_DAY; i++){
            cell = row[y].createCell(x);
            cell.setCellValue(i + "h");
            cell.setCellStyle(workbook.getCellStyle("case_gauche_jour"));
            cell = row[y].createCell(x+1);
            cell.setCellStyle(workbook.getCellStyle("case_droite_jour"));
            x += 2;
        }
                
        for(int i=1; i<=this.getNbrLigne(); i++){
           x=x_sem+1;
           for(int j=(END_HOUR_OF_DAY-START_HOUR_OF_DAY+1) ; j>0; j--){
                cell = row[i].createCell(x);
                cell.setCellStyle(workbook.getCellStyle("case_gauche_jour"));
                cell = row[i].createCell(x+1);
                cell.setCellStyle(workbook.getCellStyle("case_droite_jour"));
                x += 2;
           }
        }
        
        x = x_sem; y = y_sem;
        
        
        for(int i=1; i<=this.getNbrLigne(); i++){
            cell = row[i].createCell(x);
            cell.setCellStyle(workbook.getCellStyle("nom_du_jour"));
        }
        sheet.addMergedRegion(new CellRangeAddress( y+1, y+getNbrLigne(), x ,x));
        
        x = x_sem+1; y = y_sem+1;
        for(Horaire h :horaire_du_jour){
            cell = row[1+h.getLigne()].createCell((x+h.getColonne()));
            cell.setCellValue(h.toString());
            cell.setCellStyle(workbook.getCellStyle("Style_"+ h.getExamen().getDiplome()));
            for(int i=1; i<h.getPlage_horraire();i++){
                cell = row[1+h.getLigne()].createCell((x+h.getColonne()+i));
                cell.setCellStyle(workbook.getCellStyle("Style_"+ h.getExamen().getDiplome()));                
            }

            if(h.getPlage_horraire()>1){
                sheet.addMergedRegion(new CellRangeAddress( y+h.getLigne(), (y+h.getLigne()), (x+h.getColonne()), (int) (x+h.getColonne()+h.getPlage_horraire()-1)));
            }
        }

    }
    
    public BufferedImage createImage() {
        int w = LARGEUR_CELLULE * (HALF_HOUR_OF_DAY+1);
        int h = 20 + HAUTEUR_CELLULE * getNbrLigne();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        
        this.paint(g, 0, 0, this.cat);
        
        return bi;
    }
    
    public void paint(Graphics g, int x_sem, int y_sem, Map<String,Categorie> cat){

        int x = x_sem, y = y_sem;
        Graphics2D g2d = (Graphics2D) g;
        
        float tab[] = {.5f,.5f};
        BasicStroke pointille = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, tab, .10f);
        BasicStroke normal = (BasicStroke) g2d.getStroke();
        
        g2d.drawRect(x, y, LARGEUR_CELLULE, 20);
        UI.drawCenteredString(g2d, this.nom_jour, UI.TEXT_TO_CENTER, x, y, LARGEUR_CELLULE, 20);

        x += LARGEUR_CELLULE;
        for(int i=START_HOUR_OF_DAY; i<=END_HOUR_OF_DAY; i++){
                //dessinde la case de l'heure
                g2d.drawRect(x, y, LARGEUR_CELLULE*2, 20);
                g2d.drawLine(x+LARGEUR_CELLULE*2, y+17, x+LARGEUR_CELLULE*2, y+20);
                UI.drawCenteredString(g, i + "h", UI.TEXT_TO_LEFT, x, y, LARGEUR_CELLULE, 20);			
                x += LARGEUR_CELLULE*2;

        }
        //dessin des barres verticales
        x=x_sem;
        y = y_sem+20;
        g2d.drawLine(x, y, x, y+this.getNbrLigne()*HAUTEUR_CELLULE);
        x+=LARGEUR_CELLULE;
        for(int i= (END_HOUR_OF_DAY-START_HOUR_OF_DAY)*2+3; i>0; i--){
                g2d.setStroke((i%2 == 0)?pointille:normal);
                g2d.drawLine(x, y, x, y+this.getNbrLigne()*HAUTEUR_CELLULE);
                x += LARGEUR_CELLULE;
        }
        g2d.setStroke(normal);
        //dessin des barres horizontales
        x=x_sem;
        y=y_sem+20+this.getNbrLigne()*HAUTEUR_CELLULE;
        g2d.drawLine(x, y, x+LARGEUR_CELLULE+(END_HOUR_OF_DAY-START_HOUR_OF_DAY+1)*(LARGEUR_CELLULE*2), y);
        for(int i=0; i<this.getNbrLigne(); i++){
                y = y_sem+20+i*HAUTEUR_CELLULE;
                g2d.drawLine(x+LARGEUR_CELLULE, y, x+LARGEUR_CELLULE+(END_HOUR_OF_DAY-START_HOUR_OF_DAY+1)*(LARGEUR_CELLULE*2), y);
        }
        
        int width;
        x = x_sem+LARGEUR_CELLULE; y = y_sem+20;
        for(Horaire h :horaire_du_jour){
            g2d.setColor(cat.get(h.getExamen().getDiplome()).getBackground());
            width = (int) (h.getPlage_horraire()*LARGEUR_CELLULE);
            
            g2d.fillRect(x+h.getColonne()*LARGEUR_CELLULE, y+h.getLigne()*HAUTEUR_CELLULE, width, HAUTEUR_CELLULE);
            
            g2d.setColor(cat.get(h.getExamen().getDiplome()).getBorder());
            g2d.drawRect(x+h.getColonne()*LARGEUR_CELLULE, y+h.getLigne()*HAUTEUR_CELLULE, width, HAUTEUR_CELLULE);
            
            g2d.setColor(cat.get(h.getExamen().getDiplome()).getForeground());          
            UI.DrawString(g, h.getExamen().description(), x+h.getColonne()*LARGEUR_CELLULE, y+h.getLigne()*HAUTEUR_CELLULE, width, HAUTEUR_CELLULE);	
            g2d.setColor(Color.black);
        }
    }
    
}
