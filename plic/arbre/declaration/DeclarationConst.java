package plic.arbre.declaration;

import plic.TDS.TDS;
import plic.arbre.identificateur.Identificateur;
import plic.arbre.instruction.ListeInstruction;

public class DeclarationConst extends Declaration{
	protected Identificateur idf;
	protected ListeInstruction linst;
	protected int num;

	public DeclarationConst(int no, Identificateur i, ListeInstruction li, int noBloc) {
		super(no, noBloc);
		idf = i;
		linst = li;
	}
	
	public String getIdf(){
		return idf.getNom();
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int n){
		num = n;
	}
	
	public void setNoBlocInstruction() {
		TDS.getInstance().entreeBloc();
		TDS.getInstance().setDicoCourant(TDS.getInstance().getNoBloc());
		noBloc  = TDS.getInstance().getDicoCourant();
		if(linst != null)
			linst.setNoBloc();

		TDS.getInstance().setDicoCourant(TDS.getInstance().sortieBloc().getDicoEnglobant());
	}

	public void ajoutVar() {
		if (linst != null)
			linst.ajoutVar();
	}

	@Override
	public void verifier(){
		TDS.getInstance().setDicoCourant(noBloc);
		if(linst != null)
			linst.verifier();
	}

	@Override
	public String toMIPS(){
		TDS.getInstance().setDicoCourant(noBloc);
		StringBuilder sb = new StringBuilder();
		if(linst != null){
			sb.append("move $s7, $sp \n");
			sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(noBloc).getTailleZoneVariable() + "\n");
			sb.append(linst.toMIPS());
			sb.append("move $sp, $s7 \n");
			sb.append("addi $s7, $s7, " + -TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getDicoEnglobant()).getTailleZoneVariable() + "\n");
		}
		return sb.toString();
	}

}
