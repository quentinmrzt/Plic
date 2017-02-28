package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

idf = [a-zA-Z][a-zA-Z0-9]*
csteE = [0-9]+
csteB = "vrai" | "faux"
entreGui = [\"\"] | [^\"]
csteC = [\"]{entreGui}*[\"]

commentaireSlashSlash = [/][/].*

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%%

"+"                	{ return symbol(CodesLexicaux.PLUS); }
"-"                	{ return symbol(CodesLexicaux.MOINS); }
"*"                	{ return symbol(CodesLexicaux.MULT); }
"/"                	{ return symbol(CodesLexicaux.DIV); }

"="						{ return symbol(CodesLexicaux.EGAL); }
"=="                    { return symbol(CodesLexicaux.EGALEGAL); }
"!="                    { return symbol(CodesLexicaux.DIFF); }
"<"                	{ return symbol(CodesLexicaux.INF); }
">"                	{ return symbol(CodesLexicaux.SUP); }

"et"                	{ return symbol(CodesLexicaux.ET); }
"ou"                	{ return symbol(CodesLexicaux.OU); }
"non"                	{ return symbol(CodesLexicaux.NON); }

"("                	{ return symbol(CodesLexicaux.PAROUV); }
")"                	{ return symbol(CodesLexicaux.PARFER); }

";"					{ return symbol(CodesLexicaux.POINTVIRGULE); }
","					{ return symbol(CodesLexicaux.VIRGULE); }

"publique"			{ return symbol(CodesLexicaux.PUBLIQUE); }
"privee"			{ return symbol(CodesLexicaux.PRIVEE); }
"entier"			{ return symbol(CodesLexicaux.ENTIER); }
"classe"			{ return symbol(CodesLexicaux.CLASS); }
"fin"				{ return symbol(CodesLexicaux.FIN); }
"ecrire"			{ return symbol(CodesLexicaux.ECR); }

{csteE}      	        { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	        { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }
{csteC}      	        { return symbol(CodesLexicaux.CONSTANTECHAINE, yytext()); }

{idf}					{ return symbol(CodesLexicaux.IDF, yytext()) ; }

<YYINITIAL>{commentaireSlashSlash} { }

{espace}                { }

.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
