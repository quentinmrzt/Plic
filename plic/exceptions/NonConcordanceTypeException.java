package plic.exceptions;

public class NonConcordanceTypeException extends AnalyseException{

    public NonConcordanceTypeException(int ligne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : NonConcordanceTypeException") ;
    }
}
