/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.emplois_du_temps;

import com.itextpdf.kernel.geom.Rectangle;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.apache.commons.collections4.map.HashedMap;
import com.l3.info.magenda.dao.Examen;
import java.awt.Component;
import java.io.File;
import javax.swing.text.Document;

/**
 *
 * @author thomas
 */
public class EmploisDuTemps extends JTabbedPane implements Printable, Serializable{
    
    List<Integer> key = new ArrayList<>();
    List<Semaine> value = new ArrayList<>();
    Vector<Examen> donneesAffichees = new Vector<>();
    Map<String,Categorie> Couleur_des_filières = new HashedMap<String, Categorie>();
    
    public EmploisDuTemps() {
        super();
        this.setTabPlacement(JTabbedPane.LEFT);
    }

    public EmploisDuTemps(int arg0) {
        super(arg0);
    }

    public EmploisDuTemps(int arg0, int arg1) {
        super(arg0, arg1);
    }
    
    public void addExamen (Examen examen) {
        Integer numero_de_semaine = examen.getDeb().get(Calendar.WEEK_OF_YEAR);
        Semaine week = null;
        if(!key.contains(numero_de_semaine))  {
            JScrollPane scrollpane = new JScrollPane();
            week = new Semaine(numero_de_semaine, Couleur_des_filières);
            key.add(numero_de_semaine);
            value.add(week);
            
            scrollpane.setViewportView(getSemaine(numero_de_semaine));
            scrollpane.getVerticalScrollBar().setUnitIncrement(10);
            this.addTab("S. " + Integer.toString(numero_de_semaine), scrollpane);
        }
        else  {
            week = getSemaine(numero_de_semaine);
        }
        donneesAffichees.add(examen);
        week.addExamen(examen);
        week.update_size();
        week.repaint();
        
    }
    
    public void addExamen (Examen [] list_des_examens) {
        for(Examen examen : list_des_examens) this.addExamen(examen);
    }

    public void addExamen (Vector<Examen> list_des_examens) {
        for(Examen examen : list_des_examens) this.addExamen(examen);
    }
    
    public void addFiliere(String key){
        if(!Couleur_des_filières.containsKey(key)){
            Couleur_des_filières.put(key, new Categorie());
        }
    }
    
    public void addFiliere(Vector<String> liste_des_cles){
        for(String key : liste_des_cles){
            this.addFiliere(key);
        }
    }
    
    public void addFiliere(String liste_des_cles[]){
        for(String key : liste_des_cles){
            this.addFiliere(key);
        }
    }
    
    private Semaine getSemaine(int numero_de_semaine){
        return value.get(key.indexOf(numero_de_semaine));
    }
    
    public Vector<Examen> getDonneesAffichees (){
        return donneesAffichees;
    }
    
    public Examen[] getTableauDonnees (){
        return donneesAffichees.toArray(new Examen[donneesAffichees.size()]);
    }

    @Override
    public void removeAll() {
        super.removeAll();
        key.clear();
        value.clear();
        donneesAffichees.clear();
    }

    public void writeInWorkbook (String path) throws FileNotFoundException, IOException {
        Workbook workbook = new Workbook();
        workbook.addCellStyle(Couleur_des_filières);
        // Récupérer l'ensemble des clés de la liste
        for(int i=0; i<value.size(); i++){
            value.get(i).writeInSheet(workbook, i);
        }
        
        FileOutputStream fileOut;
        
        fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close(); 

    }
    
    public void writeInPdf (String path) throws FileNotFoundException {
        
        File file = new File(path);
        file.getParentFile().mkdirs();
        //new FullDottedLine().manipulatePdf(path);
       
        com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(new com.itextpdf.kernel.pdf.PdfWriter(path));
        
        // Taille feuille A4 mode paysage (842, 595)
        com.itextpdf.kernel.geom.PageSize pageSize = new com.itextpdf.kernel.geom.PageSize(842, 595);
        pdfDoc.setDefaultPageSize(pageSize);
        
        java.awt.Dimension taille_totale_semaine = getSemaine(48).getSize();
        int hauteur_panel_semaine = getSemaine(48).getSize().height;
        int largeur_panel_semaine = getSemaine(48).getSize().width;
        
        double nbPages = Math.floor((hauteur_panel_semaine / pageSize.getHeight()))+1;
        System.out.println("taille sem 48 : " + taille_totale_semaine);
        System.out.println("Hauteur sem 48 : " + hauteur_panel_semaine);
        System.out.println("Largeur sem 48 : " + largeur_panel_semaine);
        System.out.println("nombre de pages : " + nbPages);
        com.itextpdf.kernel.pdf.canvas.PdfCanvas canvas;
        
        // Création des pages
        for(int i=0; i < nbPages; i++){
            canvas = new com.itextpdf.kernel.pdf.canvas.PdfCanvas(pdfDoc.addNewPage());
            Component[] comp = getSemaine(48).getComponents();
           
            /*for (float x = 0; x < pageSize.getWidth(); ) {
                for (float y = 0; y < pageSize.getHeight(); ) {
                    canvas.circle(x, y, 1f);
                    y += 72f;
                }
                x += 72f;
            }*/
            
            
            canvas.fill();
        }
        pdfDoc.close();
    
        
        
        
 /*        File file = new File(path);
        file.getParentFile().mkdirs();
        //Initialize PDF writer
        com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(path);
        //Initialize PDF document
        com.itextpdf.kernel.pdf.PdfDocument pdf = new com.itextpdf.kernel.pdf.PdfDocument(writer);
        com.itextpdf.kernel.pdf.PdfPage page = pdf.addNewPage();

        com.itextpdf.kernel.pdf.PdfArray lineEndings = new com.itextpdf.kernel.pdf.PdfArray();
        lineEndings.add(new com.itextpdf.kernel.pdf.PdfName("Diamond"));
        lineEndings.add(new com.itextpdf.kernel.pdf.PdfName("Diamond"));
 
        //Create line annotation with inside caption
        com.itextpdf.kernel.pdf.annot.PdfAnnotation annotation = new com.itextpdf.kernel.pdf.annot.PdfLineAnnotation(
            new com.itextpdf.kernel.geom.Rectangle(0, 0),
            new float[]{20, 790, page.getPageSize().getWidth() - 20, 790})
                .setLineEndingStyles((lineEndings))
                .setContentsAsCaption(true)
                .setTitle(new com.itextpdf.kernel.pdf.PdfString("iText"))
                .setContents("The example of line annotation")
                .setColor(com.itextpdf.kernel.color.Color.BLUE);
        page.addAnnotation(annotation);

        //Close document
        pdf.close();
 */
    }
        
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // Par défaut, retourne NO_SUCH_PAGE => la page n'existe pas
        int code_retour = Printable.NO_SUCH_PAGE;
        System.out.println(pageIndex);
        // Récupérer l'ensemble des clés de la liste
        for(Semaine sem : value){
            //sem.get_nbr_page();
        }
        if(value.size() > pageIndex){
            value.get(pageIndex).paint(graphics);
            // La page est valide
            code_retour = Printable.PAGE_EXISTS;
        }
        // Récupère la dimension de la zone imprimable
        //double xLeft  = pageFormat.getImageableX();
        //double yTop   = pageFormat.getImageableY();
        //double width  = pageFormat.getImageableWidth();
        //double height = pageFormat.getImageableHeight();
        
        return code_retour;
    }
    
}
