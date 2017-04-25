package plic.arbre.declaration;

import plic.TDS.*;
import plic.arbre.Classe;
import plic.arbre.identificateur.*;
import plic.arbre.instruction.Instruction;

public class DeclarationVar extends Instruction {
	protected ListeIdentificateur lidf;
	protected String type;

	public DeclarationVar(int no, ListeIdentificateur li, String type, int noBloc) {
		super(no, noBloc);
		lidf = li;
		this.type = type;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setDicoCourant(noBloc);
		lidf.verifier();
	}

	@Override
	public String toMIPS() {
		return "";
	}

	public void ajoutVar() {
		if(!type.equals("entier")){
		for(Classe c : TDS.getInstance().getListeClasse()){
			if(c.getIdf().equals(type) && !c.getVarAdd()){
				c.ajoutVar();
			}
		}
	}
	int dep;
	for(Identificateur i: lidf.iterable()){
		dep = TDS.getInstance().getDico(noBloc).getTailleZoneVariable();
		TDS.getInstance().setDicoCourant(noBloc);
		TDS.getInstance().ajouter(new Entree(i.getNom()), new Symbole(dep, type, "publique"), noLigne);				
	} 
	}

}
