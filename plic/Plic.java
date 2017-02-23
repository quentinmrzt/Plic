package plic ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Plic {
    
    public Plic(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            
            arbre.verifier();            
            System.err.println("expression stockée dans l'arbre : " + arbre + "\n");
            
            StringBuilder sb = new StringBuilder(".text\nmain :\n" + arbre.toMIPS());
            sb.append("\nend :\n");
            sb.append("# Fin du programme\n");
            sb.append("move $v1, $v0\t# copie de v0 dans v1 pour permettre les tests de plic0\n");
            sb.append("li $v0, 10\t# retour au système\n");
            sb.append("syscall\n");
            
            System.out.println("COMPILATION OK");
            compil(sb.toString(), fichier);
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Plic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	public void compil(String code, String fichier) {
		try{
			File f = new File(fichier.substring(0, fichier.length()-5) + ".mips");
			FileWriter fw = new FileWriter(f);
			fw.write(code);
			fw.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar plic.jar <fichierSource.plic>") ;
            System.exit(1) ;
        }
        new Plic(args[0]) ;
    }
    
}
