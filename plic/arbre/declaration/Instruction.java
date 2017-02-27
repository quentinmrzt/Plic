package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public class Instruction extends ArbreAbstrait{
	protected Affectation aff;

	public Instruction(int no, Affectation a) {
		super(no);
		aff = a;
	}

	@Override
	public void verifier() {
	}

	@Override
	public String toMIPS() {
		return null;
	}

}
