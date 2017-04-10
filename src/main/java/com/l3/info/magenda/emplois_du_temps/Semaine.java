/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.emplois_du_temps;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Map;
import javax.swing.JPanel;
import com.l3.info.magenda.dao.Examen;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author thomas
 */
public class Semaine extends JPanel {
    
    private final int NB_DAY = 6, num_semaine;
    Jour days_of_week [] = new Jour[NB_DAY];
    Map<String,Categorie> cat;
    Dimension dim = new Dimension();
  
    
    public Semaine(int num_semaine,  Map<String,Categorie> cat) {
        super();
        this.cat = cat;
        this.num_semaine = num_semaine;
        super.setBackground(new java.awt.Color(245,245,245));
        for(int i=0; i<NB_DAY; i++) days_of_week[i] = new Jour(i);    
    }
        
    public Boolean addExamen (Examen examen) {
        return days_of_week[examen.getDeb().get(Calendar.DAY_OF_WEEK)-2].addExamen(examen);
    }

    public void update_size(){
        int y=20,x=40+29*Jour.LONGUEUR_DES_CELLULES;
        
        for(Jour day : days_of_week) {
            y += 40 + day.getNbrLigne()*Jour.HAUTEUR_DES_CELLULES;
        }
        
        dim.setSize(new Dimension(x, y));
        super.setPreferredSize(dim);
    }
    
    /*public Examen getExamenAffiche(){
        return week.getExamenAffiche();
    }*/
    
    void writeInSheet(Workbook workbook, int week_of_year) {
        XSSFWorkbook xssfWorkbook = workbook.getWorkbook();
        Sheet sheet = xssfWorkbook.createSheet("Sem. " + week_of_year);
        Row row = sheet.createRow((short) 0);
        
        row.setHeight(Workbook.PixelsToTwips(64));
        Cell cell = row.createCell((short) 0);
        // first row (0-based) - last row  (0-based) - first column (0-based) -last column  (0-based)
        sheet.addMergedRegion(new CellRangeAddress( 0, 0, 0, (20-7)*2+2 ));

        // Cr�e une nouvelle police
        Font font = xssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 18);
        font.setFontName("Arial");

        // Fonts are set into a style so create a new one to use.
        XSSFCellStyle style = xssfWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        // Create a cell and put a value in it.
        cell.setCellValue("Semaine "+ this.num_semaine);
        cell.setCellStyle(style);

        sheet.setDefaultRowHeight((short) 500);

        int x=0,y=2;
        for(Jour day : days_of_week) {
            day.writeInSheet(workbook,sheet, x, y);
            y += 2+day.getNbrLigne();
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int x=20,y=20;
        for(Jour day : days_of_week) {
            day.paint(g, x, y, this.cat);
            y += 40 + day.getNbrLigne()*Jour.HAUTEUR_DES_CELLULES;
        }
    }
    
    /*public int print(Graphics g, PageFormat pageFormat, int pageIndex){
        int x=20,y=20;
        for(Jour day : days_of_week) {
            day.paint(g, x, y, this.cat);
            y += 40 + day.getNbrLigne()*Jour.HAUTEUR_DES_CELLULES;
        }
    }*/
    

    public int get_nbr_page(int width, int height) {
        return width;
    }
	
}
