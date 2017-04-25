package plic.exceptions;

public class TypeIdfInexistantException extends AnalyseException{

	public TypeIdfInexistantException(int ligne, String m) {
		super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : TypeIdfInexistantException");
	}
}
