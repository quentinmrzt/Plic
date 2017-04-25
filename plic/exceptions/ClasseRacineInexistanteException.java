package plic.exceptions;

public class ClasseRacineInexistanteException extends AnalyseException {
	
	public ClasseRacineInexistanteException(int ligne, String m) {
		super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : ClasseRacineInexistanteException");
	}
}
