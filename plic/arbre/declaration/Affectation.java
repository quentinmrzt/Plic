package plic.arbre.declaration;

import plic.arbre.expression.*;
import plic.arbre.identificateur.*;
import plic.exceptions.*;

public class Affectation extends Instruction{
	protected Acces acc;
	protected Expression exp;

	public Affectation(int no, Acces a, Expression e) {
		super(no);
		acc = a;
		exp = e;
	}

	@Override
	public void verifier() {
		acc.verifier();
		exp.verifier();
		if(!acc.getIdentificateur().getType().equals(exp.getType())){
			throw new NonConcordanceType("Les types ne correspondent pas");
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
