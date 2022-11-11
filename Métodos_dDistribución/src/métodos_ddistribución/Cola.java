package métodos_ddistribución;

public class Cola{
    Nodo start;
    Nodo end;

    public Cola() {
        this.start = null;
        this.end = null;
    }
    
    public void add(int value){
        Nodo nuevoNodo = new Nodo(value);
        
        if(start == null){
            start = end = nuevoNodo;
        }else{
            end.next = nuevoNodo;
            end = nuevoNodo;
        }
    }
    
    public int delete(){
        if(start == null){
            return -1;
        }else{
            Nodo temp = start;
            start = start.next;
            return temp.value;
        }
    }
}

class Nodo{
    int value;
    Nodo next;
    
    public Nodo(int value) {
        this.value = value;
        this.next = null;
    }
}
