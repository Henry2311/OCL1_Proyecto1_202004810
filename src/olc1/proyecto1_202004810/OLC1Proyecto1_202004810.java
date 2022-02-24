
package olc1.proyecto1_202004810;

import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;
import java.io.BufferedReader;
import java.io.FileReader;

public class OLC1Proyecto1_202004810 {

    public static void main(String[] args) {
       try{
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app().setVisible(true);
            }
        });
            //String cadena = "Compiladores,Henry,Rocio,Me,Quiero,Morir,Odio,aqui";
            Analizador_Lexico lexico = new Analizador_Lexico(
                                        new BufferedReader(new FileReader("D:\\Henry\\USAC\\5to semestre\\Compi1\\analizar.txt")));
            Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
            sintactico.parse();
            
           
       }catch(Exception e){
        
            e.printStackTrace();

        }
        
}

//cadena = ([\"][^\n\"]* [\"]) | ([\'][^\n\']* [\'])
//comentario = "<!"[^"!>"]* "!>"
//" \/' "
//"\/" "
}
