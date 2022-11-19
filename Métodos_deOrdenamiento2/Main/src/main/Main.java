
package main;

public class Main {

    public static void main(String[] args) {
        
        int array[] = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*1000+1);
        }
        
        //int array[] = {24,54,2,89,80,99,10,21,55,65,5,23,12,7,300,3,43};
        ordenamientosDirectosA x = new ordenamientosDirectosA(array);
        x.quickSort();
        x.printData();
        
    }
    
}

