package analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;

%%
%{
    public static LinkedList<TError> errores = new LinkedList<TError>(); 
%}

%public
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

letra = [a-zA-Z0-9] 
id = {letra}+
linea = "//"+[^\n]*
comentario = "<!"[^"!>"]* "!>"
cadena = ([\"][^\n\"]* [\"]) | ([\'][^\n\']* [\'])
separador = [%%]+

ascci = ([a-zA-Z_0-9] | [0-9] | "!" | "#" | "$" | "%" | "&" | "-" | "/" | "<" | "=" | ">" | "@" | "\\" | "^" | "`")

%%

<YYINITIAL> "," {
                    System.out.println("Reconocio token:<coma> lexema:"+yytext());
                    return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
                }
<YYINITIAL> "{" {
                    System.out.println("Reconocio token:<llaveA> lexema:"+yytext());
                    return new Symbol(Simbolos.llaveA, yycolumn, yyline, yytext());
                }
<YYINITIAL> "}" {
                    System.out.println("Reconocio token:<llaveC> lexema:"+yytext());
                    return new Symbol(Simbolos.llaveC, yycolumn, yyline, yytext());
                }
<YYINITIAL> "[" {
                    System.out.println("Reconocio token:<corcheteA> lexema:"+yytext());
                    return new Symbol(Simbolos.corcheteA, yycolumn, yyline, yytext());
                }
<YYINITIAL> "]" {
                    System.out.println("Reconocio token:<corcheteC> lexema:"+yytext());
                    return new Symbol(Simbolos.corcheteC, yycolumn, yyline, yytext());
                }
<YYINITIAL> "(" {
                    System.out.println("Reconocio token:<parentesisA> lexema:"+yytext());
                    return new Symbol(Simbolos.parentesisA, yycolumn, yyline, yytext());
                }
<YYINITIAL> ")" {
                    System.out.println("Reconocio token:<parentesisC> lexema:"+yytext());
                    return new Symbol(Simbolos.parentesisC, yycolumn, yyline, yytext());
                }
<YYINITIAL> "~" {
                    System.out.println("Reconocio token:<rango> lexema:"+yytext());
                    return new Symbol(Simbolos.rango, yycolumn, yyline, yytext());
                }
<YYINITIAL> "->" {
                    System.out.println("Reconocio token:<flecha> lexema:"+yytext());
                    return new Symbol(Simbolos.flecha, yycolumn, yyline, yytext());
                }
<YYINITIAL> "|" {
                    System.out.println("Reconocio token:<or> lexema:"+yytext());
                    return new Symbol(Simbolos.or, yycolumn, yyline, yytext());
                }
<YYINITIAL> "*" {
                    System.out.println("Reconocio token:<klenee> lexema:"+yytext());
                    return new Symbol(Simbolos.klenee, yycolumn, yyline, yytext());
                }
<YYINITIAL> "+" {
                    System.out.println("Reconocio token:<positiva> lexema:"+yytext());
                    return new Symbol(Simbolos.positiva, yycolumn, yyline, yytext());
                }
<YYINITIAL> "?" {
                    System.out.println("Reconocio token:<interrogacion> lexema:"+yytext());
                    return new Symbol(Simbolos.interrogacion, yycolumn, yyline, yytext());
                }
<YYINITIAL> "." {
                    System.out.println("Reconocio token:<concat> lexema:"+yytext());
                    return new Symbol(Simbolos.concat, yycolumn, yyline, yytext());
                }
<YYINITIAL> ":" {
                    System.out.println("Reconocio token:<dospuntos> lexema:"+yytext());
                    return new Symbol(Simbolos.dospuntos, yycolumn, yyline, yytext());
                }
<YYINITIAL> ";" {
                    System.out.println("Reconocio token:<puntoycoma> lexema:"+yytext());
                    return new Symbol(Simbolos.puntoycoma, yycolumn, yyline, yytext());
                }
<YYINITIAL> {ascci} {
                    System.out.println("Reconocio token:<ascii> lexema:"+yytext());
                    return new Symbol(Simbolos.ascii, yycolumn, yyline, yytext());
                }
<YYINITIAL> {separador} {
                    System.out.println("Reconocio token:<separador> lexema:"+yytext());
                    return new Symbol(Simbolos.separador, yycolumn, yyline, yytext());
                }
<YYINITIAL> "CONJ" {
                    System.out.println("Reconocio token:<conj> lexema:"+yytext());
                    return new Symbol(Simbolos.conj, yycolumn, yyline, yytext());
                 }
<YYINITIAL> {id} {
                    System.out.println("Reconocio token:<id> lexema:"+yytext());
                    return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                 }
<YYINITIAL> {cadena} {
                    System.out.println("Reconocio token:<cadena> lexema:"+yytext());
                    return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext());
                 }
<YYINITIAL> "\'" {
                    System.out.println("Reconocio token:<comillaS> lexema:"+yytext());
                    return new Symbol(Simbolos.comillaS, yycolumn, yyline, yytext());
                 }
<YYINITIAL> "\"" {
                    System.out.println("Reconocio token:<comillaC> lexema:"+yytext());
                    return new Symbol(Simbolos.comillaC, yycolumn, yyline, yytext());
                 }
[ \t\r\n\f]      { /* Espacios en blanco, se ignoran */ }
{linea}     { System.out.println("Comentario de una linea"); }
{comentario}     { System.out.println("Comentario multilinea"); }
.               
                {
                    System.out.println("Error Lexico : "+yytext()+
                    "Linea: "+yyline+" Columna: "+yycolumn);
                    TError tmp= new TError("Lexico", yytext(),"Caracter no encontrado", yyline, yycolumn );
                    errores.add(tmp);  
                }

