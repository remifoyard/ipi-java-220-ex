package com.ipiecoles.java.java220;

import java.util.HashSet;
import java.util.Objects;

import org.joda.time.LocalDate;

public class Manager extends Employe{
	private HashSet<Technicien> equipe = new HashSet<Technicien>();
	
	public HashSet<Technicien> getEquipe() {
		return equipe;
	}

	public void setEquipe(HashSet<Technicien> equipe) {
		this.equipe = equipe;
	}

	public Manager(){
	}

	public void ajoutTechnicienEquipe(Technicien t){
		this.equipe.add(t);
	}
	/*
	public void ajoutTechnicienEquipe(Technicien t, nom, prenom, matricule, grade, salaire){
		this.equipe.add(t);
	}
*/
	public void setSalaire(Double salaire) {
		Double indice = Entreprise.INDICE_MANAGER;
		Double taille = (double)equipe.size();
		Double salaireFinal = (salaire * (0.1* taille)) + (indice * salaire);	
		super.setSalaire(salaireFinal);
	}
	
	@Override
	public Double getPrimeAnnuelle() {
		Double prime = Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;		
		Double taille = (double) equipe.size();	
		Double primeBase = Entreprise.primeAnnuelleBase();
		Double calcul = primeBase + (prime * taille);
		return calcul;
	}

	public void augmenterSalaire(Double pourcentage) {
		super.augmenterSalaire(pourcentage);
		augmenterSalaireEquipe(pourcentage);
	}

	private void augmenterSalaireEquipe(Double pourcentage) {
		for (Technicien technicien : equipe) {
			technicien.augmenterSalaire(pourcentage);
		}
	}

	public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) throws TechnicienException {
		this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
	}
}
