package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Multiplication :\n");
		sb.append(gauche.toMIPS());
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(droite.toMIPS());
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("mul $v0, $t8, $v0\n");
		
		return sb.toString();
	}
    
}
