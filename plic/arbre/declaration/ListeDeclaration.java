package plic.arbre.declaration;

import java.util.ArrayList;
import plic.arbre.ArbreAbstrait;

public class ListeDeclaration extends ArbreAbstrait{
		protected ArrayList<Declaration> ld;

		public ListeDeclaration(int no) {
			super(no);
			ld = new ArrayList<Declaration>();
		}
		
		public void ajouter(Declaration d){
			ld.add(d);
		}

		@Override
		public void verifier() {
			for(Declaration d : ld){
				d.verifier();
			}
		}

		@Override
		public String toMIPS() {
			StringBuilder sb = new StringBuilder();
			for(Declaration d : ld){
				sb.append(d.toMIPS());
			}
			return sb.toString();
		}
}
