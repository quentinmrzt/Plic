package plic.arbre;

import plic.arbre.declaration.ListeDeclaration;
import plic.arbre.identificateur.*;

public class Classe extends ArbreAbstrait{
		protected Identificateur idf;
		protected ListeDeclaration ld;

		public Classe(int no, Identificateur i, ListeDeclaration liste) {
			super(no);
			idf = i;
			ld = liste;
		}

		@Override
		public void verifier() {
			
		}

		@Override
		public String toMIPS() {
			return null;
		}
}
