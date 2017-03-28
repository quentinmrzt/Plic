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
		return "booleen";
	}
	
	@Override
	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if(!gauche.getType().equals("booleen") || !droite.getType().equals("booleen")){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "deux expressions booleennes sont attendues");
		}
	}
    
}
