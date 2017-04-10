package com.l3.info.magenda.dao;

import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoExamenCsv implements PatternDao{

    private File file;
    private LecteurCsv csvFile;

    private DaoExamenCsv() {
        super();
    }

    public DaoExamenCsv(File file) {
        this();
        this.file = file;
        this.csvFile = new LecteurCsv(file);
    }
    
    @Override
    public Vector<Examen> findAll() {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            liste_des_examens_voulus.add(examen);
        }

        return liste_des_examens_voulus;
    }

    @Override
    public Examen findById(String id) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen.getId().equalsIgnoreCase(id)){
                 return examen;
            }
        }

        return null;
    }
    
    public Vector<Examen> findByGrade(String grade) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen.getGrade().equalsIgnoreCase(grade)){
                 liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }
    
    @Override
    public Vector<Examen> findByDiplome(String diplome) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null && examen.getDiplome().equalsIgnoreCase(diplome)){
                liste_des_examens_voulus.add(examen);
            }
        }

    return liste_des_examens_voulus;
    }
	
    /**
     *
     * @param diplome
     * @return
     */
    @Override
    public Vector<Examen> findByDiplomeAndWeek(String diplome, int semaine_debut, int semaine_fin) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null 
                    && examen.getDiplome().equalsIgnoreCase(diplome)
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= semaine_debut 
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= semaine_fin){
                liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }

    public Vector<Examen> findParGradeParSemestre(String grade, String semestre, int semaine_debut, int semaine_fin) {
                Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null 
                    && examen.getGrade().equalsIgnoreCase(grade)
                    && examen.getSemestre() == Integer.parseInt(semestre)
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= semaine_debut 
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= semaine_fin){
                liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }
    
    public Vector<Examen> findParGradeParDiplomeEtSemaine(String grade, String diplome, int semaine_debut, int semaine_fin) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null 
                    && examen.getGrade().equalsIgnoreCase(grade)
                    && examen.getDiplome().equalsIgnoreCase(diplome)
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= semaine_debut 
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= semaine_fin){
                liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }

    public Vector<Examen> findParGradeParDiplomeParSemestreEtSemaine(String grade, String diplome, String semestre, int semaine_debut, int semaine_fin) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null 
                    && examen.getGrade().equalsIgnoreCase(grade)
                    && examen.getDiplome().equalsIgnoreCase(diplome)
                    && examen.getSemestre() == Integer.parseInt(semestre)
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= semaine_debut 
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= semaine_fin){
                liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }
    
    public Vector<Examen> findParDiplomeParSemestreEtSemaine(String diplome, String semestre, int semaine_debut, int semaine_fin) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null 
                    && examen.getDiplome().equalsIgnoreCase(diplome)
                    && examen.getSemestre() == Integer.parseInt(semestre)
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= semaine_debut 
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= semaine_fin){
                liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }
    
        public Vector<Examen> findParParSemestreEtSemaine(String semestre, int semaine_debut, int semaine_fin) {
        Vector<Examen> liste_des_examens_voulus = new Vector<Examen>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen != null 
                    && examen.getSemestre() == Integer.parseInt(semestre)
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) >= semaine_debut 
                    && examen.getDeb().get(Calendar.WEEK_OF_YEAR) <= semaine_fin){
                liste_des_examens_voulus.add(examen);
            }
        }

        return liste_des_examens_voulus;
    }
    
    public Vector<String> findGrade() {
        Vector<String> liste_des_grades = new Vector<String>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(!liste_des_grades.contains(examen.getGrade())){
                liste_des_grades.add(examen.getGrade());
            }
        }

        return liste_des_grades;
    }
    
    @Override
    public Vector<String> findDiplome() {
        Vector<String> liste_des_diplomes = new Vector<String>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(!liste_des_diplomes.contains(examen.getDiplome())){
                liste_des_diplomes.add(examen.getDiplome());
            }
        }

        return liste_des_diplomes;
    }
    
    public Iterable<String> findDiplomeParGrade(String grade) {
        Vector<String> liste_des_diplomes = new Vector<String>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen.getGrade().equalsIgnoreCase(grade) && !liste_des_diplomes.contains(examen.getDiplome())){
                liste_des_diplomes.add(examen.getDiplome());
            }
        }

        return liste_des_diplomes;
    }
    
    @Override
    public Vector<String> findAnnee() {
        Vector<String> liste_des_annees = new Vector<String>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(!liste_des_annees.contains(Integer.toString(examen.getSemestre()))){
                liste_des_annees.add(Integer.toString(examen.getSemestre()));
            }
        }
        Collections.sort(liste_des_annees);
        return liste_des_annees;
    }
    
    public Iterable<String> findAnneeParMatiere(String matiere) {
        Vector<String> liste_des_annees = new Vector<String>();

        final Vector<Map<String, String>> donnees_triees = csvFile.getMappedData();

        for (Map<String, String> map : donnees_triees) {
            final Examen examen = convertMap(map);
            if(examen.getDiplome().equalsIgnoreCase(matiere) && !liste_des_annees.contains(Integer.toString(examen.getSemestre()))){
                liste_des_annees.add(Integer.toString(examen.getSemestre()));
            }
        }
        Collections.sort(liste_des_annees);
        return liste_des_annees;
    }
    
    private Examen convertMap(Map<String, String> map) {
        Examen examen;
        int semestre;
        String id = map.get("id"), deb = map.get("jour") + " " + map.get("debut"),  fin = map.get("jour") + " " + map.get("fin"),
                grade = map.get("grade"),diplome = map.get("diplome"), type_resa = map.get("type_resa"), intitule = map.get("intitule_ec"),
                batiment = map.get("batiment"), salle = map.get("salle"), comment = map.get("commentaire");
        try {
            semestre = Integer.parseInt(map.get("semestre"));
        } catch(NumberFormatException e){
            semestre = 0;
        }
        try {
        	examen = new Examen(id);
        	examen.setDeb(deb);
        	examen.setFin(fin);
	        examen.setGrade(grade);
	        examen.setDiplome(diplome);
        	examen.setSemestre(semestre);
	        examen.setType_resa(type_resa);
	        examen.setIntitule(intitule);
	        examen.setBatiment(batiment);
	        examen.setSalle(salle);
	        examen.setCommentaire(comment);
	        return examen;
        } catch (ParseException e) {
        	//Logger.getLogger(interface_principale.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
        	//Logger.getLogger(interface_principale.class.getName()).log(Level.SEVERE, null, e);
        } 
        return null;
    }	

   
}
