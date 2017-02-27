package plic.arbre.identificateur;

import plic.arbre.ArbreAbstrait;

public class Acces extends ArbreAbstrait {
	protected Identificateur idf;

	public Acces(int no, Identificateur i) {
		super(no);
		idf = i;
	}

	@Override
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
