package plic.arbre.identificateur;

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
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Acces variable :\n");
		sb.append("sw $v0, " + idf.getDeplacement() + "($s7)\n");
		
		return sb.toString();
	}

}
