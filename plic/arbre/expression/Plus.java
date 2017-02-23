package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }
    
	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Somme :\n");
		sb.append(gauche.toMIPS());		//Code cible qui évalue l'opérande gauche et le range dans $v0
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(droite.toMIPS());		//Code cible qui évalue l'opérande droite et le range dans $v0
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");	// Opérande gauche
		sb.append("add $v0, $t8, $v0\n\n");
		
		return sb.toString();
	}

}
