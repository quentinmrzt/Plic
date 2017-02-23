package plic.arbre.identificateur;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class ListeIdentificateur extends ArbreAbstrait{
		protected ArrayList<Identificateur> li;

		public ListeIdentificateur(int no) {
			super(no);
			li = new ArrayList<Identificateur>();
		}
		
		public void ajouter(Identificateur d){
			li.add(d);
		}
		
		public Iterable<Identificateur> iterable(){
			return li;
		}

		@Override
		public void verifier() {
			
		}

		@Override
		public String toMIPS() {
			return null;
		}
}
