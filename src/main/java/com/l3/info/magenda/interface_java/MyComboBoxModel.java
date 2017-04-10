/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.interface_java;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tstegen
 */
public class MyComboBoxModel extends DefaultComboBoxModel<String> {

    public MyComboBoxModel(String[] items) {
        super(items);
        this.addElement("Tous");
    }
 
    public MyComboBoxModel() {
        super();
        this.addElement("Tous");
    }
    
    @Override
    public String getSelectedItem() {
        String selectedJob = (String) super.getSelectedItem();
 
        // do something with this job before returning...
 
        return selectedJob;
    }

};
