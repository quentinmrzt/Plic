package plic.TDS;

public class Symbole {
	protected String[] symboles;

	public Symbole(String... sym){
		symboles = new String[sym.length];
		for(int i = 0; i < sym.length; i++){
			symboles[i] = sym[i];
		}
	}
	
}
