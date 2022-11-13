package parcial_4main;

public class ordenamientos_Avanzados{
    
    public static int[] shell(int datos[]){
        int salto = datos.length/3;
        int i,j;
        
        salto = datos.length/3;
        while(salto != 1){
            for (i = 0; i < salto; i++) {
                j=i;
                while((j+salto) <= datos.length-1){
                    if(datos[j+salto] > datos[j]){
                        j+=salto;
                    }else{
                        intercambio(datos, salto, j+salto);
                        j+=salto;
                    }
                }
            }
            salto = (salto/3)+1;
        }
        return datos;
    }
  
    public static void intercambio(int datos[], int salto, int indexActual){
        int i = indexActual;
        int aux;
        while(i-salto>= 0 && datos[i] < datos[i-salto]){
            aux = datos[i];
            datos[i] = datos[i-salto];
            datos[i-salto] = aux;
            i=-salto;
        }
    }

    //En el quicksort las sublistas no necesariamente terminarán en 
    //un número par
    //Quicksort recursivo copiado de un libro
    public int[] quickSort(int datos[], int LI, int LS){
        int i=LI,j=LS;
        int aux;
        int pivote = datos[(LI+LS)/2];

        do{
            while(datos[i] < pivote){
                i++;
            }
            while(datos[j] > pivote){
                j++;
            }
            if(i<=j){
                aux = datos[i];
                datos[i] = datos[j];
                datos[j] = aux;
                i++;j--;
            }
        }while(i <= j);
        
        if(LI<j){
            quickSort(datos, LI, j);
        }

        if(i < LS){
            quickSort(datos, i, LS);
        }
        return datos;
    }

    public int[] quickSort2(int datos[]){
        Pila stack = new Pila();
        nodo temp;
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

    public int[] heapSort(int datos[]){
        
        int padreActual = (datos.length-1)/2;
        int hijoIzq, hijoDer;
        int muro = datos.length-1;
        int aux;
        
        while(muro != 1){
            while(padreActual != -1){
                hijoIzq = (padreActual*2)+1;
                hijoDer = (padreActual*2)+2;
                
                if(datos[padreActual] < datos[hijoIzq]){
                    aux = datos[hijoIzq];
                    datos[hijoIzq] = datos[padreActual];
                    datos[padreActual] = aux;
                }
                
                if(datos[padreActual] < datos[hijoDer]){
                    aux = hijoDer;
                    datos[hijoDer] = datos[padreActual];
                    datos[padreActual] = aux;
                }padreActual--;
            }
            
            datos[muro] = datos[padreActual];
            muro--;
            padreActual = (muro-1)/2;
        }
        return datos;
    }

    public int[] shellCopiado(int array[]){
        int numero=array.length,i,j,k,salto,aux;
        salto=numero/2;
 
        while(salto>0){
            for(i=salto+1;i<=numero;i++){
                j=i-salto;
                while(j>0){
                 if(array[j]>=array[j+salto]){
                  aux = array[j];
                  array[j] = array[j+salto];
                  array[j+salto] = aux;
                 }
                 else{
                   j=0;
                  }
                 j=j-salto;
                }
            }
            salto=salto/2;
        }

        return array;
    }

}

class Pila{
    nodo tope;
    Pila(){
        tope=null;
    }
    void push(int LI, int LS){
        nodo temp;
        temp = new nodo(LI, LS);
        if(tope==null)
            tope = temp;
        else{
            temp.next=tope;
            tope=temp;
        }
    }
    nodo pop(){
        nodo temp;
        temp = tope;
        if(tope!=null)
            tope=tope.next;
        return temp;
    }
}
class nodo{
    int LI;
    int LS;
    nodo next;
    nodo(int LI, int LS){
        this.LI=LI;
        this.LS=LS;
        this.next=null;
    }
}