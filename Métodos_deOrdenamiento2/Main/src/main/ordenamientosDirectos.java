
package main;

public class ordenamientosDirectos {
    
    int datos[];

    public ordenamientosDirectos(int datos[]){
        this.datos = datos;
    }

    public void burbuja(){
        int i,j, pasadas, aux;
        for (pasadas = 0; pasadas < datos.length; pasadas++) {
            i =0;j=1;
            while(j<=datos.length-1){
                if(datos[i] > datos[j]){
                    intercambio(i,j);
                }i++;j++;
            }
        }
    }
    
    public void cocktail(){
        int i,j, pasadas, aux;
        for (pasadas = 0; pasadas < datos.length/2; pasadas++) {
            i =0;j=1;
            while(j<=datos.length-1){
                if(datos[i] > datos[j]){
                    intercambio(i,j);
                }i++;j++;
            }
            i--;j--;
            while(i>=0){
                if(datos[i] > datos[j]){
                    intercambio(i,j);
                }i--;j--;
            }
        }
    }
    
    public void seleccion(){
        int pasada=0, menor, aux;
        while(pasada < datos.length){
            menor = pasada;
            for (int i = pasada; i < datos.length; i++) {
                if(datos[i] < datos[menor]){
                    menor = i;
                }
            }
            aux = datos[menor];
            datos[menor] = datos[pasada];
            datos[pasada] = aux;
            pasada++;
        }
    }
    
    public void insercion(){
        int i,j,aux;
        for (i = 0; i < datos.length-1; i++) {
            if(datos[i] > datos[i+1]){
                aux = datos[i+1]; 
                j = i+1;
                do{
                    datos[j] = datos[--j];
                }while(j > 0 && datos[j-1] > aux);
                datos[j] = aux;
            }
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
