/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda;

import com.l3.info.magenda.dao.Examen;
import com.l3.info.magenda.interface_java.MyComboBoxModel;
import java.util.Vector;

/**
 *
 * @author tstegen
 */
public class Interface_export extends javax.swing.JDialog {

    Vector<Examen> resultat, basededonnees;
    
    /**
     * Creates new form interface_ajouter
     */
    public Interface_export(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel8 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        formatPan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        excelRB = new javax.swing.JRadioButton();
        pdfRB = new javax.swing.JRadioButton();
        destinationPan = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cheminPan = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        cheminBouton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajout");
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(232, 233, 239));
        mainPanel.setMinimumSize(new java.awt.Dimension(300, 364));
        mainPanel.setPreferredSize(new java.awt.Dimension(350, 358));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        formatPan.setMinimumSize(new java.awt.Dimension(300, 143));
        formatPan.setOpaque(false);
        formatPan.setPreferredSize(new java.awt.Dimension(300, 143));
        formatPan.setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setBackground(new java.awt.Color(200, 200, 200));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("    Format");
        jPanel7.add(jLabel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 302;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        formatPan.add(jPanel7, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        excelRB.setText("Excel");
        excelRB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        excelRB.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        jPanel1.add(excelRB, gridBagConstraints);

        pdfRB.setText("PDF");
        pdfRB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pdfRB.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 6);
        jPanel1.add(pdfRB, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 124, 45, 0);
        formatPan.add(jPanel1, gridBagConstraints);

        mainPanel.add(formatPan);

        destinationPan.setOpaque(false);
        destinationPan.setPreferredSize(new java.awt.Dimension(300, 150));
        destinationPan.setLayout(new java.awt.GridBagLayout());

        jPanel6.setMinimumSize(new java.awt.Dimension(70, 16));
        jPanel6.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("    Destination :");
        jLabel5.setMinimumSize(new java.awt.Dimension(70, 16));
        jLabel5.setPreferredSize(new java.awt.Dimension(75, 16));
        jPanel6.add(jLabel5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 267;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        destinationPan.add(jPanel6, gridBagConstraints);

        cheminPan.setPreferredSize(new java.awt.Dimension(70, 35));
        cheminPan.setLayout(new javax.swing.BoxLayout(cheminPan, javax.swing.BoxLayout.LINE_AXIS));

        jTextField1.setText("Chemin du dossier...");
        jTextField1.setMinimumSize(new java.awt.Dimension(4, 15));
        jTextField1.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        cheminPan.add(jTextField1);

        cheminBouton.setText("    ...    ");
        cheminBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheminBoutonActionPerformed(evt);
            }
        });
        cheminPan.add(cheminBouton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 260;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 56, 0);
        destinationPan.add(cheminPan, gridBagConstraints);

        mainPanel.add(destinationPan);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setMinimumSize(new java.awt.Dimension(370, 25));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(370, 30));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Exporter");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButton2, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), jButton1, org.jdesktop.beansbinding.BeanProperty.create("preferredSize"));
        bindingGroup.addBinding(binding);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 149, 3, 0);
        jPanel4.add(jButton1, gridBagConstraints);

        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 13, 3, 9);
        jPanel4.add(jButton2, gridBagConstraints);

        mainPanel.add(jPanel4);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
         
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cheminBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheminBoutonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cheminBoutonActionPerformed

    public void setListeExamen (Vector<Examen> bd){
        this.basededonnees = bd;
    }

   
    public Vector<Examen> showDialog(){
        setVisible(true);
        return resultat;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cheminBouton;
    private javax.swing.JPanel cheminPan;
    private javax.swing.JPanel destinationPan;
    private javax.swing.JRadioButton excelRB;
    private javax.swing.JPanel formatPan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton pdfRB;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private MyComboBoxModel jComboBoxModel;
}