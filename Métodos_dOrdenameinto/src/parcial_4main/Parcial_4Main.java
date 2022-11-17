
package parcial_4main;

public class Parcial_4Main {

    public static void main(String[] args) {
        //Java hace los redondeos hacia arriba???
        
        /*int array[] = new int[20];
        for (int i = 0; i <array.length ; i++) {
            array[i] = (int) (Math.random()*100+1);
        }*/
        int array[] = {8,43,17,6,40,16,18,97,11,7};
        
        ordenamientos_Avanzados x = new ordenamientos_Avanzados();
        x.quickSort2(array);
        
        System.out.println("Array ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
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