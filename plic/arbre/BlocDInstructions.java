package plic.arbre;

import plic.TDS.TDS;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions(int n) {
        super(n) ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
    }
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

	@Override
	public void verifier() {
		expr.verifier();
	}

	@Override
	public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append(".text\nmain :\n");
        sb.append("move $s7, $sp\n");
        sb.append("addi $sp, $sp, " + TDS.getInstance().getTailleZoneVariable() + "\n");
        sb.append(expr.toMIPS());
        sb.append("\nend :\n");
        sb.append("# Fin du programme\n");
        sb.append("move $v1, $v0\t# copie de v0 dans v1 pour permettre les tests de plic0\n");
        sb.append("li $v0, 10\t# retour au système\n");
        sb.append("syscall\n");
        
		return sb.toString();
	}

}
