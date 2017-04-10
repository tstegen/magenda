/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.emplois_du_temps;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author thomas
 */
public class Workbook {
        XSSFWorkbook workbook;
        HashMap<String,XSSFCellStyle> liste_des_styles;
         
        public void write(OutputStream stream) throws IOException{
            workbook.write(stream);
        }
        
        public Workbook (){
             workbook = new XSSFWorkbook();
             initialiserPalettedestyle(workbook);
        }
        
        public void initialiserPalettedestyle(XSSFWorkbook workbook){
        liste_des_styles = new HashMap<>();
        XSSFCellStyle style  = (XSSFCellStyle) workbook.createCellStyle();
        
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        liste_des_styles.put("nom_du_jour", style);
        style  = (XSSFCellStyle) workbook.createCellStyle();
        
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(BorderStyle.DASHED);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        
        liste_des_styles.put("case_gauche_jour", style);
        style  = (XSSFCellStyle) workbook.createCellStyle();
        
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderLeft(BorderStyle.DASHED);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        liste_des_styles.put("case_droite_jour", style);
    }
   
    public void addCellStyle(String nom, Categorie cat){
        XSSFCellStyle style  = (XSSFCellStyle) workbook.createCellStyle();
        XSSFColor border =  new XSSFColor(cat.getBorder());
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(border);

        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(border);

        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(border);

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(border);
        
        style.setWrapText(true);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(new XSSFColor(cat.getBackground()));
        
        XSSFFont font = workbook.createFont();
        font.setColor(new XSSFColor(cat.getForeground()));
        style.setFont(font);
        
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        liste_des_styles.put("Style_"+nom, style);

    }
    
    public void addCellStyle(Map<String,Categorie> couleur_des_filières){
        couleur_des_filières.forEach((k,v)-> addCellStyle(k,v));
    }
    
    public XSSFWorkbook getWorkbook(){
        return this.workbook;
    }
        
    public XSSFCellStyle getCellStyle(String nom_du_style){
        return liste_des_styles.get(nom_du_style);
    }
    
    public static short PixelsToTwips (int pixels){
        return (short) (pixels*15);
    }
    
    public static float TwipsToPixels (int twips){
        return twips/15;
    }
}
