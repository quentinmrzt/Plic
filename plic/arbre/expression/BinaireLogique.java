package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
	public String getType() {
		return "boolean";
	}
	
	@Override
	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if(gauche.getType()!="boolean" || droite.getType()!="boolean"){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "deux expressions booléennes sont attendues");
		}
	}
    
}
