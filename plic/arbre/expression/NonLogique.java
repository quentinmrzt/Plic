package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public String getType() {
		return "boolean";
	}
	
	@Override
	public void verifier() {
		expression.verifier();
		if(expression.getType()!="boolean"){
			throw new AnalyseSemantiqueException(expression.getNoLigne(), "une expression booléenne est attendue");
		}
	}

}
