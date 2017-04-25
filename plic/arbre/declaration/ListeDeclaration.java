package plic.arbre.declaration;

import java.util.ArrayList;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.*;

public class ListeDeclaration extends ArbreAbstrait{
		protected ArrayList<Declaration> ld;
		protected String idfClasse;
		protected int nbConstructeur;

		public ListeDeclaration(int no) {
			super(no);
			ld = new ArrayList<Declaration>();
			nbConstructeur = 0;
		}
		
		public void ajouter(Declaration d){
			ld.add(d);
		}
		
		public Declaration getDeclaration(int n){
			for(Declaration d : ld){
				if(d instanceof DeclarationConst && ((DeclarationConst) d).getNum() == n){
					return d;
				}
			}
			return ld.get(0);
		}
		
		public void setIdfClasse(String id){
			idfClasse = id;
		}
		
		public void ajoutDico(){
			for(Declaration d : ld){
				d.setNoBlocInstruction();
			}
		}

		public void ajoutVar() {
			for (Declaration d : ld){
					d.ajoutVar();
			}
		}

		@Override
		public void verifier() {
			for(Declaration d : ld){
				d.verifier();
				if (d instanceof DeclarationConst){
					nbConstructeur ++;
					((DeclarationConst) d).setNum(nbConstructeur);
				}
				if(nbConstructeur > 1){
					throw new ConstructeurUniqueException(noLigne, "Un seul constructeur peut etre declare");
				}
				if (d instanceof DeclarationConst && !idfClasse.equals(((DeclarationConst) d).getIdf())){
					throw new IdfClasseConstructeurDiffException(noLigne, "L'identificateur du constructeur est different de l'identificateur de la classe");
				}
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
