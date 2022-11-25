
package p325;

import java.util.Arrays;
import java.util.Scanner;

public class P325 {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int casosPrueba = sc.nextInt();
        String llaves;
        funcionesHash x;
        
        for (int i = 0; i < casosPrueba; i++) {
            llaves = sc.nextLine();
            x = new funcionesHash(llaves);
            x.doblamiento();
        }*/
        funcionesHash x = new funcionesHash("PASCAL:BASIC:JAVA:C++:PHP");
        x.doblamiento();
    }
    
}

class funcionesHash{
    String llaves;
    
    funcionesHash(String llaves){
        this.llaves = llaves;
    }
    
    public void doblamiento(){
        String indicesClaves[][] = separarClaves(llaves);
        String areaPrimal[] = new String[indicesClaves[1].length];
        int lengthAreaCol = (areaPrimal.length/4)+2;
        String areaColisiones[] = new String[lengthAreaCol];
        Arrays.fill(areaPrimal,"-1");
        Arrays.fill(areaColisiones, "-1");
        int index, colisiones=0, indexColisiones=0;
        
        for (index = 0; index < areaPrimal.length; index++) {
            if(areaPrimal[Integer.parseInt(indicesClaves[0][index])].equals("-1")){
                areaPrimal[Integer.parseInt(indicesClaves[0][index])] = indicesClaves[1][index];
            }else{
                colisiones++;
                while(areaColisiones[indexColisiones] != "-1"){
                    indexColisiones++;
                }
                areaColisiones[indexColisiones] = indicesClaves[1][index];
            }
        }
        
        colisionesPorcentaje(colisiones, areaPrimal.length);
        
    }
    
    public void colisionesPorcentaje(int colisiones, int numLlaves){
        double colisionesD = (double) colisiones;
        double numLLavesD = (double) numLlaves;
        double res = (colisionesD/numLLavesD)*100;
        System.out.println((int)res+"%");
    }
    
    public String[][] separarClaves(String llaves){
        int tamañoHASH = numeroDeLlaves(llaves);
        int indexHASH=0;
        String claveActual, claveActualAux;
        int claveASCII, index;
        String indices[][] =new String[2][tamañoHASH];
        
        for (index = 0; index < llaves.length(); index++) {
            claveActual="";claveActualAux="";
            while(index < llaves.length() && llaves.charAt(index) != ':'){
                claveASCII = llaves.charAt(index);
                claveActualAux += llaves.charAt(index)+"";
                claveActual += claveASCII+"";
                index++;
            }
            indices[0][indexHASH] = (calcularIndexClave(claveActual, tamañoHASH))+"";
            indices[1][indexHASH] = claveActualAux;
            indexHASH++;
        }
        return indices;
    }
    
    public int numeroDeLlaves(String llaves){
        int index = 0;
        int tamañoIndices=1;
        
        while(index < llaves.length()){
            if(llaves.charAt(index++) == ':'){
                tamañoIndices++;
            }
        }
        return tamañoIndices;
    }
    
    public int calcularIndexClave(String clave, int numLlaves){
        String claveP1="",claveP2="";
        int index=0;
        while(index < (clave.length()/2)){
            claveP1+=(clave.charAt(index++)+"");
        }
        while(index < clave.length()){
            claveP2+=(clave.charAt(index++)+"");
        }
        
        index =  (Integer.parseInt(claveP1)+Integer.parseInt(claveP2)) % numLlaves;
        return index;
    }
}

/*for (int i = 0; i < indicesClaves[1].length; i++) {
            System.out.print("Index: "+indicesClaves[0][i]+" ");
            System.out.print("Clave: "+indicesClaves[1][i]+"\n");
        }*/


/*
    System.out.println("Tabla HASH");
        for (int i = 0; i < areaPrimal.length; i++) {
            System.out.print("["+areaPrimal[i]+"]");
        }System.out.println("\nColisiones: "+colisiones);
        
        for (int i = 0; i < indicesClaves[1].length; i++) {
            System.out.print("Index: "+indicesClaves[0][i]+" ");
            System.out.print("Clave: "+indicesClaves[1][i]+"\n");
        }
*/

//funcionesHash x = new funcionesHash("PEDRO:ANA:ANGEL:LUIS:MIGUEL:MARIA:PATRICIA");
        //x.doblamiento();