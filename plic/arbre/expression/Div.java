package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }
    
	@Override
	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if(droite.toString().equals("0")){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "la division par zero est impossible");
		}
		if(gauche.getType()!="integer" || droite.getType()!="integer"){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "deux expressions entières sont attendues");
		}
	}
    
}
