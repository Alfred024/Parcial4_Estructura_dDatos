package parcial_4main;

public class metodos_De_Ordenamiento{

    //Tiempo de ejecución: 0.07s
    public static int[] ordenamientoBurbuja(int datos[]){
        int limite = datos.length-1;
        int aux;
        int vuelta;
        for (int j=0; j<datos.length; j++){ 
            for(vuelta = 0; vuelta < limite; vuelta++){
            if(datos[vuelta] > datos[vuelta+1]){
                aux = datos[vuelta+1];
                datos[vuelta+1] = datos[vuelta];
                datos[vuelta] = aux;
            }
            }limite--;
        }   
        return datos;
    }

    //Tiempo de ejecución: 0.07s
    public static int[] cocktail(int datos[]){
        int limInferior=0;
        int limSuperior=datos.length-1;
        int recorridos = datos.length-1;
        int aux;

        while(limSuperior-limInferior >= 2){
            for(int mayor=limInferior; mayor<recorridos; mayor++){
                if(datos[mayor] > datos[mayor+1]){
                    aux = datos[mayor+1];
                    datos[mayor+1] = datos[mayor];
                    datos[mayor] = aux; 
                }
            }
    
            for(int menor=limSuperior; menor>limInferior; menor--){
                if(datos[menor] < datos[menor-1]){
                    aux = datos[menor-1];
                    datos[menor-1] = datos[menor];
                    datos[menor] = aux; 
                }
            }
            recorridos-=2;
            limInferior++;
            limSuperior--;
        }
        return datos;
    }

    //Tiempo de ejecución: 0.08s
    public static int[] seleccion(int datos[]){
        int menor;
        int muro=0;
        int indexAux=0;
        int aux;
        while(muro < datos.length-1){
            menor = datos[muro];
            for(int i = muro+1; i < datos.length; i++){
                if(datos[i]<menor){
                    menor = datos[i];
                    indexAux = i;
                }
            }
            aux = datos[muro];
            datos[indexAux] = aux;
            datos[muro] = menor;
            muro++;
        }

        return datos;
    }

    //Tiempo de ejecución: 0.07s
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
    
    public static void insercionCopiado(int A[]){                                            
    int p, j;
    int aux;
    for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
              aux = A[p];           // el final, guardamos el elemento y
              j = p - 1;            // empezamos a comprobar con el anterior
              while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el                                
                                                // valor de aux sea menor que los
                             A[j + 1] = A[j];   // de la izquierda, se desplaza a
                             j--;               // la derecha
              }
              A[j + 1] = aux;       // colocamos aux en su sitio
    }
}

    //INCOMPLETO
    public int[] torneo(int datos[]){
        int winners[] = new int[(datos.length/2)+1];
        //int winners[] = datos;
        int lastOpponent;
        int comparaciones = winners.length;

        //Este while habrá que ejecutarlo la longitud del arreglo-1
        while(comparaciones != 0){
            int newLimit; //nos ayuda a estalecer el nuevo punto de partida para comparar a los nuevos ganadores
            int indexWinner=0;
            if(comparaciones%2 == 0){
                for(int i=0; i<comparaciones/2; i+=2){
                    if(winners[i] > winners[i+1]){
                        
                    }else{

                    }
                    indexWinner++;
                }
                comparaciones/=comparaciones;
            }else{
                for(int i=0; i<comparaciones/2; i+=2){
                    indexWinner++;
                }
                comparaciones/=comparaciones+1;
            }
        }
        
        return winners;
    }

}