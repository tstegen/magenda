package com.l3.info.magenda.dao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


/**
 * 
 * Classe permettant de contenir un examen
 * 
 * @author tstegen - hstein
 *
 */
public class Examen implements Serializable{

	/**
	 * Id de l'examen
	 */
	private String id;
	
	/*
	 * Calendar comprends �galement le jour => ne pas le red�clarer 3 fois
	 */
	
	/**
	 * Date et heure du d�but de l'examen
	 */
	private Calendar deb;
	
	/**
	 * Date et heure de fin de l'examen
	 */
	private Calendar fin;
	
	/**
	 * Grade de l'examen : license ou master
	 */
	private String grade;
	
	/**
	 * Fili�re concern� par l'examen
	 */
	
	private String diplome;
	
	/**
	 * Semestre concern� par l'examen
	 */
	private int semestre;
	
	private String type_resa = "EXAMEN";
	
	/**
	 * Intitul� de l'examen
	 */
	private String intitule;
	
	/**
	 * Batiment o� � lieu l'examen
	 */
	private String batiment;
	
	/**
	 *  Salle o� � lieu l'examen
	 */
	private String salle;
	
	/**
	 *  Commentaire sp�cifique � l'examen
	 */
	private String commentaire;
	
	/**
	 * @param id
	 */
	public Examen(String id) {
		
		this.id = id;
		
		this.type_resa = "Examen";
		
	}

	/**
	 * 
	 * Constructeur d'une entit� de l'examen avec l'enti�ret� des param�tres.
	 * 
	 * @param id Id de l'examen
	 * @param deb Date et heure du d�but de l'examen
	 * @param fin Date et heure de fin de l'examen
	 * @param grade Grade de l'examen : license ou master
	 * @param diplome Fili�re concern� par l'examen
	 * @param semestre Semestre concern� par l'examen
	 * @param type_resa Signale que c'est un examen
	 * @param intitule Intitul� de l'examen
	 * @param batiment Batiment o� � lieu l'examen
	 * @param salle Salle o� � lieu l'examen
	 * @param commentaire Commentaire sp�cifique � l'examen
	 */
	public Examen(String id, Calendar deb, Calendar fin, String grade, String diplome, Integer semestre, String type_resa,
			String intitule, String batiment, String salle, String commentaire) {
		
		this.id = id;
		this.deb = deb;
		this.fin = fin;
		this.grade = grade;
		this.diplome = diplome;
		this.semestre = semestre;
		this.type_resa = type_resa;
		this.intitule = intitule;
		this.batiment = batiment;
		this.salle = salle;
		this.commentaire = commentaire;
		
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the deb
	 */
	public Calendar getDeb() {
		
		return deb;
		
	}

	/**
	 * @param deb the deb to set
	 */
	public void setDeb(Calendar deb) {
		
		this.deb = deb;
		
	}

	/**
	 * @param deb the deb to set
	 * @throws ParseException 
	 */
	public void setDeb(String deb) throws ParseException {
		
		this.deb = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
			
		this.deb.setTime(sdf.parse(deb));
		
	}
	
	/**
	 * in minute
	 */
	public long getStartHour (){
		
		return  deb.get(Calendar.HOUR_OF_DAY)*60 + deb.get(Calendar.MINUTE);
		
	}
	
	/**
	 * @return the fin
	 */
	public Calendar getFin() {
		
		return fin;
		
	}

	/**
	 * in minute
	 */
	public long getEndHour (){
		
		return  fin.get(Calendar.HOUR_OF_DAY)*60 + fin.get(Calendar.MINUTE);
		
	}
	
	/**
	 * @param fin the fin to set
	 */
	public void setFin(Calendar fin) {
		
		this.fin = fin;
		
	}

	/**
	 * @param fin the fin to set
	 * @throws ParseException 
	 */
	public void setFin(String fin) throws ParseException {
		
		this.fin = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
		
		this.fin.setTime(sdf.parse(fin));
		
	}
	
	/**
	 * in minute
	 */
	public long getTime (){
		
		return  (fin.getTime().getTime() - deb.getTime().getTime()) / 60000;
		
	}
	
	/**
	 * @return the grade
	 */
	public String getGrade() {
		
		return grade;
		
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		
		this.grade = grade;
		
	}

	/**
	 * @return the diplome
	 */
	public String getDiplome() {
		
		return diplome;
		
	}

	/**
	 * @param diplome the diplome to set
	 */
	public void setDiplome(String diplome) {
		
		this.diplome = diplome;
		
	}

	/**
	 * @return the semestre
	 */
	public int getSemestre() {
		
		return semestre;
		
	}
	

	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(int semestre) {
		
		this.semestre = semestre;
		
	}

	/**
	 * @return the type_resa
	 */
	public String getType_resa() {
		return type_resa;
	}

	/**
	 * @param type_resa the type_resa to set
	 */
	public void setType_resa(String type_resa) {
		this.type_resa = type_resa;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the batiment
	 */
	public String getBatiment() {
		return batiment;
	}

	/**
	 * @param batiment the batiment to set
	 */
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}

	/**
	 * @return the salle
	 */
	public String getSalle() {
		return salle;
	}

	/**
	 * @param salle the salle to set
	 */
	public void setSalle(String salle) {
		this.salle = salle;
	}

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String description(){
		
                String intitule_lc = this.intitule.substring(0,1).toUpperCase() + this.intitule.substring(1).toLowerCase();
            
		if(this.grade.equals("L1"))
			return "L" + ((this.semestre+1)/2) + " " + this.diplome + " " + intitule_lc + " S" + this.semestre;
		else
			return this.grade + " " + this.diplome + " " + intitule_lc + " S" + this.semestre;
		
	}
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

            return "Exam [id=" + id + ", deb=" + deb.getTime() + ", fin=" + fin.getTime() + ", grade=" + grade + ", diplome=" + diplome
                            + ", semestre=" + semestre + ", type_resa=" + type_resa + ", intitule=" + intitule + ", batiment="
                            + batiment + ", salle=" + salle + ", commentaire=" + commentaire + "]";

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Examen ))
            return false;
        if(this.id.equals(((Examen) obj).id))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.deb);
        hash = 17 * hash + Objects.hashCode(this.fin);
        return hash;
    }
        
}
