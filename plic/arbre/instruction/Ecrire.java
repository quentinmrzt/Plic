package plic.arbre.instruction;

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
		StringBuilder sb = new StringBuilder();
		if(exp == null){
			sb.append("\t# Ecrire une chaine :\n");
			sb.append(".data\n");
			sb.append("str" + this.hashCode() + ":\t .asciiz " + str.replace("\"\"", "\\\"") + "\n");
			sb.append(".text\n");
			sb.append("li $v0, 4\n");
			sb.append("la $a0, str" + this.hashCode() + "\n");
			sb.append("syscall\n");
		}else{
			sb.append(exp.toMIPS());
			sb.append("\t# Ecrire une expression :\n");
			if(exp.getType().equals("entier")){
				sb.append("move $t2, $v0\n");
				sb.append("li $v0, 1\n");
				sb.append("move $a0, $t2\n");
				sb.append("syscall\n");
			}else{
				sb.append("si" + this.hashCode() + ": beqz $v0, sinon" + this.hashCode() + "\n");
				sb.append("alors" + this.hashCode() + ": .data\n");
				sb.append("str1_" + this.hashCode() + ":\t .asciiz \"vrai\"\n");
				sb.append(".text\n");
				sb.append("li $v0, 4\n");
				sb.append("la $a0, str1_" + this.hashCode() + "\n");
				sb.append("j finsi" + this.hashCode() + "\n");
				sb.append("sinon" + this.hashCode() + ": .data\n");
				sb.append("str2_" + this.hashCode() + ":\t .asciiz \"faux\"\n");
				sb.append(".text\n");
				sb.append("li $v0, 4\n");
				sb.append("la $a0, str2_" + this.hashCode() + "\n");
				sb.append("finsi" + this.hashCode() + ":\n");
				sb.append("syscall\n");
			}
		}
		
		return sb.toString();
	}

}
