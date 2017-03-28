package plic.exceptions;

public class ConditionNonBoolException extends AnalyseException{

	public ConditionNonBoolException(int ligne, String m) {
		super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : ConditionNonBoolException") ;
	}

}
