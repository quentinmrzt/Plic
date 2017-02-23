package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }
    
	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Différent :\n");
		sb.append(gauche.toMIPS());		//Code cible qui évalue l'opérande gauche et le range dans $v0
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(droite.toMIPS());		//Code cible qui évalue l'opérande droite et le range dans $v0
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");	// Opérande gauche
		sb.append("sne $v0, $t8, $v0\n\n");
		
		return sb.toString();
	}
  
}
