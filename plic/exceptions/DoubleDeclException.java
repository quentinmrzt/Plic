package plic.exceptions;

public class DoubleDeclException extends AnalyseException{
	
    public DoubleDeclException(int ligne, String m) {
        super("ERREUR SYNTAXIQUE :\n\tligne " + ligne + "\n\t" + m + " : DoubleDeclarationException") ;
    }
    
}
