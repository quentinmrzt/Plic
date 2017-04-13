package plic.arbre.declaration;

import plic.arbre.identificateur.Identificateur;
import plic.arbre.instruction.ListeInstruction;

public class DeclarationConst extends Declaration{
	protected Identificateur idf;
	protected ListeInstruction linst;

	public DeclarationConst(int no, Identificateur i, ListeInstruction li) {
		super(no);
		idf = i;
		linst = li;
	}

	@Override
	public void verifier(){
		//idf.verifier();
		linst.verifier();
	}

	@Override
	public String toMIPS(){
		return null;
	}

}
