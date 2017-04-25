package plic.arbre.declaration;

import plic.TDS.*;
import plic.arbre.Classe;
import plic.arbre.identificateur.Identificateur;
import plic.arbre.identificateur.ListeIdentificateur;

public class DeclarationChamp extends Declaration {
	protected ListeIdentificateur lidf;
	protected String type, statut;

	public DeclarationChamp(int no, ListeIdentificateur li, String type, String statut, int noBloc) {
		super(no, noBloc);
		lidf = li;
		this.type = type;
		this.statut = statut;
	}

	public void setNoBlocInstruction() {		
		noBloc = TDS.getInstance().getDicoCourant();		
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
			TDS.getInstance().ajouter(new Entree(i.getNom()), new Symbole(dep, type, statut),noLigne);				
		} 
	}
	
	@Override
	public void verifier(){
		TDS.getInstance().setDicoCourant(noBloc);
		lidf.verifier();
	}

	@Override
	public String toMIPS(){
		return "";
	}
}
