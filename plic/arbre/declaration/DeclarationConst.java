package plic.arbre.declaration;

import plic.arbre.instruction.Instruction;

public class DeclarationConst extends Declaration{
	protected Instruction inst;

	public DeclarationConst(int no, Instruction i) {
		super(no);
		inst = i;
	}

	@Override
	public void verifier(){
		inst.verifier();
	}

	@Override
	public String toMIPS(){
		return inst.toMIPS();
	}

}
