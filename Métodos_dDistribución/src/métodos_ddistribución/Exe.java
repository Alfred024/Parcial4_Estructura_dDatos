
package métodos_ddistribución;

public class Exe {

    public static void main(String[] args) {

        int array[] = {206,298,61,68,117,157,229,63,288,184,250,218,90,296,120,65};
        //int array[] = new int[20];
        /*for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000 - 100);
        }*/
        
        Mezcla_Directa y = new Mezcla_Directa(array);
        y.merge();
        
        System.out.println("Array ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        
        /*Radix x = new Radix();
        x.radix(array);
        
        System.out.println("Array ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }*/
    }

    
    
}






