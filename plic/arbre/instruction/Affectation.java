package plic.arbre.instruction;

import plic.TDS.TDS;
import plic.arbre.expression.*;
import plic.arbre.identificateur.*;
import plic.exceptions.*;

public class Affectation extends Instruction{
	protected Acces acc;
	protected Expression exp;

	public Affectation(int no, Acces a, Expression e, int noBloc) {
		super(no, noBloc);
		acc = a;
		exp = e;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setDicoCourant(noBloc);
		acc.verifier();
		exp.verifier();
		TDS.getInstance().setDicoCourant(noBloc);
		if(!acc.getIdentificateur().getType().equals(exp.getType())){
			throw new NonConcordanceTypeException(noLigne, "Les types ne correspondent pas");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Affectation :\n");
		sb.append(exp.toMIPS());
		sb.append(acc.toMIPS());
		
		return sb.toString();
	}

	public void ajoutVar() {
	}

}
