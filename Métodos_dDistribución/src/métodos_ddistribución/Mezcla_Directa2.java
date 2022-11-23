
package métodos_ddistribución;

public class Mezcla_Directa2 {
    
    int file1[], file2[];
    int datos[];
    
    Mezcla_Directa2(int datos[]){
        this.datos = datos;
        file1 = new int[(datos.length/2)]; 
        file2 = new int[(datos.length-file1.length)];
    }
    
    public void merge(){
        int tamañoGrupo =1;
        distribuir(file1, file2, tamañoGrupo);
        acomodar(file1, file2, tamañoGrupo);
        
        /*while(tamañoGrupo <= (datos.length/2)-1){
            distribuir(file1, file2, tamañoGrupo);
            acomodar(file1, file2, tamañoGrupo);
            tamañoGrupo*=2;
        }*/
    }
    
    public void acomodar(int file1[], int file2[], int tamañoGrupo){
        int i=0,j=0;
        int limiteVuelta = tamañoGrupo;
        int indexDatos=0;
        
        while(limiteVuelta < datos.length-tamañoGrupo){
            while(i<limiteVuelta && j<limiteVuelta){
                if(file1[i] < file2[j]){
                    datos[indexDatos++] = file1[i++];
                }else{
                    datos[indexDatos++] = file2[j++];
                }
            }
            
            if(i >= limiteVuelta && j < limiteVuelta){
                while(j != limiteVuelta){
                    datos[indexDatos++] = file2[j++];
                }
            }
            if(j >= limiteVuelta && i < limiteVuelta){
                while(i != limiteVuelta){
                    datos[indexDatos++] = file1[i++];
                }
            }
            limiteVuelta+=limiteVuelta;
        }
        
        System.out.println("Okei");
        for (int k = 0; k < datos.length; k++) {
            System.out.print(datos[k]+" ");
        }System.out.println("");
        
        /*if(tamañoGrupo == 1){
            if(file2[j] > file2[j+1]){
                intercambio(j,j+1);
            }
        }
        
        
        
        while(i < file1.length && j < file2.length){
            while(i < file1.length && file1[i] < file2[j]){
                datos[indexDatos++] = file1[i++];
            }
            while(j < file2.length && file2[j] < file1[i]){
                datos[indexDatos++] = file2[j++];
            }
        }*/
    }
    
    public void intercambio(int index1, int index2){
        int aux = file2[index1];
        file2[index1] = file2[index2];
        file2[index2] = aux;
    }
    
    public void distribuir(int file1[], int file2[], int tamañoGrupo){
        int indexDatos=0;
        int i=0,j=0;

        while(indexDatos < datos.length){
            if(i < file1.length){
                for (int a = 0; a < tamañoGrupo; a++) {
                    file1[i] = datos[indexDatos];
                    indexDatos++;i++;
                }
            }
            
            for (int b = 0; b < tamañoGrupo; b++) {
                file2[j] = datos[indexDatos];
                indexDatos++;j++;
            }
        }
        
    }
    
}

/*System.out.print("A1--> ");
        for (int k = 0; k < file1.length; k++) {
            System.out.print(file1[k]+" ");
        }System.out.println("");
        System.out.print("A2--> ");
        for (int k = 0; k < file2.length; k++) {
            System.out.print(file2[k]+" ");
        }*/

