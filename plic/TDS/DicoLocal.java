package plic.TDS;

import java.util.HashMap;
import plic.arbre.Classe;
import plic.exceptions.DoubleDeclException;

public class DicoLocal {
	private int dep;
	private int dicoEnglobant, noBloc;
	private HashMap<Entree, Symbole> dico;
	
	public DicoLocal(int dEnglobant, int nBloc){
		dep = 0;
		dicoEnglobant = dEnglobant;
		noBloc = nBloc;
		dico = new HashMap<Entree, Symbole>();
	}
	
	public void ajouter(Entree e, Symbole s, int noligne){
		if(identifier(e) != null){
			throw new DoubleDeclException(noligne, "La variable \"" + e.getIdf() + "\" est declaree plusieurs fois");
		}
		
		dico.put(e, s);
		
		if (s.getType().equals("entier")){
			dep -= 4;
		}else{
			int numBloc = 1;
			for (Classe c : TDS.getInstance().getListeClasse()){
				if (s.getType().equals(c.getIdf())){
					numBloc = c.getNoBloc();
				}
			}
			
			dep = dep + TDS.getInstance().getDico(numBloc).getTailleZoneVariable();
		}	
	}
	
	public Symbole identifier(Entree e){
		return dico.get(e);
	}

	public int getTailleZoneVariable() {
		return dep;
	}

	public int getDicoEnglobant() {
		return dicoEnglobant;
	}
	
	public int getNoBloc(){
		return noBloc;
	}

}
