
package olc1.proyecto1_202004810;


public class conjuntos {
    
    String nombre, rango;

    public conjuntos(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    public String info() {
        String data = "";
        data += " nombre:" + nombre;
        data += " rango:" + rango;
        return data;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
    
}

