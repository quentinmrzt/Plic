package plic.TDS;

import java.util.HashMap;
import plic.exceptions.DoubleDeclException;
import plic.exceptions.IdfNonTrouveException;

public class TDS {
	private static TDS instance = new TDS();
	private int dep = 0;
	private HashMap<Entree, Symbole> tds = new HashMap<Entree, Symbole>();
	
	private TDS(){
	}
	
	public static TDS getInstance(){
		return instance;		
	}
	
	public void ajouter(Entree e, Symbole s, int noligne){
		if(!tds.containsKey(e)){
			tds.put(e, s);
			dep-=4;
		}else{
			throw new DoubleDeclException(noligne, "La variable \"" + e.getIdf() + "\" est déclarée plusieurs fois");
		}
	}
	
	public Symbole identifier(Entree e, int ligne){
		if(tds.containsKey(e)){
			return tds.get(e);
		}else{
			throw new IdfNonTrouveException(ligne, "variable \"" + e.getIdf() + "\" non déclarée");
		}
	}
	
	public int getTailleZoneVariable(){
		return dep;
	}
}
