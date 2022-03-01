
package olc1.proyecto1_202004810;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Arbol {
    
    private Hoja [] hojas;
    private String [] polaca;

    public Arbol(Hoja[] hojas,String[] polaca) {
        this.hojas = hojas;
        this.polaca = polaca;
    }

    
    public void Anulable(){
        
        Hoja nodos[]=hojas;
        String aux[]=polaca;
        String save []=aux.clone();
        int i = 0;
        int exit =aux.length;
        while(exit>1){
            while(i<aux.length){
                if((".".equals(aux[i])||"|".equals(aux[i])) && (!"".equals(nodos[i+1].getAnulable())) && (!"".equals(nodos[i+1].getAnulable()))){
                    if("V".equals(nodos[i+1].getAnulable()) && "V".equals(nodos[i+2].getAnulable())){
                            nodos[i].setAnulable("V");
                    }else{nodos[i].setAnulable("F");}
                    
                }else if(("*".equals(aux[i])|"+".equals(aux[i])|"?".equals(aux[i])) && (!"".equals(nodos[i+1].getAnulable()))){
                    if("V".equals(nodos[i+1].getAnulable()) && "+".equals(aux[i])){
                            nodos[i].setAnulable("V");
                    }else if("F".equals(nodos[i+1].getAnulable()) && "+".equals(aux[i])){
                        nodos[i].setAnulable("F");
                    }
                    
                }
                i++;    
            }
            i=0;
            exit--;
        }
        i = 0;
        exit =aux.length;
        while(exit>1){
            while(i<aux.length){
                if((".".equals(aux[i])||"|".equals(aux[i])) && (!"".equals(nodos[i+1].getPrimero())) && (!"".equals(nodos[i+2].getPrimero()))){
                    if(".".equals(aux[i])){
                        if("V".equals(nodos[i].getAnulable())){
                            nodos[i].setPrimero(nodos[i+1].getPrimero()+", "+nodos[i+2].getPrimero());
                        }else{nodos[i].setPrimero(nodos[i+1].getPrimero());}
                    }else if("|".equals(aux[i])){
                        nodos[i].setPrimero(nodos[i+1].getPrimero()+", "+nodos[i+2].getPrimero());
                    } 
                }else if(("*".equals(aux[i])|"+".equals(aux[i])|"?".equals(aux[i])) && (!"".equals(nodos[i+1].getPrimero()))){
                    nodos[i].setPrimero(nodos[i+1].getPrimero());
                }
                i++;    
            }
            i=0;
            exit--;
        }
        i = 0;
        exit =aux.length;
        while(exit>1){
            while(i<aux.length){
                if((".".equals(aux[i])||"|".equals(aux[i])) && (!"".equals(nodos[i+1].getSiguientes())) && (!"".equals(nodos[i+2].getSiguientes()))){
                    if(".".equals(aux[i])){
                        if("V".equals(nodos[i].getAnulable())){
                            nodos[i].setSiguientes(nodos[i+1].getSiguientes()+", "+nodos[i+2].getSiguientes());
                        }else{nodos[i].setSiguientes(nodos[i+2].getSiguientes());}
                    }else if("|".equals(aux[i])){
                        nodos[i].setSiguientes(nodos[i+1].getSiguientes()+", "+nodos[i+2].getSiguientes());
                    } 
                }else if(("*".equals(aux[i])|"+".equals(aux[i])|"?".equals(aux[i])) && (!"".equals(nodos[i+1].getSiguientes()))){
                    nodos[i].setSiguientes(nodos[i+1].getSiguientes());
                }
                i++;    
            }
            i=0;
            exit--;
        }
        i = 0;
        
        polaca = save;
        for (int j = 0; j < nodos.length; j++) {
            System.out.println("NODO: "+nodos[j].getValor()+" ANULABILIDAD: "+nodos[j].getAnulable()+" PRIMEROS: "+nodos[j].getPrimero()+" ULTIMOS: "+nodos[j].getSiguientes());
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
    
    
    
    public Hoja[] getHojas() {
        return hojas;
    }

    public void setHojas(Hoja[] hojas) {
        this.hojas = hojas;
    }
    
    
    
}
