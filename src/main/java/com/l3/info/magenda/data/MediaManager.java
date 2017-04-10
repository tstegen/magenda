/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l3.info.magenda.data;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomas
 */
public class MediaManager {
        
    public void importFile(String path){
        
    }

    public File loadFile(String path){
       // System.out.println(path);
        System.out.println(this.getClass().getResource(path));
       // File file = new File(url.getPath());
       
        return null;
    }
    
}
