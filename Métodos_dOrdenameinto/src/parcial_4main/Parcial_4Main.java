
package parcial_4main;

public class Parcial_4Main {

    public static void main(String[] args) {
        //Java hace los redondeos hacia arriba???
        
        /*int array[] = new int[20];
        for (int i = 0; i <array.length ; i++) {
            array[i] = (int) (Math.random()*10000+1);
        }*/
        int array[] = {24,54,2,89,80,11,10,3,55,65,5,70,45,88,114,46,77,1};
        
        array = shellCopiado(array);
        
        System.out.println("Array ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        
    }
    //1 2 5 3 10 24 11 45 46 54 65 55 70 80 77 89 88 114
    
    public static int[] shellCopiado(int array[]){
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
    
}
//
//public static int[] quickSort(int datos[], int LI, int LS){
//        int i=LI,j=LS;
//        int aux;
//        int pivote = ((j-i))/2;
//        System.out.println("Pivote: "+pivote);
//        //if(pivote > 0){
//            while(i < j){
//                if(datos[i] < datos[pivote]){
//                    i++;
//                }
//                if(datos[j] > datos[pivote]){
//                    j--;
//                }
//                if(datos[i] > datos[j]){
//                    aux = datos[i];
//                    datos[i] = datos[j];
//                    datos[j] = datos[i];
//                    i++;j--;
//                }
//            }
//            //quickSort(datos,0,pivote-1);
//           // quickSort(datos,pivote,datos.length-1);
//        //}
//        
//        return datos;
//    }
//    