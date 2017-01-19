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
	
	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# MoinsUnaire :\n");		
		sb.append("li $v0, 0\n");
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(expression.toMIPS());
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("sub $v0, $t8, $v0\n");
		
		return sb.toString();
	}
	
}
