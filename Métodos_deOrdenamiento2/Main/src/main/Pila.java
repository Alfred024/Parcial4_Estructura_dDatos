
package main;

public class Pila {
    Nodo tope;
    Pila(){
        tope=null;
    }
    void push(int LI, int LS){
        Nodo temp;
        temp = new Nodo(LI, LS);
        if(tope==null)
            tope = temp;
        else{
            temp.next=tope;
            tope=temp;
        }
    }
    Nodo pop(){
        Nodo temp;
        temp = tope;
        if(tope!=null)
            tope=tope.next;
        return temp;
    }
}

class Nodo{
    int LI;
    int LS;
    Nodo next;
    
    Nodo(int LI, int LS){
        this.LI=LI;
        this.LS=LS;
        this.next=null;
    }
}