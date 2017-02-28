package plic.exceptions;

public class NonConcordanceType extends AnalyseException{

    public NonConcordanceType(String m) {
        super("ERREUR SEMANTIQUE :\n\t" + m + " : NonConcordanceType") ;
    }
}
