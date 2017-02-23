package plic.exceptions;

public class IdfNonTrouveException  extends AnalyseException{
	
    public IdfNonTrouveException(String m) {
        super("ERREUR SEMANTIQUE :\n\t" + m + " : IdentificationException") ;
    }
    
}
