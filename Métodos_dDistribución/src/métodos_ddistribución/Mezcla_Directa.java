package métodos_ddistribución;


public class Mezcla_Directa {
    
    int particion;
    int archivo1[], archivo2[];
    int datos[];

    Mezcla_Directa(int datos[]){
        this.datos = datos;
        archivo1 = new int[datos.length/2];
        archivo2 = new int[datos.length/2];
    }

    //No contempla el caso de los conjuntos impares
    void merge(){

        while(particion != (datos.length/2)){
            distribuirDatos(archivo1, archivo2, particion);
            //Método que distribuya y ordene los datos 
            //Dicho método tomará el parametro de los tamaños de los grupos gracias a la variable "partición"
            comparativaArchivos(archivo1, archivo2, particion);
            particion = particion*2;
        }

    }

    //Pregunta: Es necesario pasarle el parametro de datos al método?? O así como está ya basta, porque está declarado globalmente??
    void comparativaArchivos(int archivo1[], int archivo2[], int p_tamañoGrupo){
        int i,j; //---> i para el archivo 1  y j para el archivo 2
        int vueltas=0;
        int tamañoGrupo = p_tamañoGrupo;

        while(vueltas < datos.length){
            i = j = tamañoGrupo*vueltas;
            //while(i<tamañoGrupo-1 || j<tamañoGrupo-1)
            while(i<tamañoGrupo || j<tamañoGrupo){
                while(archivo1[i] < archivo2[j]){
                    datos[vueltas] = datos[i];
                    vueltas++;i++;
                }

                while(archivo2[j] < archivo1[i]){
                    datos[vueltas] = datos[j];
                    vueltas++;j++;
                }
            }

            tamañoGrupo+=tamañoGrupo;
        }
    }

    void distribuirDatos(int archivo1[], int archivo2[], int particion){
        int indexDatos=0;
        int i=0,j=0;

        while(indexDatos < (archivo1.length + archivo2.length)-1){
            //Llenado del archivo1
            for (int a = 0; a < particion; a++) {
                archivo1[i] = datos[indexDatos];
                indexDatos++;i++;
            }
            //Llenado del archivo2
            for (int b = 0; b < particion; b++) {
                archivo1[j] = datos[indexDatos];
                indexDatos++;j++;
            }
        }
    }
}
