package plic.arbre;

import java.util.ArrayList;
import plic.exceptions.ClasseRacineInexistanteException;

public class ListeClasse extends ArbreAbstrait {
	protected ArrayList<Classe> lc;

	public ListeClasse(int no) {
		super(no);
		lc = new ArrayList<Classe>();
	}
	
	public void ajouter(Classe c){
		lc.add(c);
	}
	
	public ArrayList<Classe> getListeClasse() {
		return lc;
	}

	public void ajoutVar() {
		for (Classe c : lc){
			if (c.getIdf().equals(this.classeRacine)){			
				c.ajoutVar();
			}
		}
		for (Classe c : lc){
			if(!c.getVarAdd()){
				c.ajoutVar();
			}
		}
	}

	@Override
	public void verifier() {
		boolean existeClasseRacine = false;
		for (Classe c : lc){
			if (c.getIdf().equals(this.classeRacine)){
				existeClasseRacine = true;
			}
			c.verifier();
		}	
		if (!existeClasseRacine){
			throw new ClasseRacineInexistanteException(noLigne, "La classe racine passee en argument est inexistante");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		for (Classe c : lc){
			if (c.getIdf().equals(this.classeRacine)){
				sb.append(c.toMIPS());
			}
		}
		return sb.toString();
	}

}
