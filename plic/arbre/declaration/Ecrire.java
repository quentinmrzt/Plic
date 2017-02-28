package plic.arbre.declaration;

import plic.arbre.expression.*;

public class Ecrire extends Instruction{
	protected Expression exp;
	protected String str;

	public Ecrire(int no, Expression e) {
		super(no);
		exp = e;
		str = null;
	}
	
	public Ecrire(int no, String s) {
		super(no);
		str = s;
		exp = null;
	}

	@Override
	public void verifier() {
		if(str == null)
			exp.verifier();
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
