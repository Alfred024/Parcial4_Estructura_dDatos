
package demoradix;

public class DemoRadix {

    public static void main(String[] args) {
        
        int datos[] = {893,34,41,545,2,65,3,89,100,25,22,19,54,9,21,34,7,90};
        int bandera = mayorRadix(datos); 
        int unidadIndex;
        char unidad;
        int j=0;
        Cola cubetas[] = new Cola[10];
        
        while(bandera >= 0){
            for (int i = 0; i < datos.length; i++) {
                unidadIndex = ((datos[i]+"").length()-1)-j;
                
                if(unidadIndex < 0){
                    unidad = '0';
                }else{
                    unidad = (datos[i]+"").charAt(unidadIndex); 
                }
                elegirCubeta(datos[i], unidad, cubetas);
            }
            
            int datosIndex = 0;
            for(int p=0; p<cubetas.length; p++){
                while(cubetas[p].start != null){
                    datos[datosIndex++] = cubetas[p].delete();
                }
            }
            j++;
            bandera--;
        }
        
        System.out.println("Array ordenado");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i]+" ");
        }
        
        
    }
    
    static int mayorRadix(int datos[]){
        int mayor = 0;
        int index = 0;
        while(index < datos.length-1){
            if(datos[index] > mayor){
                mayor = datos[index];
            }index++;
        }
        return (mayor+"").length()-1;
    }
    
    static void elegirCubeta(int dato,char unidad, Cola cubetas[]){
        switch (unidad) {
            case '0':
                cubetas[0].add(dato);
                break;
            case '1':
                cubetas[1].add(dato);
                break;
            case '2':
                cubetas[2].add(dato);
                break;
            case '3':
                cubetas[3].add(dato);
                break;
            case '4':
                cubetas[4].add(dato);
                break;
            case '5':
                cubetas[5].add(dato);
                break;
            case '6':
                cubetas[6].add(dato);
                break;
            case '7':
                cubetas[7].add(dato);
                break;
            case '8':
                cubetas[8].add(dato);
                break;
            case '9':
                cubetas[9].add(dato);
                break;
            default:
                break;
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

class Cola{
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