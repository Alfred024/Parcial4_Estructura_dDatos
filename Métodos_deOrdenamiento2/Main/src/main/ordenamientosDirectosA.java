
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
        int padreActual = (datos.length/2)-1;
        int hijoIzq, hijoDer;
        int muro = datos.length-1;
        
        while(muro >= 0){
            while(padreActual >= 0){
                hijoIzq = (padreActual*2)+1;
                hijoDer = (padreActual*2)+2;
                
                if(datos[padreActual] < datos[hijoIzq]){
                    intercambio(hijoIzq, padreActual);
                }
                
                if(datos[padreActual] < datos[hijoDer]){
                    intercambio(hijoDer, padreActual);
                }padreActual--;
            }
            intercambio(0,muro);
            muro--;
            padreActual = (muro/2)-1;
        }
    }
    
    public void intercambio(int index1, int index2){
        int aux;
        aux = datos[index1];
        datos[index1] = datos[index2];
        datos[index2] = aux;
    }
    
    public void printData(){
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i]+" ");
        }
    }
}
