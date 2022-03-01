
package olc1.proyecto1_202004810;

public class OLC1Proyecto1_202004810 {

    public static void main(String[] args) {
       try{
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app().setVisible(true);
            }
        });    
       }catch(Exception e){
        
            e.printStackTrace();

        }
        
}
/*Pattern pat = Pattern.compile(listaNombreER.get(i).getER());
                            Matcher mat = pat.matcher(listaEntradaER.get(j).getEntrada());
                            if (mat.matches()) {
                                //System.out.println("SI");
                                //System.out.println(listaEntradaER.get(j).getNombre());
                                listaEntradaER.get(j).setBuena_Mala("buena");
                            } else {
                                //S*/
//cadena = ([\"][^\n\"]* [\"]) | ([\'][^\n\']* [\'])
//comentario = "<!"[^"!>"]* "!>"
//" \/' "
//"\/" "
}
