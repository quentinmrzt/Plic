package plic.arbre.declaration;

import plic.arbre.identificateur.ListeIdentificateur;

public class DeclarationChamp extends Declaration{
	protected ListeIdentificateur lidf;

	public DeclarationChamp(int no, ListeIdentificateur li) {
		super(no);
		lidf = li;
	}

	@Override
	public void verifier(){
		lidf.verifier();
	}

	@Override
	public String toMIPS(){
		return "";
	}
}
