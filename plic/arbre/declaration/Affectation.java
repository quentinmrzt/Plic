package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.*;
import plic.arbre.identificateur.*;

public class Affectation extends ArbreAbstrait{
	protected Acces acc;
	protected Expression exp;

	public Affectation(int no, Acces a, Expression e) {
		super(no);
		acc = a;
		exp = e;
	}

	@Override
	public void verifier() {
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
