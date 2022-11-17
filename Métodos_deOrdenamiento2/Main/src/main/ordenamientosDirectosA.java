
package main;

public class ordenamientosDirectosA {
    int datos[];
    Pila stack;

    public ordenamientosDirectosA(int datos[]){
        this.datos = datos;
    }
    
    /*También denomidado: Método de inserción por incrementos decrecientes*/
    public void shell(){
        int salto = datos.length/3;
        int i,j,aux;
         
        while(salto > 1){
            for (i = 0; i < salto; i++) {
                j = i;
                while(j < datos.length-salto){
                    if(datos[j] > datos[j+salto]){
                        aux = datos[j+salto]; 
                        while(j >= 0 && datos[j] > aux){
                            datos[j+salto] = datos[j];
                            j-=salto;
                        }j+=salto;
                        datos[j] =aux;
                    }
                    j+=salto;
                }
            }
            salto = (salto/3)+1;
        }
    }
    
    public void heapSort(){
        
    }
    
    public void printData(){
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i]+" ");
        }
    }
}
