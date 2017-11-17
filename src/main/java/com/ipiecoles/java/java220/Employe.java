package com.ipiecoles.java.java220;

import java.util.Objects;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
abstract public class Employe {
	private String nom;
	private String prenom;
	private String matricule;
	private LocalDate dateEmbauche;
	private Double salaire;
	
	public Employe(){	
	}
	public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
	}

	public abstract Double getPrimeAnnuelle();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		LocalDate anneEncours = new LocalDate();
		if(dateEmbauche.isAfter(anneEncours))
		{			
			throw new RuntimeException("La date d'embauche ne peut être postérieure à la date courante");
		}
		else
		{
			this.dateEmbauche = dateEmbauche;
		}
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
	public final Integer getNombreAnneeAnciennete(){
		Integer anneeEmbauche = dateEmbauche.getYear();
		Integer anneeEnCours = LocalDate.now().getYear();
		Integer nbrAnnee=anneeEnCours-anneeEmbauche;
		return nbrAnnee;
	}
	
	public Integer getNbConges()
	{
		return Entreprise.NB_CONGES_BASE;
	}
	
	public String toString(){
		String valeur = "Employe{nom='"+this.nom+"', prenom='"+this.prenom+"', matricule='"+this.matricule+"', dateEmbauche="+this.dateEmbauche+", salaire="+this.salaire+"}"; 
		return valeur;
	}
	
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null) return false;
	    if (getClass() != o.getClass()) return false;
	    Employe e = (Employe) o;
	    return
	      Double.compare(e.salaire, this.salaire) == 0 &&
	      Objects.equals(this.dateEmbauche, e.dateEmbauche) &&
	      Objects.equals(this.nom, e.nom) &&
	      Objects.equals(this.prenom, e.prenom)&&
	      Objects.equals(this.matricule, e.matricule);
	  }
	
	public int hashCode(){
		int valeur = Objects.hash(nom,prenom,matricule,dateEmbauche,salaire);
		return valeur;
	}
	
	public void augmenterSalaire(Double pourcentage){
		Double res = this.salaire*pourcentage;
		Double resultat = this.salaire+res;
		this.salaire = resultat;
	}
}
