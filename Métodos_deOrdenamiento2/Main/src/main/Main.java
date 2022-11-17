
package main;

public class Main {

    public static void main(String[] args) {
        
        /*int array[] = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*1000+1);
        }*/
        
        int array[] = {24,54,2,89,80,99,10,21,55,65,5,70,45,88,59,46,77,20};
        ordenamientosDirectosA x = new ordenamientosDirectosA(array);
        
        System.out.println("");
        x.shell();
        x.printData();
    }

}

//2 5 10 20 21 24 45 46 54 55 59 65 70 77 80 88 89 99
