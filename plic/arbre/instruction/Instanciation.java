package plic.arbre.instruction;

import plic.TDS.*;
import plic.arbre.Classe;
import plic.arbre.identificateur.*;
import plic.exceptions.NonConcordanceTypeException;

public class Instanciation extends Instruction {
	protected Acces acc;
	protected Identificateur idf;

	public Instanciation(int no, Acces a, Identificateur i, int noBloc) {
		super(no, noBloc);
		acc = a;
		idf = i;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setDicoCourant(noBloc);
		acc.verifier();
		if (!idf.getNom().equals(acc.getIdentificateur().getType())){
			throw new NonConcordanceTypeException(noLigne, "Les deux types ne correspondent pas");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		for (Classe c : TDS.getInstance().getListeClasse()){
			if (c.getIdf().equals(idf.getNom())){
				sb.append("move $s7, $sp \n");
				sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable() + "\n");
		        
				if(c.getListeDeclaration() != null){
					sb.append(c.getListeDeclaration().getDeclaration(1).toMIPS());
				}
				for (int i = 0; i > TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable(); i-= 4){
					sb.append("lw $v0, " + i + "($s7)\n\n" );
					
					if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
						sb.append("sw $v0, " + (acc.getIdentificateur().getDeplacement() + i - TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getDicoEnglobant()).getTailleZoneVariable() - TDS.getInstance().getDico(noBloc).getTailleZoneVariable()) + "($s7)\n\n");
					}else{
						sb.append("sw $v0, " + (acc.getIdentificateur().getDeplacement() + i - TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getDicoEnglobant()).getTailleZoneVariable()) + "($s7)\n\n");
					}
				}
				TDS.getInstance().setDicoCourant(noBloc);
				sb.append("move $sp, $s7 \n");
				sb.append("addi $s7, $s7, " + -TDS.getInstance().getDico(noBloc).getTailleZoneVariable() + "\n");
			}
		}
		return sb.toString();
	}

	public void ajoutVar() {
	}

}
