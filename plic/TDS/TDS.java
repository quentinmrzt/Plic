package plic.TDS;

import java.util.*;
import plic.arbre.*;

public class TDS {
	private final static TDS instance = new TDS();
	private static int dicoCourant = 0, noBloc = 0;
	private static boolean analyseSem = false;
	private static HashMap<Integer, DicoLocal> listeDico = new HashMap<Integer, DicoLocal>();
	private static ListeClasse listeClasse = null;
	
	private TDS(){
	}
	
	public static TDS getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s, int noligne){
		listeDico.get(dicoCourant).ajouter(e, s, noligne);
	}
	
	public void entreeBloc(){
		noBloc++;
		listeDico.put(noBloc, new DicoLocal(dicoCourant, noBloc));
	}
	
	public DicoLocal sortieBloc(){
		return listeDico.get(dicoCourant);
	}
	
	public DicoLocal getDico(int n){
		return listeDico.get(n);
	}
	
	public void setDicoCourant(int n){
		dicoCourant = n;
	}
	
	public int getDicoCourant(){
		return dicoCourant;
	}
	
	public int getNoBloc(){
		return noBloc;
	}
	
	public void setListeClasse(ListeClasse lc){
		listeClasse = lc;
	}
	
	public Iterable<Classe> getListeClasse(){
		return listeClasse.getListeClasse();
	}

	public void setAnalyseSem(boolean b) {
		analyseSem = b;
	}
}
