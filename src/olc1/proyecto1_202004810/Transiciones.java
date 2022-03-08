
package olc1.proyecto1_202004810;

public class Transiciones {

    String estado;
    String [] movimiento,terminal;
    
    public Transiciones(String estado, String[] movimiento, String[] terminal) {
        this.estado = estado;
        this.movimiento = movimiento;
        this.terminal = terminal;
    }

    public String[] getTerminal() {
        return terminal;
    }

    public void setTerminal(String[] terminal) {
        this.terminal = terminal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String[] getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String[] movimiento) {
        this.movimiento = movimiento;
    }
    
    
}
