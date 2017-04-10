package com.l3.info.magenda.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class CsvFileHelper {

	 public static Vector<String> readFile(File file) throws IOException {

		Vector<String> result = new Vector<String>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }

        br.close();
        fr.close();

        return result;
    }
	
	public static String getResourcePath(String fileName) {
       final File f = new File("");
       final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
       return dossierPath;
   }

   public static File getResource(String fileName) {
       final String completeFileName = getResourcePath(fileName);
       File file = new File(completeFileName);
       return file;
   }

   public static void main(String [] argv){

	    final String fileName = "src/data/database.csv";

	    // Result
	    final int nombreLigne = 11;

	    // Appel
	    final File file = CsvFileHelper.getResource(fileName);
	    Vector<String> lines;
		try {
			lines = CsvFileHelper.readFile(file);
			for(String elem : lines) System.out.println(elem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
   }
   
}	
