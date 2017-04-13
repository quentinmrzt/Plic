package plic.arbre.declaration;

import plic.arbre.identificateur.ListeIdentificateur;

public class DeclarationVar extends Declaration {
	protected ListeIdentificateur lidf;

	public DeclarationVar(int no, ListeIdentificateur li) {
		super(no);
		lidf = li;
	}

	@Override
	public void verifier() {
		lidf.verifier();
	}

	@Override
	public String toMIPS() {
		return "";
	}

}
