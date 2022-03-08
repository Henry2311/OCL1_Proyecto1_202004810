
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
}
