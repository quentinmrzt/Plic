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
		if(!gauche.getType().equals("entier") || !droite.getType().equals("entier")){
			throw new AnalyseSemantiqueException(gauche.getNoLigne(), "deux expressions entieres sont attendues");
		}
	}
	
	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Division :\n");
		sb.append(gauche.toMIPS());		//Code cible qui évalue l'opérande gauche et le range dans $v0
		sb.append("sw $v0, 0($sp)\n");
		sb.append("add $sp, $sp, -4\n");
		sb.append(droite.toMIPS());		//Code cible qui évalue l'opérande droite et le range dans $v0
		sb.append("add $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");	// Opérande gauche
		sb.append("div $v0, $t8, $v0\n\n");
		
		return sb.toString();
	}
    
}
