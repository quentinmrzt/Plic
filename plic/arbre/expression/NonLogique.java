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
		return "booleen";
	}
	
	@Override
	public void verifier() {
		expression.verifier();
		if(!expression.getType().equals("booleen")){
			throw new AnalyseSemantiqueException(expression.getNoLigne(), "une expression booleenne est attendue");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# NonLogique :\n");		
		sb.append("li $v0, 1\n");
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(expression.toMIPS());
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("sub $v0, $t8, $v0\n\n");
		
		return sb.toString();
	}

}
