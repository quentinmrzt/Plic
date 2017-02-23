package plic.arbre.identificateur;

import plic.arbre.ArbreAbstrait;

public class Identificateur extends ArbreAbstrait{
		String idf;

		public Identificateur(int no, String s) {
			super(no);
			idf = s;
		}
		
		public String getNom() {
			return idf;
		}

		@Override
		public void verifier() {
			
		}

		@Override
		public String toMIPS() {
			return null;
		}

}
