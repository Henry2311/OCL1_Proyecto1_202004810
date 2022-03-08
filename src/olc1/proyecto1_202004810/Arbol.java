
package olc1.proyecto1_202004810;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                                        if(x.equals(temp_s[l].getHoja())){
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
                                        if(x.equals(temp_s[l].getHoja())){
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
        
        String ult[]=siguientes[0].getSiguientes().split(",");
            String s[]={String.valueOf(c+1)};
            for (int k = 0; k < ult.length; k++) {
                for (int l = 0; l < temp_s.length; l++) {
                    String x = ult[k].replaceAll(" ", "");
                    if(x.equals(temp_s[l].getHoja())){
                        String nuevo[]=join(temp_s[l].getSiguientes(), s);
                        temp_s[l].setSiguientes(nuevo);
                    }
                }
            } 
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            
        reporte1 = new FileWriter("SIGUIENTES_202004810\\Siguientes"+nombre+".dot");
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
            
            
            
                graphviz+="<TR>";
                graphviz+="<TD >#</TD>";
                graphviz+="<TD >"+(c+1)+"</TD>";
                graphviz+="<TD > -- </TD>";
                graphviz+="</TR>";
            
        graphviz+="</TABLE>>]";
        
        pw.println(graphviz);
        
        pw.println("label = \"Tabla de Siguientes de "+nombre+"\";");
        pw.println("}");
        
        Transiciones(temp_s,nombre);
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","SIGUIENTES_202004810\\Siguientes"+nombre+".png","SIGUIENTES_202004810\\Siguientes"+nombre+".dot");
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
    
    public static void Transiciones(Siguientes[] sig, String nombre){
    
        List<Transiciones> trans = new ArrayList<>();
        String t[]=hojas[0].getPrimero().split(",");
        String term = "";
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < hojas.length; j++) {
                if(t[i].equals(hojas[j].getVh())){
                    term+=hojas[j].getValor()+",";
                }
            }
        }
        Transiciones S0 = new Transiciones("S0",t,term.split(","));
        trans.add(S0);
        
        for (int i = 0; i < sig.length; i++) {
            String temp[]=sig[i].getSiguientes();
            String terminales = "";
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < hojas.length; k++) {
                    String x = temp[j].replaceAll(" ", "");
                    if(x.equals(hojas[k].getVh()) && !"".equals(x) && !" ".equals(x)){
                        terminales+=hojas[k].getValor()+",";
                    }
                }
            }
            Transiciones S = new Transiciones("S"+(i+1),temp,terminales.split(","));
            trans.add(S);
        }
        trans=duplicado(trans);
        
        int state = 0;
        for (Transiciones tran : trans) {
            tran.setEstado("S"+state);
            state++;
        }
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        FileWriter AFD = null;
        PrintWriter pw_afd = null;
        try{
            
        reporte1 = new FileWriter("TRANSICIONES_202004810\\Transiciones"+nombre+".dot");
        pw = new PrintWriter(reporte1);
      
        pw.println("digraph G {");
        pw.println("node[shape=\"box\"]");
        String graphviz = "a1[label=<";
        graphviz+=" <TABLE>\n" +
                        "<TR>\n" +
                        "<TD >ESTADOS</TD>\n" +
                        "   <TD>TERMINALES</TD>\n"+ 
                        "</TR>\n";
        
            List<String> terminales = new ArrayList<>(); 
            List<String> vh = new ArrayList<>();
            for (int i = 0; i < hojas.length; i++) {
                if(!"".equals(hojas[i].getVh())){
                    vh.add(hojas[i].getValor());
                    terminales.add(hojas[i].getVh());
                }
            }
            Set<String> hashset = new HashSet<>(vh);
            vh.clear();
            vh.addAll(hashset);
            
            String matrix [][] = new String[trans.size()+1][vh.size()+1];
            matrix[0][0]="<TD></TD>";
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                   if(j==0 && !"<TD></TD>".equals(matrix[i][j])){
                       matrix[i][j]=trans.get(i-1).getEstado();
                   }else if(i==0 && !"<TD></TD>".equals(matrix[i][j])){
                       matrix[i][j]=vh.get(j-1);
                   }else{
                       matrix[i][j]="--";
                   }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0].equals(trans.get(i-1).getEstado())) {
                    String movs [] = trans.get(i-1).getMovimiento();
                    for (int j = 0; j < movs.length; j++) {
                        for (int k = 0; k < hojas.length; k++) {
                            String x = movs[j].replaceAll(" ", "");
                            if (x.equals(hojas[k].getVh())) {
                                String colum = hojas[k].getValor();
                                for (int l = 1; l < matrix[0].length; l++) {
                                    if(colum.equals(matrix[0][l])){
                                        int max = Integer.parseInt(hojas[k].getVh());
                                        if(max>=trans.size()){
                                            matrix[i][l]="S"+String.valueOf(trans.size()-1);
                                        }else{
                                            matrix[i][l]="S"+hojas[k].getVh();
                                        } 
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            for (int i = 0; i < matrix.length; i++) {
                graphviz+="<TR>";
                for (int j = 0; j < matrix[i].length; j++) {
                    graphviz+="<TD>"+matrix[i][j]+"</TD>";
                }
                graphviz+="</TR>";
            }
    
            
        graphviz+="</TABLE>>]";
        
        pw.println(graphviz);
        
        pw.println("label = \"Tabla de Transiciones de "+nombre+"\";");
        pw.println("}");
        
        AFD = new FileWriter("AFD_202004810\\AFD"+nombre+".dot");
        pw_afd = new PrintWriter(AFD);
        
        pw_afd.println("digraph G {");
        pw_afd.println("rankdir=\"LR\"\n" +
                        "nodesep = 0.5\n" +
                        "node [shape = \"circle\"] ");
        
        pw_afd.println(matrix[matrix.length-1][0]+"[shape = \"doublecircle\"]");
        
        String automata = "";
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if(!"--".equals(matrix[i][j])){
                        String label;
                        if("\"\\\"\"".equals(matrix[0][j])){
                            label = "\\\"";
                        }else{ 
                            label = matrix[0][j].replaceAll("\"", "");
                        }
                        automata+=matrix[i][0]+" -> "+matrix[i][j]+"[label=\""+label+"\"]\n";
                    }
                }
            }
        
            pw_afd.println(automata);
            pw_afd.println("label = \"AFD de "+nombre+"\";");
            pw_afd.println("}");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TRANSICIONES_202004810\\Transiciones"+nombre+".png","TRANSICIONES_202004810\\Transiciones"+nombre+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();   
                    AFD.close();
                    ProcessBuilder build = new ProcessBuilder("dot","-Tpng","-o","AFD_202004810\\AFD"+nombre+".png","AFD_202004810\\AFD"+nombre+".dot");
                    build.redirectErrorStream(true);
                    build.start(); 
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
    public static List duplicado(List<Transiciones> t){
        Transiciones temporal [] = new Transiciones[t.size()];
        for (int i = 0; i < temporal.length; i++) {
            temporal[i]=t.get(i);
        }
        
        int i=0;
        while(i<temporal.length-1){
            String actual []= temporal[i].getTerminal();
            String siguiente []= temporal[i+1].getTerminal();
            String ac="",sig="";
            for (int j = 0; j < actual.length; j++) {
                ac+=actual[j];
            }
            for (int j = 0; j < siguiente.length; j++) {
                sig+=siguiente[j];
            }
            String nactu []= temporal[i].getMovimiento();
            String nsig []= temporal[i+1].getMovimiento();
            String nac="",nsigu="";
            for (int j = 0; j < nactu.length; j++) {
                nac+=nactu[j];
            }
            for (int j = 0; j < nsig.length; j++) {
                nsigu+=nsig[j];
            }
            if(ac.equals(sig) && nac.equals(nsigu)){
                temporal=removeDuplicado(temporal,i+1);
                i=0;
            }
            i++;
        }
        List<Transiciones> temp = new ArrayList<>(Arrays.asList(temporal));
        return temp;
    }
    
    public static Transiciones[] removeDuplicado( Transiciones[] arr, int index ){
        List<Transiciones> tempList = new ArrayList<>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new Transiciones[0]);
    }
    
    public Hoja[] getHojas() {
        return hojas;
    }

    public void setHojas(Hoja[] hojas) {
        this.hojas = hojas;
    }
    
    
    
}
