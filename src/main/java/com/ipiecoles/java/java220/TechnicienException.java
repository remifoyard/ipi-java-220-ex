package com.ipiecoles.java.java220;

public class TechnicienException extends Exception{
	private static final long serialVersionUID = 1L;
	public TechnicienException(Integer grade, Technicien technicien) {
		super("Le grade doit être compris entre 1 et 5 : "+grade+", technicien : Technicien{grade="+technicien.getGrade()+"} Employe{nom='"+technicien.getNom()+"', prenom='"+technicien.getPrenom()+"', matricule='"+technicien.getMatricule()+"', dateEmbauche="+technicien.getDateEmbauche()+", salaire="+technicien.getSalaire()+"}");
	}
}
