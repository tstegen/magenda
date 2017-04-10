/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda;

import com.l3.info.magenda.dao.DaoExamenCsv;
import com.l3.info.magenda.dao.Examen;
import com.l3.info.magenda.data.MediaManager;
import com.l3.info.magenda.interface_java.MyComboBoxModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Vector;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author tstegen
 */
public class interface_principale extends javax.swing.JFrame {

    Vector<Examen> baseDeDonnees = new Vector<>();
    MediaManager mediaManger = new MediaManager();
    String PATH_FOLDER_DATA = "";
    DaoExamenCsv base_de_donnees;
    String nomDeFichier;
    /**
     * Creates new form interface_principale
     */
    public interface_principale() {
        super();
        initComponents(); 
        initialisationDesDonnees();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        affichagePan = new javax.swing.JPanel();
        basPan = new javax.swing.JPanel();
        paramsPan = new javax.swing.JPanel();
        hiddenPan = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        ajoutSuppPan = new javax.swing.JPanel();
        selectionPan = new javax.swing.JPanel();
        GradePan = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        arrPlanFilPan1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        filierePan = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        arrPlanFilPan2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        anneePan = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        arrPlanFilPan = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        semainePan = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        arrPlanSemPan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        boutonPan = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        barre_de_menu = new javax.swing.JMenuBar();
        menu_fichier = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuOuvrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEnregistrer = new javax.swing.JMenuItem();
        menuEnregistrerSous = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuQuitter = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_rafraichir = new javax.swing.JMenuItem();
        menu_aide = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magenda");
        setPreferredSize(new java.awt.Dimension(800, 700));

        affichagePan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        affichagePan.setPreferredSize(new java.awt.Dimension(400, 274));
        affichagePan.setLayout(new java.awt.BorderLayout());

        emploisDuTemps = new com.l3.info.magenda.emplois_du_temps.EmploisDuTemps();
        affichagePan.add(emploisDuTemps, java.awt.BorderLayout.CENTER);

        getContentPane().add(affichagePan, java.awt.BorderLayout.CENTER);

        basPan.setMaximumSize(new java.awt.Dimension(32767, 100));
        basPan.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout basPanLayout = new javax.swing.GroupLayout(basPan);
        basPan.setLayout(basPanLayout);
        basPanLayout.setHorizontalGroup(
            basPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        basPanLayout.setVerticalGroup(
            basPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(basPan, java.awt.BorderLayout.SOUTH);

        paramsPan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        paramsPan.setMinimumSize(new java.awt.Dimension(270, 200));
        paramsPan.setPreferredSize(new java.awt.Dimension(240, 200));
        paramsPan.setLayout(new java.awt.BorderLayout());

        hiddenPan.setFocusCycleRoot(true);
        hiddenPan.setPreferredSize(new java.awt.Dimension(15, 497));
        hiddenPan.setLayout(new java.awt.GridLayout(1, 0));

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.setPreferredSize(new java.awt.Dimension(105, 20));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        hiddenPan.add(jToggleButton1);

        paramsPan.add(hiddenPan, java.awt.BorderLayout.WEST);

        ajoutSuppPan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ajoutSuppPan.setPreferredSize(new java.awt.Dimension(240, 750));
        ajoutSuppPan.setLayout(new java.awt.BorderLayout());

        selectionPan.setBackground(new java.awt.Color(232, 233, 239));
        selectionPan.setMinimumSize(new java.awt.Dimension(200, 215));
        selectionPan.setPreferredSize(new java.awt.Dimension(200, 215));
        selectionPan.setLayout(new javax.swing.BoxLayout(selectionPan, javax.swing.BoxLayout.Y_AXIS));

        GradePan.setMaximumSize(new java.awt.Dimension(300, 200));
        GradePan.setOpaque(false);
        GradePan.setPreferredSize(new java.awt.Dimension(200, 100));

        jComboBoxModel1 = new MyComboBoxModel();
        jComboBox2.setModel(this.jComboBoxModel1);
        jComboBox2.setMaximumSize(new java.awt.Dimension(40, 30));
        jComboBox2.setName("Tous");
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        arrPlanFilPan1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("    Grade :");
        arrPlanFilPan1.add(jLabel6);

        javax.swing.GroupLayout GradePanLayout = new javax.swing.GroupLayout(GradePan);
        GradePan.setLayout(GradePanLayout);
        GradePanLayout.setHorizontalGroup(
            GradePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GradePanLayout.createSequentialGroup()
                .addGroup(GradePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arrPlanFilPan1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GradePanLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        GradePanLayout.setVerticalGroup(
            GradePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GradePanLayout.createSequentialGroup()
                .addComponent(arrPlanFilPan1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectionPan.add(GradePan);

        filierePan.setMaximumSize(new java.awt.Dimension(300, 200));
        filierePan.setOpaque(false);
        filierePan.setPreferredSize(new java.awt.Dimension(200, 100));

        jComboBoxModel = new MyComboBoxModel();
        jComboBox3.setModel(this.jComboBoxModel);
        jComboBox3.setMaximumSize(new java.awt.Dimension(40, 30));
        jComboBox3.setName("Tous");
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        arrPlanFilPan2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("    Filière :");
        arrPlanFilPan2.add(jLabel7);

        javax.swing.GroupLayout filierePanLayout = new javax.swing.GroupLayout(filierePan);
        filierePan.setLayout(filierePanLayout);
        filierePanLayout.setHorizontalGroup(
            filierePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filierePanLayout.createSequentialGroup()
                .addGroup(filierePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arrPlanFilPan2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(filierePanLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        filierePanLayout.setVerticalGroup(
            filierePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filierePanLayout.createSequentialGroup()
                .addComponent(arrPlanFilPan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectionPan.add(filierePan);

        anneePan.setMaximumSize(new java.awt.Dimension(300, 200));
        anneePan.setOpaque(false);
        anneePan.setPreferredSize(new java.awt.Dimension(200, 100));

        jComboBoxModel3 = new MyComboBoxModel();
        jComboBox1.setModel(jComboBoxModel3);
        jComboBox1.setMaximumSize(new java.awt.Dimension(40, 30));
        jComboBox1.setName("Tous");

        arrPlanFilPan.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("    Semestre :");
        arrPlanFilPan.add(jLabel5);

        javax.swing.GroupLayout anneePanLayout = new javax.swing.GroupLayout(anneePan);
        anneePan.setLayout(anneePanLayout);
        anneePanLayout.setHorizontalGroup(
            anneePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anneePanLayout.createSequentialGroup()
                .addGroup(anneePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arrPlanFilPan, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(anneePanLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        anneePanLayout.setVerticalGroup(
            anneePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anneePanLayout.createSequentialGroup()
                .addComponent(arrPlanFilPan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectionPan.add(anneePan);

        semainePan.setMinimumSize(new java.awt.Dimension(200, 110));
        semainePan.setOpaque(false);
        semainePan.setPreferredSize(new java.awt.Dimension(315, 120));

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField1.setText("1");
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(18, 20));

        jLabel3.setText("à");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField2.setText("52");

        arrPlanSemPan.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setBackground(new java.awt.Color(200, 200, 200));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("     Semaine :");
        arrPlanSemPan.add(jLabel4);

        javax.swing.GroupLayout semainePanLayout = new javax.swing.GroupLayout(semainePan);
        semainePan.setLayout(semainePanLayout);
        semainePanLayout.setHorizontalGroup(
            semainePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semainePanLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
            .addComponent(arrPlanSemPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        semainePanLayout.setVerticalGroup(
            semainePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semainePanLayout.createSequentialGroup()
                .addComponent(arrPlanSemPan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(semainePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        selectionPan.add(semainePan);

        ajoutSuppPan.add(selectionPan, java.awt.BorderLayout.CENTER);

        boutonPan.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ajouterActionPerformed(evt);
            }
        });
        boutonPan.add(jButton1);

        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        boutonPan.add(jButton2);

        ajoutSuppPan.add(boutonPan, java.awt.BorderLayout.SOUTH);

        paramsPan.add(ajoutSuppPan, java.awt.BorderLayout.CENTER);

        getContentPane().add(paramsPan, java.awt.BorderLayout.EAST);

        menu_fichier.setText("Fichier");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Nouveau");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_fichier.add(jMenuItem1);

        menuOuvrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOuvrir.setText("Ouvrir...");
        menuOuvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOuvrirActionPerformed(evt);
            }
        });
        menu_fichier.add(menuOuvrir);
        menu_fichier.add(jSeparator1);

        menuEnregistrer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuEnregistrer.setText("Enregistrer");
        menuEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEnregistrerActionPerformed(evt);
            }
        });
        menu_fichier.add(menuEnregistrer);

        menuEnregistrerSous.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuEnregistrerSous.setText("Enregistrer Sous...");
        menuEnregistrerSous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEnregistrerSousActionPerformed(evt);
            }
        });
        menu_fichier.add(menuEnregistrerSous);
        menu_fichier.add(jSeparator2);

        jMenu1.setText("Exporter");

        jMenuItem10.setText("Excel");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("PDF");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        menu_fichier.add(jMenu1);

        jMenuItem2.setText("Imprimer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_fichier.add(jMenuItem2);
        menu_fichier.add(jSeparator3);

        menuQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuQuitter.setText("Quitter");
        menuQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuitterActionPerformed(evt);
            }
        });
        menu_fichier.add(menuQuitter);

        barre_de_menu.add(menu_fichier);

        jMenu2.setText("Données");

        menu_rafraichir.setText("Mise à jour");
        menu_rafraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_rafraichirActionPerformed(evt);
            }
        });
        jMenu2.add(menu_rafraichir);

        barre_de_menu.add(jMenu2);

        menu_aide.setText("?");

        jMenuItem6.setText("À propos...");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu_aide.add(jMenuItem6);

        jMenuItem7.setText("Aide");
        menu_aide.add(jMenuItem7);

        barre_de_menu.add(menu_aide);

        setJMenuBar(barre_de_menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initialisationDesDonnees (){
        //File file = mediaManger.loadFile("database.csv");
        File file = new File("src\\main\\java\\com\\l3\\info\\magenda\\data\\database.csv");
        if(file.exists()){
            base_de_donnees = new DaoExamenCsv(file);
            
            for(String str : this.base_de_donnees.findGrade()){
                    jComboBox2.addItem(str);
            }
            
            Vector<String> listes_des_filieres = base_de_donnees.findDiplome();
            emploisDuTemps.addFiliere(listes_des_filieres);
            for(String filiere : listes_des_filieres){
                jComboBoxModel.addElement(filiere);
            } 
            
            for(String str : this.base_de_donnees.findAnnee()){
                    jComboBox1.addItem(str);
            }
        }

    }
    
    private void menu_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ajouterActionPerformed
        Vector<Examen> liste_des_examens;
        // Grade == tous
        if(((String) this.jComboBox2.getSelectedItem()).equalsIgnoreCase("tous")){
            if(((String) this.jComboBox3.getSelectedItem()).equalsIgnoreCase("tous")){ 
               if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                  liste_des_examens = this.base_de_donnees.findAll();   
               }
               else {
                   liste_des_examens = this.base_de_donnees.findParParSemestreEtSemaine((String) this.jComboBox1.getSelectedItem(),
                       Integer.parseInt(jFormattedTextField1.getText()),Integer.parseInt(jFormattedTextField2.getText()));            
               }
           }
           else{
               if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                   liste_des_examens = this.base_de_donnees.findByDiplomeAndWeek((String) this.jComboBox3.getSelectedItem(),
                       Integer.parseInt(jFormattedTextField1.getText()),Integer.parseInt(jFormattedTextField2.getText()));
               }
               else {
                   liste_des_examens = this.base_de_donnees.findParDiplomeParSemestreEtSemaine((String) this.jComboBox3.getSelectedItem(),(String) this.jComboBox1.getSelectedItem(),
                       Integer.parseInt(jFormattedTextField1.getText()),Integer.parseInt(jFormattedTextField2.getText()));            
               }
           }   
        } // S'il n'est pas égale à tous
        else{
            if(((String) this.jComboBox3.getSelectedItem()).equalsIgnoreCase("tous")){
                if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                    liste_des_examens = this.base_de_donnees.findByGrade(this.jComboBox2.getSelectedItem().toString());
               }
               else {
                    liste_des_examens = this.base_de_donnees.findParGradeParSemestre(this.jComboBox2.getSelectedItem().toString(),this.jComboBox1.getSelectedItem().toString(),
                            Integer.parseInt(jFormattedTextField1.getText()),Integer.parseInt(jFormattedTextField2.getText()));            
               }
            }
            else{
                if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                    liste_des_examens = this.base_de_donnees.findParGradeParDiplomeEtSemaine((String) this.jComboBox2.getSelectedItem(), (String) this.jComboBox3.getSelectedItem(),
                        Integer.parseInt(jFormattedTextField1.getText()),Integer.parseInt(jFormattedTextField2.getText()));
                }
                else {
                    liste_des_examens = this.base_de_donnees.findParGradeParDiplomeParSemestreEtSemaine((String) this.jComboBox2.getSelectedItem(),(String) this.jComboBox3.getSelectedItem(),(String) this.jComboBox1.getSelectedItem(),
                        Integer.parseInt(jFormattedTextField1.getText()),Integer.parseInt(jFormattedTextField2.getText()));            
                }
            }            
        }
        

        if(liste_des_examens != null){
            emploisDuTemps.addExamen(liste_des_examens);
        }
    }//GEN-LAST:event_menu_ajouterActionPerformed

