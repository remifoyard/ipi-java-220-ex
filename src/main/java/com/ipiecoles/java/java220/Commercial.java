package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe{

	private Double caAnnuel;
	private Integer performance;
	
	public Integer getPerformance() {
		return performance;
	}

	public void setPerformance(Integer performance) {
		this.performance = performance;
	}

	public Double getCaAnnuel() {
		return caAnnuel;
	}
	
	public Commercial(){
	}
	public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
		super(nom,prenom,matricule,dateEmbauche,salaire);
		this.caAnnuel=caAnnuel;
	}
	public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
		this(nom,prenom,matricule,dateEmbauche,salaire,caAnnuel);
		this.performance=performance;
	}
	
	public void setCaAnnuel(Double caAnnuel) {
		this.caAnnuel = caAnnuel;
	}
	@Override
	public Double getPrimeAnnuelle() {
		// TODO Auto-generated method stub
		Double prime = 0.0;
		Double mini = 0.0;
		if(this.caAnnuel!=null)
		{
			prime = (double) Math.ceil(this.caAnnuel*0.05);
		}
		mini = 500.0;
		if(prime>=500.0)
		{
			return prime;
		}
		else
		{
			return mini;
		}
	}
	
	public boolean equals(Object o){
		
	    Commercial c = (Commercial) o;
	    return
	    		super.equals(o) &&
	  	      Double.compare(c.caAnnuel, this.caAnnuel) == 0;
	}
	
	public boolean performanceEgale(Integer param){
		if(this.performance.equals(param))
		{
			return true;
		}
		else return false;
	}

	public Note equivalenceNote(){
		Note valeur=Note.INSUFFISANT;
		switch (this.performance)
		{
		  case 0:
		  case 50:
		    valeur=Note.INSUFFISANT;
		    break;
		  case 100:
			    valeur= Note.PASSABLE;
			    break;   
		  case 150:
			    valeur= Note.BIEN;
			    break;   
		  case 200:
			    valeur = Note.TRES_BIEN;
			    break;            
		}
		return valeur;
	}
}
