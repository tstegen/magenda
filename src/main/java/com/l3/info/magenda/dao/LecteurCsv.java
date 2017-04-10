package com.l3.info.magenda.dao;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class LecteurCsv {

    public final static char SEPARATOR = ';';

    private File file;
    private String[] titles;
    private Vector<String> lines;
    private Vector<String[]> data;
    private Vector<Map<String, String>> donnees_triees;

    private LecteurCsv() {

    }

    public LecteurCsv(File file) {
            this.file = file;
            init();
    }

    private void init() {
            try {
                    lines = CsvFileHelper.readFile(file);
                    data = new Vector<String[] >(lines.size());
                    String regex = new Character(SEPARATOR).toString();
                    for (String line : lines) {
                            line = line.trim();
                            if (line.length() != 0 && ! line.startsWith("#")) {
                                    data.add(line.split(regex));
                            }	
                    }
                    titles = data.get(0);
                    data.remove(0);
                    TrierDonnees();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }

    private void TrierDonnees() {
            this.donnees_triees = new Vector<Map<String, String>>(data.size());

            final int titlesLength = titles.length;

            for (String[] oneData : data) {
                    final Map<String, String> map = new HashMap<String, String>();
                    for (int i = 0; i < titlesLength; i++) {
                            final String key = titles[i].toLowerCase();
                            final String value = oneData[i];
                            map.put(key, value);
                    }

                    this.donnees_triees.add(map);
            }
    }

    public File getFile(){
            return this.file;
    }

    public String[] getTitle(){
            return this.titles;
    } 

    public Vector<String[]> getData(){
            return this.data;
    } 
	
    public Vector<Map<String, String>> getMappedData() {
        return this.donnees_triees;
    }
}
