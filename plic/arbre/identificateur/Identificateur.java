package plic.arbre.identificateur;

import plic.TDS.*;
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
			return TDS.getInstance().identifier(new Entree(nom), this.getNoLigne()).getType();
		}
		
		public int getDeplacement(){
			return symbole.getDeplacement();
		}

		@Override
		public void verifier() {
			symbole = TDS.getInstance().identifier(new Entree(nom), this.getNoLigne());
			if(symbole == null){
				throw new IdfNonTrouveException(this.getNoLigne(), "L'identificateur n'existe pas");
			}
		}

		@Override
		public String toMIPS() {
			StringBuilder sb = new StringBuilder();
			sb.append("\t# Identification variable :\n");
			sb.append("lw $v0, " + symbole.getDeplacement() + "($s7)\n");
			
			return sb.toString();
		}

}
