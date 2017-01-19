package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
    }
    
	@Override
	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if(gauche.getType()!="integer" || droite.getType()!="integer"){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "deux expressions entières sont attendues");
		}
	}
    
}
