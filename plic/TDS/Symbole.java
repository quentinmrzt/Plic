package plic.TDS;

public class Symbole {
	protected String[] symboles;
	protected int dep;

	public Symbole(int d, String... sym){
		symboles = new String[sym.length];
		for(int i = 0; i < sym.length; i++){
			symboles[i] = sym[i];
		}
		dep = d;
	}

	public String getType() {
		return symboles[0];
	}
	
	public int getDeplacement(){
		return dep;
	}
	
}
