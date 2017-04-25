package plic.exceptions;

public class IdfClasseConstructeurDiffException extends AnalyseException {
	
	public IdfClasseConstructeurDiffException(int ligne, String m) {
		super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : IdfClasseConstructeurDiffException");
	}
}
