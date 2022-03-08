
package analizadores;

public class TError {

    String tipo, lexema, descripcion;
    int linea, columna;

    public TError(String tipo, String lexema, String descripcion, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    public String show() {
        String data = "";
        data += "\ntipo:" + tipo;
        data += "\nlexema:" + lexema;
        data += "\ndescripcion:" + descripcion;
        data += "\nlinea:" + String.valueOf(linea);
        data += "\ncolumna:" + String.valueOf(columna);
        return data;
    }
    
    public String html(){
    
        String rows="";
        
        rows+="<td  style=\"color: red; font-size: 1.2rem;\">"+tipo+"</td>\n";
        rows+="<td  style=\"color: red; font-size: 1.2rem;\">"+lexema+"</td>\n";
        rows+="<td  style=\"color: red; font-size: 1.2rem;\">"+descripcion+"</td>\n";
        rows+="<td  style=\"color: red; font-size: 1.2rem;\">"+String.valueOf(linea)+"</td>\n";
        rows+="<td  style=\"color: red; font-size: 1.2rem;\">"+String.valueOf(columna)+"</td>\n";
    
        return rows;
    }
    
   
}
