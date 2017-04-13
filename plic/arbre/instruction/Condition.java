package plic.arbre.instruction;

import plic.arbre.expression.Expression;
import plic.exceptions.ConditionNonBoolException;

public class Condition extends Instruction {
	protected Expression exp;
	protected ListeInstruction liSi;
	protected ListeInstruction liSinon;

	public Condition(int no, Expression e, ListeInstruction l1, ListeInstruction l2) {
		super(no);
		exp = e;
		liSi = l1;
		liSinon = l2;
	}

	@Override
	public void verifier() {
		if(!exp.getType().equals("booleen")){
			throw new ConditionNonBoolException(this.getNoLigne(), "L'expression d'une condition doit etre de type booleenne");
		}else{
			exp.verifier();
			if(liSi!=null)
				liSi.verifier();
			if(liSinon!=null)
				liSinon.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t# Condition :\n");
		sb.append(exp.toMIPS());
		sb.append("si" + this.hashCode() + ": beqz $v0, sinon" + this.hashCode() + "\n");
		sb.append("alors" + this.hashCode() + ":\n");
		if(liSi != null){
			sb.append(liSi.toMIPS());
		}
		sb.append("j finsi" + this.hashCode() + "\n");
		sb.append("sinon" + this.hashCode() + ":\n");
		if(liSinon != null){
			sb.append(liSinon.toMIPS());
		}
		sb.append("finsi" + this.hashCode() + ":\n");
		return sb.toString();
	}

}
