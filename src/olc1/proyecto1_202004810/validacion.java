
package olc1.proyecto1_202004810;


public class validacion {

    String ER, cadena;

    public validacion(String ER, String cadena) {
        this.ER = ER;
        this.cadena = cadena;
    }

    
    public String info() {
        String data = "";
        data += " Expresion:" + ER;
        data += " cadena:" + cadena;
        return data;
    }
    
    public String getER() {
        return ER;
    }

    public void setER(String ER) {
        this.ER = ER;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    
}
