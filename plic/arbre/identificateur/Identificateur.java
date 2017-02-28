package plic.arbre.identificateur;

import plic.TDS.*;
import plic.arbre.ArbreAbstrait;

public class Identificateur extends ArbreAbstrait{
		private String idf;
		private Symbole symbole;

		public Identificateur(int no, String s) {
			super(no);
			idf = s;
		}
		
		public String getNom() {
			return idf;
		}
		
		public String getType() {
			return TDS.getInstance().identifier(new Entree(this)).getType();
		}
		
		public int getDeplacement(){
			//return symbole.getDeplacement();
			return 0;
		}

		@Override
		public void verifier() {
			symbole = TDS.getInstance().identifier(new Entree(this));
		}

		@Override
		public String toMIPS() {
			return null;
		}

}
