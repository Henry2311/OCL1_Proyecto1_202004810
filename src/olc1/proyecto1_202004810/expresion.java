
package olc1.proyecto1_202004810;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class expresion {

    String nombre;
    String [] polaca;

    public expresion(String nombre, String [] polaca) {
        this.nombre = nombre;
        this.polaca = polaca;
    }

    public String[] estructura(String[] arr){
        String aux []= arr;
        String save []=arr.clone();
        int i = 0;
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i])||"|".equals(aux[i])) && (!Operador(aux[i+1])) && (!Operador(aux[i+2]))){
                    String temp = aux[i+1]+aux[i]+aux[i+2];
                    aux[i]=temp;
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    break;
                }else if(("*".equals(aux[i])|"+".equals(aux[i])|"?".equals(aux[i])) && (!Operador(aux[i+1]))){
                    String temp = "("+aux[i+1]+")"+aux[i];
                    aux[i]=temp;
                    aux=removeElement(aux,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        polaca=save;
        return aux;
    }
    
     public void graph(){
        String aux[]=polaca;
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            Hoja hojas [] = new Hoja[aux.length];
            int primero=1;
            for (int i = 0; i < aux.length; i++) {
                if(!Operador(aux[i])){
                    Hoja h = new Hoja("F",String.valueOf(primero),String.valueOf(primero),aux[i]);
                    hojas[i]=h;
                    primero++;
                }else{
                    if("*".equals(aux[i]) | "?".equals(aux[i])){
                        Hoja h = new Hoja("V","","",aux[i]);
                        hojas[i]=h;
                    }else{
                        Hoja h = new Hoja("","","",aux[i]);
                        hojas[i]=h;
                    }
                }
            }
            Arbol arb = new Arbol(hojas,aux);
            arb.Anulable();
        reporte1 = new FileWriter("Arbol"+nombre+".dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("node[shape=\"oval\" style =filled]");
        
        String nodos[]=new String[aux.length];
        int contador=1;
        for (int j = 0; j < aux.length; j++) {  
            pw.println("node"+contador+"[label=\""+aux[j].replaceAll("\"", "")+"\"]");
            nodos[j]="node"+contador;
            contador++;
        }
        pw.println("node"+(contador+1)+"[label=\"#\"]");
        pw.println("node"+(contador+2)+"[label=\".\"]");
        
        int i=0;
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i])||"|".equals(aux[i])) && (!Operador(aux[i+1])) && (!Operador(aux[i+2]))){
                    String temp = aux[i+1]+aux[i]+aux[i+2];
                    String temp_n = nodos[i]+"->"+nodos[i+1]+"\n"+nodos[i]+"->"+nodos[i+2]+"\n";
                    aux[i]=temp;
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    nodos[i]=temp_n;
                    nodos=removeElement(nodos,(i+1));
                    nodos=removeElement(nodos,(i+1));
                    break;
                }else if(("*".equals(aux[i])|"+".equals(aux[i])|"?".equals(aux[i])) && (!Operador(aux[i+1]))){
                    String temp = "("+aux[i+1]+")"+aux[i];
                    String temp_n = nodos[i]+"->"+nodos[i+1]+"\n";
                    aux[i]=temp;
                    aux=removeElement(aux,(i+1));
                    nodos[i]=temp_n;
                    nodos=removeElement(nodos,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        
        pw.println("node"+(contador+2)+"->"+nodos[0]);
        pw.println("node"+(contador+2)+"->node"+(contador+1));
        
        pw.println("label = \"Método del Arbol "+aux[0].replaceAll("\"", "")+"\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Arbol"+nombre+".png","Arbol"+nombre+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
    
    
    public static String[] removeElement( String[] arr, int index ){
        List<String> tempList = new ArrayList<>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new String[0]);
    }
    public static boolean Operador(String op){
        if("*".equals(op)){
            return true;
        }else if(".".equals(op)){
            return true;
        }else if("?".equals(op)){
            return true;
        }else if("+".equals(op)){
            return true;
        }else if("|".equals(op)){
            return true;
        }
        return false;
    }
    

    
    public String info() {
        String data = "",n="",m="";
        data += " nombre:" + nombre;
        String ER [] = estructura(polaca);
        for (int i=0;i<ER.length;i++) {
            n += ER[i];
        }
        for (int i=0;i<polaca.length;i++) {
            m += polaca[i];
        }
        data += " polaca:" + m;
        data += " ER:" + n;
        graph();
        return data;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getPolaca() {
        return polaca;
    }

    public void setPolaca(String[] polaca) {
        this.polaca = polaca;
    }

    
}
