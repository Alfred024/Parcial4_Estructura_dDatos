package parcial_4main;

public class ordenamientos_Avanzados{
    
    public int[] quickSort(int datos[], int LI, int LS){
        int i=LI,j=LS;
        int aux;
        int pivote = (j-i)/2;

        if(pivote != 0){
            while(i <= j){
                if(datos[i] < datos[pivote]){
                    i++;
                }
                if(datos[j] > datos[pivote]){
                    j++;
                }
                if(datos[i] <= datos[j]){
                    aux = datos[i];
                    datos[i] = datos[j];
                    datos[j] = datos[i];
                    i++;j--;
                }
            }
            quickSort(datos,0,pivote-1);
            quickSort(datos,pivote,datos.length-1);
        }
        
        //Falta algo que haga decrecer al pivote???

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

    public static int[] insercion(int datos[]){
        int empiezo = 0;
        int aux;
        while(empiezo < datos.length-1){
            if(datos[empiezo]>datos[empiezo+1]){
                aux = datos[empiezo+1];
                int index = empiezo+1;
                while(index != 0 && datos[index-1] > aux){
                    datos[index] = datos[index-1];
                    index--;
                }
                datos[index] = aux; 
            }
            empiezo++;
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

    public static int[] shell(int datos[]){
        int salto = datos.length/3;
        int i,aux;

        while(salto > 0){
            i=0;

            for (int k = 0; k < salto-1; k++) {
                //Recorrido para adelante
                while(i<datos.length-1 && datos.length-i >= salto){
                    if(datos[i] > datos[i+salto]){
                        aux = datos[i];
                        datos[i] = datos[i+salto];
                        datos[i+salto] = datos[i]; 
                    }i+=salto; 
                }
                //Recorrido para atrás
                /*i-=salto;
                while(j != 0){
                    if(datos[j] < datos[i]){
                        aux = datos[i];
                        datos[i] = datos[j];
                        datos[j] = datos[i]; 
                    }i-=salto; j-=salto;
                }*/
                i=k;
            }
            salto = (salto/3)+1;
        }
        return datos;
    }
}