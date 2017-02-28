package plic.exceptions;

public class IdfNonTrouveException  extends AnalyseException{
	
    public IdfNonTrouveException(int ligne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : IdentificationException") ;
    }
    
}
