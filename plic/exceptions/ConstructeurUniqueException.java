package plic.exceptions;

public class ConstructeurUniqueException extends AnalyseException {
	
	public ConstructeurUniqueException(int ligne, String m) {
		super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : ConstructeurUniqueException");
	}
}
