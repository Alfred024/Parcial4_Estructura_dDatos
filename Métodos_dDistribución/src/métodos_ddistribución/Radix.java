
package métodos_ddistribución;

public class Radix{
    Cola[] cubetas = new Cola[10];
    
    void radix(int datos[]){
        crearCubetas(cubetas);
        
        int bandera = mayorRadix(datos); 
        int unidadIndex;
        char unidad;
        int j=0;
        
        while(bandera >= -1){
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
    }
    
    void crearCubetas(Cola[] cubetas){
        Cola newCubeta;
        for (int i = 0; i < cubetas.length; i++) {
            newCubeta = new Cola();
            cubetas[i] = newCubeta;
        }
    }
    
    void elegirCubeta(int dato,char unidad, Cola cubetas[]){
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
    
    int mayorRadix(int datos[]){
        int mayor = 0;
        int index = 0;
        while(index < datos.length-1){
            if(datos[index] > mayor){
                mayor = datos[index];
            }index++;
        }
        return (mayor+"").length()-1;
    }
    
}