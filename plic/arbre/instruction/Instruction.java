package plic.arbre.instruction;

import plic.arbre.ArbreAbstrait;

public abstract class Instruction extends ArbreAbstrait{
	protected int noBloc;

	public Instruction(int no, int noBloc) {
		super(no);
		this.noBloc = noBloc;
	}
	
	public int getNoBloc() {
		return noBloc;
	}

	public void setNoBloc(int nb) {
		this.noBloc = nb;
	}

	@Override
	public abstract void verifier();

	@Override
	public abstract String toMIPS();

}
