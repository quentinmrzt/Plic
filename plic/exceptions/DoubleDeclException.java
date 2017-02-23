package plic.exceptions;

public class DoubleDeclException extends AnalyseException{
	
    public DoubleDeclException(String m) {
        super("ERREUR SYNTAXIQUE :\n\t" + m + " : DoubleDeclarationException") ;
    }
    
}
