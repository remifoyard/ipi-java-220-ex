package com.ipiecoles.java.java220;

import java.util.Collections;
import java.util.HashSet;

public class Unite <T>{
	private T responsable;
	private HashSet<T> membres;

	public Unite(){}
	
	public Unite(T membres){
		this.responsable = membres;
		this.membres.add(membres);		
	}
	@Override
	public String toString() {
		return "Unite [responsable=" + responsable + ", membres=" + membres + "]";
	}

	public void ajouterMembre(T[] membres){
		Collections.addAll(this.membres, membres);		
	}
	public HashSet<T> getMembres() {
		return membres;
	}
	
	public void setMembres(HashSet<T> membres) {
		this.membres = membres;
	}
	
	public T getResponsable() {
		return responsable;
	}
	
	public void setResponsable(T responsable) {
		this.responsable = responsable;
	}

}
