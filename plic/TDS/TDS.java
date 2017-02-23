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
	
	public void ajouter(Entree e, Symbole s){
		if(!tds.containsKey(e)){
			tds.put(e, s);
		}else{
			throw new DoubleDeclException("double declaration exception");
		}
	}
	
	public Symbole identifier(Entree e){
		if(tds.containsKey(e)){
			return tds.get(e);
		}else{
			throw new IdfNonTrouveException("identifiant non trouve");
		}
	}
	
	public int getTailleZoneVariable(){
		return dep;
	}
}