    private void menuOuvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOuvrirActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Ouvrir");			
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            // Fichier cibl� par l'url
            File file = fileChooser.getSelectedFile();
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(new FileInputStream(file));
                Examen[] readObject = (Examen[])in.readObject();
                if(readObject != null){
                    this.emploisDuTemps.removeAll();
                    this.emploisDuTemps.addExamen(readObject);
                    nomDeFichier = file.getAbsolutePath();
                }
                in.close();
            } catch (IOException | ClassNotFoundException ex) {
                displayErrorMessage(ex.getMessage());
            } 

        } else {
            if(returnVal == JFileChooser.CANCEL_OPTION){
                displayErrorMessage("Open command cancelled by user.");                
            }
            else{
                displayErrorMessage("Ouverture impossible!");
            }
        }

    }//GEN-LAST:event_menuOuvrirActionPerformed

    private void menuEnregistrerSousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEnregistrerSousActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer sous");		
        int returnVal = fileChooser.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            nomDeFichier = file.getAbsolutePath(); 
        }
        // S'il y a un nom sélectionné 
        if(nomDeFichier != null) {
            ObjectOutputStream out;
            try {
                out = new ObjectOutputStream(new FileOutputStream(nomDeFichier, false));
                out.writeObject(this.emploisDuTemps.getTableauDonnees());
                out.close();
            } catch (IOException ex) {
                displayErrorMessage(ex.getMessage());
            }
        }
        // S'il y a pas de nom s�lectionn� (ERREUR)
        else {
            displayErrorMessage("Sauvergarde impossible!");
        }
    }//GEN-LAST:event_menuEnregistrerSousActionPerformed

    private void menuEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEnregistrerActionPerformed
        // S'il n'y a pas de nom sélectionné
        if(nomDeFichier == null) {  
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Enregistrer sous");
            int returnVal = fileChooser.showSaveDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    nomDeFichier = file.getAbsolutePath(); 
            }
        }
        // S'il y a un nom sélectionné
        if(nomDeFichier != null) {

            ObjectOutputStream out;
            try {
                out = new ObjectOutputStream(new FileOutputStream(nomDeFichier, false));
                out.writeObject(this.emploisDuTemps.getTableauDonnees());
                out.close();
            } 

            catch (IOException ex) {
                    displayErrorMessage(ex.getMessage());
            }

        }
        // S'il y a pas de nom sélectionné (ERREUR)
        else {

            displayErrorMessage("Sauvergarde impossible!");

        }
    }//GEN-LAST:event_menuEnregistrerActionPerformed

    private void menu_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_rafraichirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importer");		
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

                // Fichier cibl� par l'url
                File source = fileChooser.getSelectedFile();
                if(source.exists()){
                    
                    File database_actuelle = new File(PATH_FOLDER_DATA+"database.csv");
                    if(database_actuelle.exists()){
                    
                        File database_ancienne = new File(PATH_FOLDER_DATA+"database-old.csv");
                        if(database_ancienne.exists()){
                        
                            database_ancienne.delete();
                            
                        }
                        database_actuelle.renameTo(database_ancienne);
                        
                    }
                    try {
                        
                        Path file = Files.copy(Paths.get(source.getAbsolutePath()), Paths.get(database_actuelle.getAbsolutePath()));
                                              
                    } catch (IOException ex) {
                        displayErrorMessage(ex.getMessage());
                    }
                }
                else{
                    
                }
        } else {
            if(returnVal == JFileChooser.CANCEL_OPTION){
                displayErrorMessage("Open command cancelled by user.");                
            }
            else{
                displayErrorMessage("Action échouée");
            }
        }
    }//GEN-LAST:event_menu_rafraichirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        emploisDuTemps.removeAll();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        Vector<Examen> liste_des_examens = new Vector<>();
        
        // Grade == tous
        if(((String) this.jComboBox2.getSelectedItem()).equalsIgnoreCase("tous")){
            if(((String) this.jComboBox3.getSelectedItem()).equalsIgnoreCase("tous")){ 
               if(!((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                    for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getSemestre() == Integer.parseInt(jComboBox1.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
           }
           else{
               if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                   for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getDiplome().equalsIgnoreCase(jComboBox3.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
               else {
                    for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getDiplome().equalsIgnoreCase(jComboBox3.getSelectedItem().toString())
                            &&examen.getSemestre() == Integer.parseInt(jComboBox1.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
           }   
        } // S'il n'est pas égale à tous
        else{
           if(((String) this.jComboBox3.getSelectedItem()).equalsIgnoreCase("tous")){ 
               if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                    for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getGrade().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
               else {        
                    for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getGrade().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())
                            && examen.getSemestre() == Integer.parseInt(jComboBox1.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
           }
           else{
               if(((String) this.jComboBox1.getSelectedItem()).equalsIgnoreCase("tous")){        
                   for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getGrade().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())
                            && examen.getDiplome().equalsIgnoreCase(jComboBox3.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
               else {
                    for(Examen examen : this.emploisDuTemps.getDonneesAffichees()){
                        if(!(examen.getGrade().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())
                            && examen.getDiplome().equalsIgnoreCase(jComboBox3.getSelectedItem().toString())
                            && examen.getSemestre() == Integer.parseInt(jComboBox1.getSelectedItem().toString())
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= Integer.parseInt(jFormattedTextField1.getText()) 
                            && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= Integer.parseInt(jFormattedTextField2.getText()))){
                            liste_des_examens.add(examen);
                        }
                    }
               }
           }            
        }
        
        if(liste_des_examens != null){
            emploisDuTemps.removeAll();
            emploisDuTemps.addExamen(liste_des_examens);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Exporter sous");
        int returnVal = fileChooser.showSaveDialog(this);
        File file = null;

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        // S'il y a un nom sélectionné
        if(file != null) {
            try {
                this.emploisDuTemps.writeInWorkbook(file.getAbsolutePath()+".xlsx");
            } catch (IOException ex) {
                displayErrorMessage(ex.toString());
            }
        }
        // S'il y a pas de nom s�lectionn� (ERREUR)
        else {

           displayErrorMessage("Exportation impossible!");

        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void menuQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuitterActionPerformed
        int valeur = JOptionPane.showConfirmDialog(this, "Voulez-vous sauvergarder avant de quitter");
        if(valeur != JOptionPane.CANCEL_OPTION){
            if(valeur == JOptionPane.OK_OPTION){
                menuEnregistrerActionPerformed(null);
            }
            System.exit(0);
        }
    }//GEN-LAST:event_menuQuitterActionPerformed

    // http://www.formatsdepapier.com/a-formats-en-pixels.htm
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      PrinterJob job = PrinterJob.getPrinterJob();
      HashPrintRequestAttributeSet printRequestSet = new HashPrintRequestAttributeSet();
      
      printRequestSet.add(OrientationRequested.LANDSCAPE);
      job.setPrintable(emploisDuTemps);
      if (job.printDialog(printRequestSet)){
         try {
            job.print();
         } catch (PrinterException ex) {
            displayErrorMessage(ex.getMessage());
         }
      }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) evt.getItem();
            jComboBox3.removeAllItems();
            jComboBox3.addItem("Tous");
            if(item.equalsIgnoreCase("tous")){
                for(String str : this.base_de_donnees.findDiplome()){
                    jComboBox3.addItem(str);
                }
            }
            else{
                for(String str : this.base_de_donnees.findDiplomeParGrade(item)){
                    jComboBox3.addItem(str);
                }
            }
       }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) evt.getItem();
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Tous");
            if(item.equalsIgnoreCase("tous")){
                for(String str : this.base_de_donnees.findAnnee()){
                    jComboBox1.addItem(str);
                }
            }
            else{
                for(String str : this.base_de_donnees.findAnneeParMatiere(item)){
                    jComboBox1.addItem(str);
                }
            }
       }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new Interface_about(this,true).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        JToggleButton toggleButton = (JToggleButton) evt.getSource();
        
        if(toggleButton.isSelected()){
            this.paramsPan.remove(this.ajoutSuppPan);
            this.paramsPan.setPreferredSize(new Dimension(20, this.ajoutSuppPan.getHeight()));
            this.paramsPan.revalidate();
        }
        else {
            this.paramsPan.add(this.ajoutSuppPan, BorderLayout.CENTER);
            this.paramsPan.setPreferredSize(new Dimension(this.ajoutSuppPan.getWidth() + 20, this.ajoutSuppPan.getHeight()));
            this.paramsPan.revalidate();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Exporter sous");
        int returnVal = fileChooser.showSaveDialog(this);
        File file = null;

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        // S'il y a un nom sélectionné
        if(file != null) {
            try {
                this.emploisDuTemps.writeInPdf(file.getAbsolutePath());
            } catch (IOException ex) {
                displayErrorMessage(ex.toString());
            }
        }
        // S'il y a pas de nom s�lectionn� (ERREUR)
        else {

           displayErrorMessage("Exportation impossible!");

        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    /**
     * Open a popup that contains the error message passed
     * @param ErrorMessage Error message to be displayed to alert the user
     */
    public void displayErrorMessage(String ErrorMessage){
        JOptionPane.showMessageDialog(this, ErrorMessage);
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interface_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interface_principale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GradePan;
    private javax.swing.JPanel affichagePan;
    private javax.swing.JPanel ajoutSuppPan;
    private javax.swing.JPanel anneePan;
    private javax.swing.JPanel arrPlanFilPan;
    private javax.swing.JPanel arrPlanFilPan1;
    private javax.swing.JPanel arrPlanFilPan2;
    private javax.swing.JPanel arrPlanSemPan;
    private javax.swing.JMenuBar barre_de_menu;
    private javax.swing.JPanel basPan;
    private javax.swing.JPanel boutonPan;
    private javax.swing.JPanel filierePan;
    private javax.swing.JPanel hiddenPan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JMenuItem menuEnregistrer;
    private javax.swing.JMenuItem menuEnregistrerSous;
    private javax.swing.JMenuItem menuOuvrir;
    private javax.swing.JMenuItem menuQuitter;
    private javax.swing.JMenu menu_aide;
    private javax.swing.JMenu menu_fichier;
    private javax.swing.JMenuItem menu_rafraichir;
    private javax.swing.JPanel paramsPan;
    private javax.swing.JPanel selectionPan;
    private javax.swing.JPanel semainePan;
    // End of variables declaration//GEN-END:variables
    private com.l3.info.magenda.emplois_du_temps.EmploisDuTemps emploisDuTemps;
    private MyComboBoxModel jComboBoxModel;
    private MyComboBoxModel jComboBoxModel1;
    private MyComboBoxModel jComboBoxModel3;
}
