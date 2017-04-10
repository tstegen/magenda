package com.l3.info.magenda.dao;

import java.util.Vector;

public interface PatternDao {
	Vector<Examen> findAll();

	Examen findById(String id);

	Vector<Examen> findByDiplome(String diplome);
        
        Vector<Examen> findByDiplomeAndWeek(String diplome, int semaine_debut, int semaine_fin);
        
        Vector<String> findDiplome();
        
        Vector<String> findAnnee();
}
