# Parcial4_Estructura_dDatos
lo que sea
//Método Radix incompleto

public class Main {
    public static void main(String[] args) throws Exception {
        int array[] = {1,34,41,545,2,65,3,89,100,25,22,19,54,9,21,34,7,90};
        
        array = radix(array);
        
        System.out.println("Array ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
    
    static int[] radix(int datos[]){
        Cola punteros[] = new int[10];
        int bandera = mayorRadix(datos)-1; //---> Devlover longitud
        int unidadIndex;
        char unidad;
        int j=0; //---> Variable para tener referencia de la unidad en la que vas

        while(bandera <= 0){
            //Ciclo para recorrer todos los datos
            for(int i=0; i<datos.length; i++){
                unidadIndex = (datos[i].length-1)-j; //--> índice de la unidad en la que va
                
                if(unidadIndex < 0){
                    unidad = '0';
                }else{
                    unidad = datos[i].charAtIndex(unidadIndex); //--> El valor en ese ínidice 
                }
                elegirCubeta(datos[i],unidad, punteros);

                //Otro ciclo que saque los elementos de cada cola de cada índice del array
                int datosIndex = 0;
                for(int p=0; p<punteros.length; p++){
                    while(punteros[p].start != null){
                        datos[datosIndex++] = punteros[p].delete();
                    }
                }
            }j++;
            bandera--;
        }

        return datos;
        
    }
    
    static void elegirCubeta(int dato,char unidad, Cola punteros[]){
        switch (unidad) {
            case '0':
                punteros[0].add(dato);
                break;
            case '1':
                punteros[1].add(dato);  
                break;
            case '2':
                punteros[2].add(dato);
                break;
            case '3':
                punteros[3].add(dato);
                break;
            case '4':
                punteros[4].add(dato);
                break;
            case '5':
                punteros[5].add(dato);
                break;
            case '6':
                punteros[6].add(dato);
                break;
            case '7':
                punteros[7].add(dato);
                break;
            case '8':
                punteros[8].add(dato);
                break;
            case '9':
                punteros[9].add(dato);
                break;
            default:
                break;
        }
    }

    static int mayorRadix(int datos[]){
        int mayor = 0;
        int index = 0;
        while(index < datos.length-1){
            if(datos[i] > mayor){
                mayor = datos[i];
            }
        }
        return mayor;
    }
    
}



