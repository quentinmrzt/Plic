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
		
		public Classe(int no, Identificateur i) {
			super(no);
			idf = i;
			ld = null;
		}

		@Override
		public void verifier() {
			idf.verifier();
			if(ld != null)
				ld.verifier();
		}

		@Override
		public String toMIPS() {
			return null;
		}
}
