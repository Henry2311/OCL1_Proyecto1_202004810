
package olc1.proyecto1_202004810;

public class Hoja {

    private String anulable,primero,siguientes,valor;

    public Hoja(String anulable, String primero, String siguientes, String valor) {
        this.anulable = anulable;
        this.primero = primero;
        this.siguientes = siguientes;
        this.valor = valor;
    }

    public String getAnulable() {
        return anulable;
    }

    public String getPrimero() {
        return primero;
    }

    public String getSiguientes() {
        return siguientes;
    }

    public String getValor() {
        return valor;
    }

    public void setAnulable(String anulable) {
        this.anulable = anulable;
    }

    public void setPrimero(String primero) {
        this.primero = primero;
    }

    public void setSiguientes(String siguientes) {
        this.siguientes = siguientes;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}
