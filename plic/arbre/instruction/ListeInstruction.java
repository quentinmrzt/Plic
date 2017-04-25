package plic.arbre.instruction;

import java.util.ArrayList;

import plic.TDS.TDS;
import plic.arbre.ArbreAbstrait;

public class ListeInstruction extends ArbreAbstrait{
	protected ArrayList<Instruction> li;

	public ListeInstruction(int no) {
		super(no);
		li = new ArrayList<Instruction>();
	}
	
	public void ajouter(Instruction i){
		li.add(i);
	}
	
	public void setNoBloc(){		
		for(Instruction i : li){
			i.setNoBloc(TDS.getInstance().getDicoCourant());
		}
	}

	public void ajoutVar() {
		for (Instruction i : li){
			i.ajoutVar();
		}
	}

	@Override
	public void verifier() {
		for(Instruction i : li){
			i.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		for(Instruction i : li){
			sb.append(i.toMIPS());
		}
		return sb.toString();
	}
}