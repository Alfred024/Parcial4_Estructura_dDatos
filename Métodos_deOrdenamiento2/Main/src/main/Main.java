
package main;

public class Main {

    public static void main(String[] args) {
        
        int array[] = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*1000+1);
        }
        
        //int array[] = {10,11,121,92,1899,3,42,91,78,14,1};
        ordenamientosDirectos x = new ordenamientosDirectos(array);
        x.insercion();
        x.printData();
        
    }

}
