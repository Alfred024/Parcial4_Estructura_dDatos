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
        int vuelta = 0;
        while(particion < (datos.length)){
            System.out.println("Vuelta #"+(++vuelta));
            for (int i = 0; i < datos.length; i++) {
                System.out.print(datos[i]+" ");
            }System.out.println("");
            distribuirDatos(archivo1, archivo2, particion);
            comparativaArchivos(archivo1, archivo2, particion);
            particion = particion*2;
        }
    }

    //Es necesario tener en cuenta que cuando el array es impar, tendremos un espacio del array que no tendrá nada (o es igual a 0),
    //por lo que tomaremos a el 0 como una casilla vacía
    
    //Otra forma de tratar el problema anterior podría ser reasignándole el tamaño al arreglo 2, y que quedara con una casilla menos
    void comparativaArchivos(int archivo1[], int archivo2[], int p_tamañoGrupo){
        int i,j; //---> i para el archivo 1  y j para el archivo 2
        int indexDatos=0;
        int tamañoGrupo = p_tamañoGrupo; //--> Podemos cambiar el nombre de la varibale por: "lim_Grupo_Actual"
        int vueltaGrupo=0;

        while(indexDatos < datos.length){
            i = j = p_tamañoGrupo*vueltaGrupo;
            
            while(i < tamañoGrupo || j < tamañoGrupo){
                //tamañoGrupo == 2
                if((i >= tamañoGrupo && j < tamañoGrupo) || (j >= tamañoGrupo && i < tamañoGrupo)){
                    if(i>j){
                        while(j != i){
                            datos[indexDatos++] = archivo2[j++];
                        }
                    }else{
                        while(i != j){
                            datos[indexDatos++] = archivo1[i++];
                        }
                    }
                }   
                
                if(i != tamañoGrupo && j != tamañoGrupo){
                    if(archivo1[i] <= archivo2[j]){
                        datos[indexDatos++] = archivo1[i++];
                    }else{
                        datos[indexDatos++] = archivo2[j++];
                    }
                }
                
            }
            tamañoGrupo*=tamañoGrupo*2;
            vueltaGrupo++;
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
    }
}


/*
if((i >= tamañoGrupo && j < tamañoGrupo) || (j >= tamañoGrupo && i < tamañoGrupo)){
                    if(i>j){
                        while(j != i){
                            datos[indexDatos++] = archivo2[j++];
                        }
                    }else{
                        while(i != j){
                            datos[indexDatos++] = archivo1[i++];
                        }
                    }
                }
*/