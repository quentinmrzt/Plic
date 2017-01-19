package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

	public String getType() {
		return "boolean";
	}
	
	@Override
	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if(gauche.getType() != droite.getType()){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "deux expressions du même type sont attendues");
		}
	}
	
}
