package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public String getType() {
		return "integer";
	}

	@Override
	public void verifier() {
		expression.verifier();
		if(expression.getType()!="integer"){
			throw new AnalyseSemantiqueException(expression.getNoLigne(), "une expression entière est attendue");
		}
	}
	
}
