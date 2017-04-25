package plic.arbre;

import plic.TDS.TDS;
import plic.arbre.declaration.ListeDeclaration;
import plic.arbre.identificateur.*;

public class Classe extends ArbreAbstrait{
		protected Identificateur idf;
		protected ListeDeclaration ld;
		protected boolean estRacine, ajoutVar;
		protected int noBloc;

		public Classe(int no, Identificateur i, ListeDeclaration liste) {
			super(no);
			idf = i;
			ld = liste;
			estRacine = false;
			ajoutVar = false;
			noBloc = TDS.getInstance().getDicoCourant();
			if (ld != null){
				ld.ajoutDico();
			}
			ld.setIdfClasse(idf.getNom());
			TDS.getInstance().setDicoCourant(0);
		}
		
		public Classe(int no, Identificateur i) {
			super(no);
			idf = i;
			ld = null;
			estRacine = false;
			ajoutVar = false;
			noBloc = TDS.getInstance().getDicoCourant();
			if (ld != null){
				ld.ajoutDico();
			}
			ld.setIdfClasse(idf.getNom());
			TDS.getInstance().setDicoCourant(0);
		}
		
		public String getIdf() {
			return idf.getNom();
		}
		
		public ListeDeclaration getListeDeclaration(){
			return ld;
		}
		
		public int getNoBloc() {
			return noBloc;
		}
		
		public void ajoutVar() {
			if (ld != null){
				ld.ajoutVar();
			}	
			ajoutVar = true;
		}

		public boolean getVarAdd() {
			return ajoutVar;
		}

		@Override
		public void verifier() {
			if(ld != null)
				ld.verifier();
		}

		@Override
		public String toMIPS() {
			StringBuilder sb = new StringBuilder();
	        sb.append("move $s7, $sp\n");
			sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(noBloc).getTailleZoneVariable() + "\n");
			if(ld != null)
				sb.append(ld.toMIPS());
			sb.append("move $sp, $s7 \n");
			if(TDS.getInstance().getDico(noBloc).getDicoEnglobant() == 0){
				sb.append("addi $s7, $s7, 0\n");
			}else{
				sb.append("addi $s7, $s7, " +-TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getDicoEnglobant()).getTailleZoneVariable() + "\n");
			}
			return sb.toString();
		}

}
