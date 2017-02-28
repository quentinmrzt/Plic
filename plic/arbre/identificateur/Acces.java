package plic.arbre.identificateur;

import plic.TDS.TDS;
import plic.arbre.ArbreAbstrait;

public class Acces extends ArbreAbstrait {
	protected Identificateur idf;

	public Acces(int no, Identificateur i) {
		super(no);
		idf = i;
	}
	
	public Identificateur getIdentificateur() {
		return idf;
	}

	@Override
	public void verifier() {
		idf.verifier();
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
