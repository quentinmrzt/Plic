package plic.arbre.identificateur;

import plic.TDS.*;
import plic.arbre.*;
import plic.exceptions.NonConcordanceTypeException;

public class Acces extends ArbreAbstrait {
	protected Identificateur idf, idfBis;

	public Acces(int no, Identificateur i, Identificateur j) {
		super(no);
		idf = i;
		idfBis = j;
	}
	
	public Identificateur getIdentificateur() {
		if(idfBis == null){
			return idf;
		}else{
			return idfBis;
		}
	}

	@Override
	public void verifier() {
		idf.verifier();
		if(idfBis != null){
			int currentBloc = TDS.getInstance().getDicoCourant();
			int tmpBloc= TDS.getInstance().getDicoCourant();
			Symbole s = null;
			while(s == null){
				s = TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom()));
				currentBloc = TDS.getInstance().sortieBloc().getDicoEnglobant();	
				TDS.getInstance().setDicoCourant(currentBloc);
			}
			if(!s.getType().equals("entier")){
				for (Classe c : TDS.getInstance().getListeClasse()){
					if (s.getType().equals(c.getIdf())){
						TDS.getInstance().setDicoCourant(c.getNoBloc());
						idfBis.verifier();
					}
				}
			}else{
				throw new NonConcordanceTypeException(noLigne, "Le type de " + idf.getNom() + "ne permet pas d'y acceder");
			}
			TDS.getInstance().setDicoCourant(tmpBloc);
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("");
		sb.append("\t# Acces variable :\n");
		if(idfBis == null){
			if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
				sb.append("sw $v0, " + (idf.getDeplacement() - TDS.getInstance().getDico(TDS.getInstance().sortieBloc().getDicoEnglobant()).getTailleZoneVariable()) + "($s7)\n\n");
			}else{
				sb.append("sw $v0, " + idf.getDeplacement() + "($s7)\n\n");
			}
		}else{
			if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
				sb.append("sw $v0, " + (idf.getDeplacement() + idfBis.getDeplacement() - TDS.getInstance().getDico(TDS.getInstance().sortieBloc().getDicoEnglobant()).getTailleZoneVariable()) + "($s7)\n\n");
			}else{
				sb.append("sw $v0, " + (idf.getDeplacement() + idfBis.getDeplacement()) + "($s7)\n\n");
			}
		}
		return sb.toString();
	}

	public void ajoutVar() {		
	}

}
