package plic.arbre;

import java.util.ArrayList;

public class ListeClasse extends ArbreAbstrait {
	protected ArrayList<Classe> lc;

	public ListeClasse(int no) {
		super(no);
		lc = new ArrayList<Classe>();
	}
	
	public void ajouter(Classe c){
		lc.add(c);
	}

	@Override
	public void verifier() {
		for(Classe c : lc){
			c.verifier();
		}
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
