package plic.TDS;

import plic.arbre.identificateur.Identificateur;

public class Entree {
	protected String idf;
	
	public Entree(Identificateur s){
		idf = s.getNom();
	}

}
