package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public abstract class Declaration extends ArbreAbstrait{
	protected int noBloc;
	
	public Declaration(int no, int noBloc) {
		super(no);
		this.noBloc = noBloc;
	}
	
	public abstract void setNoBlocInstruction();
	
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
