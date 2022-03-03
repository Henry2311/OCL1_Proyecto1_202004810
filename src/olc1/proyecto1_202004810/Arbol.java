
package olc1.proyecto1_202004810;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arbol {
    
    private static Hoja [] hojas;
    private String [] polaca;

    public Arbol(Hoja[] hojas,String[] polaca) {
        this.hojas = hojas;
        this.polaca = polaca;
    }

    
    public static Hoja[] setTree(){
        Hoja Lnodos[]=hojas.clone();
        Hoja aux[]=Lnodos.clone();
        int i = 0;
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i].getValor())||"|".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor())) && (!Operador(aux[i+2].getValor()))){
                    if("V".equals(aux[i+1].getAnulable()) && "V".equals(aux[i+2].getAnulable())){
                        for (int j = 0; j < Lnodos.length; j++) {
                            if(aux[i].getId()==Lnodos[j].getId()){
                                aux[i].setAnulable("V");
                                Lnodos[i].setAnulable("V");
                            }
                        }
                    }else{
                        for (int j = 0; j < Lnodos.length; j++) {
                            if(aux[i].getId()==Lnodos[j].getId()){
                                aux[i].setAnulable("F");
                                Lnodos[i].setAnulable("F");
                            }
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    break;
                }else if(("*".equals(aux[i].getValor())|"+".equals(aux[i].getValor())|"?".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor()))){
                    if("V".equals(aux[i+1].getAnulable()) && "+".equals(aux[i].getValor())){
                        for (int j = 0; j < Lnodos.length; j++) {
                            if(aux[i].getId()==Lnodos[j].getId()){
                                aux[i].setAnulable("V");
                                Lnodos[i].setAnulable("V");
                            }
                        }
                    }else if("F".equals(aux[i+1].getAnulable()) && "+".equals(aux[i].getValor())){
                        for (int j = 0; j < Lnodos.length; j++) {
                            if(aux[i].getId()==Lnodos[j].getId()){
                                aux[i].setAnulable("F");
                                Lnodos[i].setAnulable("F");
                            }
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        i=0;
        aux=Lnodos.clone();
        for (int j = 0; j < aux.length; j++) {
           if(".,".equals(aux[j].getValor()) || "|,".equals(aux[j].getValor()) || "+,".equals(aux[j].getValor()) || "?,".equals(aux[j].getValor()) || "*,".equals(aux[j].getValor())){
               aux[j].setValor(aux[j].getValor().replaceAll(",",""));
           }
        }
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i].getValor())||"|".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor())) && (!Operador(aux[i+2].getValor()))){
                    if(".".equals(aux[i].getValor())){
                        if("V".equals(aux[i].getAnulable())){
                            for (int j = 0; j < Lnodos.length; j++) {
                                if(aux[i].getId()==Lnodos[j].getId()){
                                    aux[i].setPrimero(aux[i+1].getPrimero()+", "+aux[i+2].getPrimero());
                                    Lnodos[i].setPrimero(aux[i+1].getPrimero()+", "+aux[i+2].getPrimero());
                                }
                            }
                        }else{
                            for (int j = 0; j < Lnodos.length; j++) {
                                if(aux[i].getId()==Lnodos[j].getId()){
                                    aux[i].setPrimero(aux[i+1].getPrimero());
                                    Lnodos[i].setPrimero(aux[i+1].getPrimero());
                                }
                            }
                        }
                    }else if("|".equals(aux[i].getValor())){
                        for (int j = 0; j < Lnodos.length; j++) {
                            if(aux[i].getId()==Lnodos[j].getId()){
                                aux[i].setPrimero(aux[i+1].getPrimero()+", "+aux[i+2].getPrimero());
                                Lnodos[i].setPrimero(aux[i+1].getPrimero()+", "+aux[i+2].getPrimero());
                            }
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    break;
                }else if(("*".equals(aux[i].getValor())|"+".equals(aux[i].getValor())|"?".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor()))){
                    for (int j = 0; j < Lnodos.length; j++) {
                        if(aux[i].getId()==Lnodos[j].getId()){
                            aux[i].setPrimero(aux[i+1].getPrimero());
                            Lnodos[i].setPrimero(aux[i+1].getPrimero());
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        
        i=0;
        aux=Lnodos.clone();
        for (int j = 0; j < aux.length; j++) {
           if(".,".equals(aux[j].getValor()) || "|,".equals(aux[j].getValor()) || "+,".equals(aux[j].getValor()) || "?,".equals(aux[j].getValor()) || "*,".equals(aux[j].getValor())){
               aux[j].setValor(aux[j].getValor().replaceAll(",",""));
           }
        }
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i].getValor())||"|".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor())) && (!Operador(aux[i+2].getValor()))){
                    if(".".equals(aux[i].getValor())){
                        if("V".equals(aux[i].getAnulable())){
                            for (int j = 0; j < Lnodos.length; j++) {
                                if(aux[i].getId()==Lnodos[j].getId()){
                                    aux[i].setSiguientes(aux[i+1].getSiguientes()+", "+aux[i+2].getSiguientes());
                                    Lnodos[i].setSiguientes(aux[i+1].getSiguientes()+", "+aux[i+2].getSiguientes());
                                }
                            }
                        }else{
                            for (int j = 0; j < Lnodos.length; j++) {
                                if(aux[i].getId()==Lnodos[j].getId()){
                                    aux[i].setSiguientes(aux[i+2].getSiguientes());
                                    Lnodos[i].setSiguientes(aux[i+2].getSiguientes());
                                }
                            }
                        }
                    }else if("|".equals(aux[i].getValor())){
                        for (int j = 0; j < Lnodos.length; j++) {
                            if(aux[i].getId()==Lnodos[j].getId()){
                                aux[i].setSiguientes(aux[i+1].getSiguientes()+", "+aux[i+2].getSiguientes());
                                Lnodos[i].setSiguientes(aux[i+1].getSiguientes()+", "+aux[i+2].getSiguientes());
                            }
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    break;
                }else if(("*".equals(aux[i].getValor())|"+".equals(aux[i].getValor())|"?".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor()))){
                    for (int j = 0; j < Lnodos.length; j++) {
                        if(aux[i].getId()==Lnodos[j].getId()){
                            aux[i].setSiguientes(aux[i+1].getSiguientes());
                            Lnodos[i].setSiguientes(aux[i+1].getSiguientes());
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        
        for (int j = 0; j < Lnodos.length; j++) {
            if(".,".equals(Lnodos[j].getValor()) || "|,".equals(Lnodos[j].getValor()) || "+,".equals(Lnodos[j].getValor()) || "?,".equals(Lnodos[j].getValor()) || "*,".equals(Lnodos[j].getValor())){
               Lnodos[j].setValor(Lnodos[j].getValor().replaceAll(",",""));
            }
            System.out.println("NODO: "+Lnodos[j].getValor()+" ANULABILIDAD: "+Lnodos[j].getAnulable()+" PRIMEROS: "+Lnodos[j].getPrimero()+" ULTIMOS: "+Lnodos[j].getSiguientes());
        }
        
        hojas=Lnodos;
        return Lnodos;
    }
        
    public static Hoja[] removeElement( Hoja[] arr, int index ){
        List<Hoja> tempList = new ArrayList<>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new Hoja[0]);
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
    
    public static void Siguientes(int contador, String nombre){
        Hoja siguientes[]=hojas.clone();
        Hoja aux[]=siguientes.clone();
        Siguientes temp_s[] = new Siguientes[contador];
        int c=0;
        for (int i = 0; i < aux.length; i++) {
            if(!Operador(aux[i].getValor())){
                String[] t = {""};
                Siguientes s = new Siguientes(String.valueOf(c+1),t);
                temp_s[c]=s;
                c++;
            }
        }
        int i = 0;
        while(aux.length>1){
            while(i<aux.length){
                if((".".equals(aux[i].getValor())||"|".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor())) && (!Operador(aux[i+2].getValor()))){
                    if(".".equals(aux[i].getValor())){
                        for (int j = 0; j < siguientes.length; j++) {
                            if(aux[i].getId()==siguientes[j].getId()){
                                String ult[]=aux[i+1].getSiguientes().split(",");
                                String s[]=aux[i+2].getPrimero().split(",");
                                for (int k = 0; k < ult.length; k++) {
                                    for (int l = 0; l < temp_s.length; l++) {
                                        String x = ult[k].replaceAll(" ", "");
                                        System.out.println(ult[k]+", "+temp_s[l].getHoja());
                                        if(x.equals(temp_s[l].getHoja())){
                                            System.out.println("AL ID: "+temp_s[l].getHoja()+" AÑADI: "+Arrays.toString(s));
                                            String nuevo[]=join(temp_s[l].getSiguientes(), s);
                                            temp_s[l].setSiguientes(nuevo);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    aux=removeElement(aux,(i+1));
                    break;
                }else if(("*".equals(aux[i].getValor())|"+".equals(aux[i].getValor())|"?".equals(aux[i].getValor())) && (!Operador(aux[i+1].getValor()))){
                    if(("*".equals(aux[i].getValor())|"+".equals(aux[i].getValor()))){
                        for (int j = 0; j < siguientes.length; j++) {
                            if(aux[i].getId()==siguientes[j].getId()){
                                String ult[]=aux[i].getSiguientes().split(",");
                                String s[]=aux[i].getPrimero().split(",");
                                for (int k = 0; k < ult.length; k++) {
                                    for (int l = 0; l < temp_s.length; l++) {
                                        String x = ult[k].replaceAll(" ", "");
                                        System.out.println(ult[k]+temp_s[l].getHoja());
                                        if(x.equals(temp_s[l].getHoja())){
                                            System.out.println("AL ID: "+temp_s[l].getHoja()+" AÑADI: "+Arrays.toString(s));
                                            String nuevo[]=join(temp_s[l].getSiguientes(), s);
                                            temp_s[l].setSiguientes(nuevo);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    aux[i].setValor(aux[i].getValor()+",");
                    aux=removeElement(aux,(i+1));
                    break;
                }
                i++;    
            }
            i=0;
        }
        
        for (int j = 0; j < temp_s.length; j++) {
            System.out.println("HOJA: "+temp_s[j].getHoja()+" SIGUIENTES: "+Arrays.toString(temp_s[j].getSiguientes()));
        }
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            
        reporte1 = new FileWriter("Transiciones"+nombre+".dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("node[shape=\"box\"]");
        String graphviz = "a1[label=<";
        graphviz+=" <TABLE>\n" +
                        "<TR>\n" +
                        "<TD >NODO</TD>\n" +
                        "   <TD>HOJA</TD>\n" +
                        "   <TD >SIGUIENTE</TD>\n" +
                        "</TR>";
            for (int j = 0; j < temp_s.length; j++) {
                graphviz+="<TR>";
                for (int k = 0; k < siguientes.length; k++) {
                    if(temp_s[j].getHoja().equals(siguientes[k].getVh())){
                        graphviz+="<TD >"+siguientes[k].getValor()+"</TD>";
                    }
                }
                graphviz+="<TD >"+temp_s[j].getHoja()+"</TD>";
                String sg="";
                String[]ssg=temp_s[j].getSiguientes();
                for (int k = 1; k < ssg.length; k++) {
                    sg+=ssg[k]+", ";
                }
                graphviz+="<TD >"+sg+"</TD>";
                graphviz+="</TR>";
            }
            
        graphviz+="</TABLE>>]";
        
        pw.println(graphviz);
        
        pw.println("label = \"Tabla de Transiciones de "+nombre+"\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Transiciones"+nombre+".png","Transiciones"+nombre+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
        
    }
    
    public static String[] join(String[] arr1,String[] arr2){
    
        String j [] = new String[arr1.length+arr2.length];
        int indice=0;
        for (int i = 0; i < arr1.length; i++) {
            j[indice]=arr1[i];
            indice++;
        }
        for (int i = 0; i < arr2.length; i++) {
            j[indice]=arr2[i];
            indice++;
        }
        return j;
    }
    
    public Hoja[] getHojas() {
        return hojas;
    }

    public void setHojas(Hoja[] hojas) {
        this.hojas = hojas;
    }
    
    
    
}
