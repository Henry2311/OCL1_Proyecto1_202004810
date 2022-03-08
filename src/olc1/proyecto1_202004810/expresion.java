
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
                    String temp="";
                    if(".".equals(aux[i])){
                        temp = "("+aux[i+1]+aux[i+2]+")";
                    }else if("|".equals(aux[i])){
                        temp = "("+aux[i+1]+aux[i]+aux[i+2]+")";
                    }
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
        String save []=aux.clone();
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            Hoja hojas [] = new Hoja[aux.length];
            int primero=1;
            for (int i = 0; i < aux.length; i++) {
                if(!Operador(aux[i])){
                    Hoja h = new Hoja("F",String.valueOf(primero),String.valueOf(primero),aux[i],i,String.valueOf(primero));
                    hojas[i]=h;
                    primero++;
                }else{
                    if("*".equals(aux[i]) | "?".equals(aux[i])){
                        Hoja h = new Hoja("V","","",aux[i],i,"");
                        hojas[i]=h;
                    }else{
                        Hoja h = new Hoja("","","",aux[i],i,"");
                        hojas[i]=h;
                    }
                }
            }
            Arbol arb = new Arbol(hojas,aux);
            Hoja nodos_arb[] = arb.setTree();
        reporte1 = new FileWriter("ARBOLES_202004810\\Arbol"+nombre+".dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("node[shape=\"oval\" style =filled]");
        pw.println("nodesep=2;");
        
        String nodos[]=new String[aux.length];
        int contador=1;
        for (int j = 0; j < aux.length; j++) {  
            String valor = nodos_arb[j].getValor().replaceAll("\"", "");
            valor = valor.replaceAll("\\\"", "");
            pw.println("node"+contador+"[fixedsize=true; label=<\n" +
                            "  <TABLE CELLSPACING=\"2\" CELLPADDING=\"15\" BORDER=\"0\" CELLBORDER=\"0\">\n" +
                                "  <TR>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD >"+nodos_arb[j].getAnulable()+"</TD>\n" +
                                "    <TD ></TD>\n" +
                                "  </TR>\n" +
                                "  <TR>\n" +
                                "    <TD >"+nodos_arb[j].getPrimero()+"</TD>\n" +
                                "    <TD > "+valor+" </TD>\n" +
                                "    <TD >"+nodos_arb[j].getSiguientes()+"</TD>\n" +
                                "  </TR>\n" +
                                "  <TR>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD >"+nodos_arb[j].getVh()+"</TD>\n" +
                                "    <TD ></TD>\n" +
                                "  </TR>\n" +
                                "  </TABLE>\n" +
                                "  >]");
            nodos[j]="node"+contador;
            contador++;
        }
        pw.println("node"+(contador+1)+"[fixedsize=true; label=<\n" +
                            "  <TABLE CELLSPACING=\"2\" CELLPADDING=\"15\" BORDER=\"0\" CELLBORDER=\"0\">\n" +
                                "  <TR>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD >F</TD>\n" +
                                "    <TD ></TD>\n" +
                                "  </TR>\n" +
                                "  <TR>\n" +
                                "    <TD >"+(primero)+"</TD>\n" +
                                "    <TD > # </TD>\n" +
                                "    <TD >"+(primero)+"</TD>\n" +
                                "  </TR>\n" +
                                "  <TR>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD >"+(primero)+"</TD>\n" +
                                "    <TD ></TD>\n" +
                                "  </TR>\n" +
                                "  </TABLE>\n" +
                                "  >]");
        pw.println("node"+(contador+2)+"[fixedsize=true; label=<\n" +
                            "  <TABLE CELLSPACING=\"2\" CELLPADDING=\"15\" BORDER=\"0\" CELLBORDER=\"0\">\n" +
                                "  <TR>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD >F</TD>\n" +
                                "    <TD ></TD>\n" +
                                "  </TR>\n" +
                                "  <TR>\n" +
                                "    <TD >"+nodos_arb[0].getPrimero()+"</TD>\n" +
                                "    <TD > . </TD>\n" +
                                "    <TD >"+(primero)+"</TD>\n" +
                                "  </TR>\n" +
                                "  <TR>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD ></TD>\n" +
                                "    <TD ></TD>\n" +
                                "  </TR>\n" +
                                "  </TABLE>\n" +
                                "  >]");
        arb.Siguientes(primero-1,nombre);
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
        
        String name = aux[0].replaceAll("\"", "");
        name = name.replaceAll("\\\"", "\"");
        pw.println("label = \"\\n\\n\\nMétodo del Arbol "+name+"\";");
        pw.println("}");
        polaca=save;
        //Thompson();
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","ARBOLES_202004810\\Arbol"+nombre+".png","ARBOLES_202004810\\Arbol"+nombre+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
     
    public void Thompson(){
        String[] aux = polaca;
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            
        reporte1 = new FileWriter("AFND_202004810\\AFND"+nombre+".dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("rankdir=\"LR\"\n" +
                    "nodesep = 0.5\n" +
                    "node [shape = \"circle\"] ");
        
        String nodos [] = new String[aux.length];
        int i = 0;
        int estados = 0;
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i])||"|".equals(aux[i])) && (!Operador(aux[i+1])) && (!Operador(aux[i+2]))){
                    if(".".equals(aux[i])){
                        String graphviz = "";
                        graphviz+="S"+estados+" -> S"+(estados+1)+"\n";
                        graphviz+="S"+(estados+1)+" -> S"+(estados+2)+"\n";
                        nodos[i]=nodos[i+1]+" -> "+graphviz;
                        estados+=2;
                    }else if("|".equals(aux[i])){
                        String graphviz = "";
                        graphviz+="S"+estados+" -> S"+(estados+1)+" -> S"+(estados+2)+"\n";
                        graphviz+="S"+estados+" -> S"+(estados+3)+" -> S"+(estados+4)+"\n";
                        graphviz+="S"+(estados+2)+" -> S"+(estados+5)+"\n";
                        graphviz+="S"+(estados+4)+" -> S"+(estados+5)+"\n";
                        nodos[i]=nodos[i+1]+" -> "+graphviz;
                        estados+=5;
                    }
                    String temp = aux[i+1]+aux[i]+aux[i+2];
                    aux[i]=temp;
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    nodos=removeElement(nodos,(i+1));
                    nodos=removeElement(nodos,(i+1));
                    break;
                }else if(("*".equals(aux[i])|"+".equals(aux[i])|"?".equals(aux[i])) && (!Operador(aux[i+1]))){
                    if("*".equals(aux[i])){
                        String graphviz = "";
                        graphviz+=nodos[i+1]+" -> S"+(estados+1)+"\n";
                        graphviz+=nodos[i+1]+" -> "+nodos[i+1]+"\n";
                        graphviz+=nodos[i+1].substring(0,2)+" -> S"+(estados+1);
                        nodos[i]=nodos[i+1]+" -> "+graphviz;
                        estados+=1;
                    }else if("+".equals(aux[i])){
                        String graphviz = "";
                        graphviz+=nodos[i+1]+" -> S"+(estados+1)+"\n";
                        graphviz+=nodos[i+1]+" -> "+nodos[i+1]+"\n";
                        nodos[i]=nodos[i+1]+" -> "+graphviz;
                        estados+=1;
                    }else if("?".equals(aux[i])){
                        String graphviz = "";
                        graphviz+=nodos[i+1]+" -> S"+(estados+1)+"\n";
                        graphviz+=nodos[i+1].substring(0,2)+" -> S"+(estados+1);
                        nodos[i]=nodos[i+1]+" -> "+graphviz;
                        estados+=1;
                    }
                    
                    
                    String temp = "("+aux[i+1]+")"+aux[i];
                    aux[i]=temp;
                    aux=removeElement(aux,(i+1));
                    nodos=removeElement(nodos,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        
        pw.println(nodos[0]);
        pw.println("label = \"AFND "+nombre+"\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","AFND_202004810\\AFND"+nombre+".png","AFND_202004810\\AFND"+nombre+".dot");
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
