
package main;

public class Main {

    public static void main(String[] args) {
        
        /*int array[] = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*1000+1);
        }*/
        
        int array[] = {24,54,2,89,80,99,10,21,55,65,5,23,12};
        ordenamientosDirectosA x = new ordenamientosDirectosA(array);
        
        System.out.println("Heapsort");
        x.heapSort();
        x.printData();
        
       
    }

    
    public static int[] heapSort(int datos[]){
        
        int padreActual = (datos.length/2)-1;
        int hijoIzq, hijoDer;
        int muro = datos.length-1;
        int aux;
        
        while(muro >= 0){
            while(padreActual >= 0){
                hijoIzq = (padreActual*2)+1;
                hijoDer = (padreActual*2)+2;
                
                if(datos[padreActual] < datos[hijoIzq]){
                    aux = datos[hijoIzq];
                    datos[hijoIzq] = datos[padreActual];
                    datos[padreActual] = aux;
                }
                
                if(datos[padreActual] < datos[hijoDer]){
                    aux = datos[hijoDer];
                    datos[hijoDer] = datos[padreActual];
                    datos[padreActual] = aux;
                }padreActual--;
            }
            
            aux = datos[0];
            datos[0] = datos[muro];
            datos[muro] = aux;
            muro--;
            padreActual = (muro/2)-1;
        }
        return datos;
    }
    
    public static int[] quickSort2(int datos[]){
        Pila stack = new Pila();
        Nodo temp;
        int i,j, aux;
        int LI=0,LS=datos.length-1;
        int pivote;
        stack.push(LI, LS);
        
        do{
            temp = stack.pop();
            i = temp.LI;
            j = temp.LS;
            LI = i;
            LS = j;
            pivote  = datos[(LI+LS)/2];
            
            while(i<=j){
                while(datos[i] < pivote){i++;}
                while(datos[j] > pivote){j--;}
                if(i<=j){
                    aux = datos[i];
                    datos[i] = datos[j];
                    datos[j] = aux;
                    i++;
                    j--;
                }
            }
           
            if(LS-i > 0){
                stack.push(i, LS);
            }
            
            if(j-LI > 0){
                stack.push(LI, j);
            }

        }while(stack.tope != null);

        return datos;
    }
}

//2 5 10 20 21 24 45 46 54 55 59 65 70 77 80 88 89 99
