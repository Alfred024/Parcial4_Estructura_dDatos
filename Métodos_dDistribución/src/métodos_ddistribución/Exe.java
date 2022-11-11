
package métodos_ddistribución;

public class Exe {

    public static void main(String[] args) {
        int array[] = {893,34,41,545,2,65,3,89,100,25,22,19,54,9,21,34,7,90};
        //int array[] = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000 - 100);
        }
        
        Mezcla_Directa y = new Mezcla_Directa(array);
        y.merge();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        
        
        /*Radix x = new Radix();
        x.radix(array);
        
        System.out.println("Array ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+" ");
        }*/
    }
}






