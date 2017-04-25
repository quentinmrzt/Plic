package plic.arbre.identificateur;

import plic.TDS.*;
import plic.arbre.Classe;
import plic.arbre.expression.Expression;
import plic.exceptions.*;

public class Identificateur extends Expression{
		private String nom;
		private Symbole symbole;

		public Identificateur(int no, String s) {
			super(no);
			nom = s;
		}
		
		public String getNom() {
			return nom;
		}
		
		public String getType() {
			Entree e = new Entree(nom);
			int dicoCourant = TDS.getInstance().getDicoCourant();
			int noBloc= TDS.getInstance().getDicoCourant();
			
			while (symbole == null && dicoCourant > 0){
				symbole = TDS.getInstance().sortieBloc().identifier(e);
				dicoCourant = TDS.getInstance().sortieBloc().getDicoEnglobant();
				TDS.getInstance().setDicoCourant(dicoCourant);
			}
			TDS.getInstance().setDicoCourant(noBloc);
			return symbole.getType();
		}
		
		public int getDeplacement(){
			return symbole.getDeplacement();
		}

		@Override
		public void verifier() {
			int dicoCourant = TDS.getInstance().getDicoCourant();
			int noBloc = TDS.getInstance().getDicoCourant();

			while(dicoCourant > 0 && symbole == null){
				symbole = TDS.getInstance().sortieBloc().identifier(new Entree(nom));
				dicoCourant = TDS.getInstance().sortieBloc().getDicoEnglobant();	
				TDS.getInstance().setDicoCourant(dicoCourant);
			}
			if (symbole == null){
				throw new IdfNonTrouveException(this.getNoLigne(), "La variable " + nom + " n'existe pas");
			}
			TDS.getInstance().setDicoCourant(noBloc);

			boolean typeOk = false;
			if (symbole.getType().equals("entier")){
				typeOk = true;
			}
			if (symbole.getType().equals("bool")){
				typeOk = true;
			}		
			for (Classe c : TDS.getInstance().getListeClasse()){
				if (symbole.getType().equals(c.getIdf())){
					typeOk = true;
				}
			}
			if (!typeOk){
				throw new TypeIdfInexistantException(noLigne, "Le type de " + nom + " n'existe pas");
			}
		}

		@Override
		public String toMIPS() {
			StringBuilder sb = new StringBuilder();
			sb.append("\t# Identification variable :\n");
			
			if (TDS.getInstance().sortieBloc().identifier(new Entree(this.getNom())) == null){
				sb.append("lw $v0, " + (symbole.getDeplacement() - TDS.getInstance().getDico(TDS.getInstance().sortieBloc().getDicoEnglobant()).getTailleZoneVariable()) + "($s7)\n\n");
			}else{
				sb.append("lw $v0, " + symbole.getDeplacement() + "($s7)\n\n");
			}
			return sb.toString() ;
		}

		public void ajoutVar() {
		}

}
