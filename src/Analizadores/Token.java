
package analizadores;


public class Token {
    
    String tipo, lexema;
    int linea, columna;
    
    public Token(String tipo, String lexema, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public String show() {
        String data = "";
        data += " tipo:" + tipo;
        data += " lexema:" + lexema;
        data += " linea:" + String.valueOf(linea);
        data += " columna:" + String.valueOf(columna);
        return data;
    }
}
