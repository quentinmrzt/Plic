package plic.exceptions;

/**
 * 10 déc. 2015
 *
 * @author Morizot Pierron
 */

public class AnalyseSemantiqueException extends AnalyseException {
 
    public AnalyseSemantiqueException(int ligne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : erreur de type") ;
    }

}
