package métodos_ddistribución;


public class Mezcla_Directa {
    
    int particion=1;
    int archivo1[], archivo2[];
    int datos[];

    Mezcla_Directa(int datos[]){
        this.datos = datos;
        archivo1 = new int[(datos.length/2)]; //---> Para el caso que el número de elementos a ordenar sea un núero impar
        archivo2 = new int[(datos.length/2)];
    }
    
    //No contempla el caso de los conjuntos impares
    void merge(){
        int vuelta = 1;
        while(particion < (datos.length)){
            System.out.println("\n\n");
            System.out.println("Vuelta #"+(vuelta++));
            for (int i = 0; i < datos.length; i++) {
                System.out.print(datos[i]+" ");
            }System.out.println("");
            
            distribuirDatos(archivo1, archivo2, particion);
            comparativaArchivos2(archivo1, archivo2, particion);
            particion = particion*2;
        }
    }
    
    void comparativaArchivos2(int archivo1[], int archivo2[], int p_tamañoGrupo){
        int indexDatos = 0;
        int i=0,j=0;
        int limIndexGrupo = p_tamañoGrupo;
        
        while(limIndexGrupo <= archivo1.length && indexDatos < datos.length){
            while(i<limIndexGrupo && j<limIndexGrupo){
                if(archivo1[i] < archivo2[j]){
                    datos[indexDatos++] = archivo1[i++];
                }else{
                    datos[indexDatos++] = archivo2[j++];
                }
            }
            
            if(i >= limIndexGrupo && j < limIndexGrupo){
                while(j != limIndexGrupo){
                    datos[indexDatos++] = archivo2[j++];
                }
            }
            if(j >= limIndexGrupo && i < limIndexGrupo){
                while(i != limIndexGrupo){
                    datos[indexDatos++] = archivo1[i++];
                }
            }
            limIndexGrupo = limIndexGrupo+p_tamañoGrupo;
        }
    }
    
    //Puede pasar que el array de datos sea de losngitúd impar, por lo que un archivo quedará con un espacio vacío
    void distribuirDatos(int archivo1[], int archivo2[], int particion){
        int indexDatos=0;
        int i=0,j=0;

        while(indexDatos < datos.length){
            for (int a = 0; a < particion; a++) {
                archivo1[i] = datos[indexDatos];
                indexDatos++;i++;
            }
            for (int b = 0; b < particion; b++) {
                archivo2[j] = datos[indexDatos];
                indexDatos++;j++;
            }
        }
        /*System.out.print("A1--> ");
        for (int k = 0; k < archivo1.length; k++) {
            System.out.print(archivo1[k]+" ");
        }System.out.println("");
        System.out.print("A2--> ");
        for (int k = 0; k < archivo1.length; k++) {
            System.out.print(archivo2[k]+" ");
        }*/
        
    }
}
