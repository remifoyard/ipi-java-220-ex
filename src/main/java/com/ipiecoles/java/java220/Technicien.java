package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe implements Comparable<Technicien>{
	private Integer grade;
	
	public Technicien(){
	}
	
	public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
		super(nom,prenom,matricule,dateEmbauche,salaire);
		this.grade=grade;
	}

	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) throws TechnicienException {
		if(grade>=1 && grade <=5)
		{			
			this.grade = grade;			
		}
		else
		{
			throw new TechnicienException(grade, this);
		}
	}

	public void setSalaire(Double salaire) {
		String str = "1."+this.grade;
		Double calcul = Double.parseDouble(str);
		Double valeur = salaire * calcul ;
		super.setSalaire(valeur);
	}
	
	public Integer getNbConges()
	{
		Integer anneeEmbauche = this.getDateEmbauche().getYear();
		Integer anneeAujourdhui = LocalDate.now().getYear();
		Integer ancienneteNbConges = anneeAujourdhui - anneeEmbauche;
		Integer mesConges = Entreprise.NB_CONGES_BASE;
		Integer newNbConges = mesConges + ancienneteNbConges;
		return newNbConges;
	}

	public Double getPrimeAnnuelle() {
		Double prime = Entreprise.primeAnnuelleBase();
		String str = "1."+this.grade;
		Double calcul = Double.parseDouble(str);
		Double valeur = prime * calcul ;
		Double primeAnciennete= Entreprise.PRIME_ANCIENNETE;
		Integer anneeEmbauche = this.getDateEmbauche().getYear();
		Integer anneeAujourdhui = LocalDate.now().getYear();
		Integer ancienneteNbConges = anneeAujourdhui - anneeEmbauche;
		Double primeFinale = prime + valeur + (primeAnciennete * ancienneteNbConges);
		return primeFinale;
	}
	
	public int compareTo(Technicien t){
		return Integer.compare( t.grade, this.grade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Technicien other = (Technicien) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}
	
}
