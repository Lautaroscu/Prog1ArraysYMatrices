import java.util.Random ;

public class nosex2 {
    public static final int MAXCOLUMNA = 20;
    public static final int MAXFILA = 10;
    public static final double PROBABILIDAD = 0.4;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final int MAXCDS = 3;
    public static void main(String[] args){
        int [][] mat = new int [MAXFILA][MAXCOLUMNA] ;
        cargar_matriz_secuencia_int(mat) ;
        imprimir_matriz_int(mat);
        eliminar_ult_3_sec_orden_no_desc_mat(mat);
        System.out.println("nueva matriz");
        imprimir_matriz_int(mat);
        
    }
    public static void eliminar_ult_3_sec_orden_no_desc_mat(int[][] mat){

        for(int fila =0; fila < MAXFILA; fila++){
            eliminar_ult_3_sec_orden_no_desc_arr(mat[fila]) ;
        }
    }

    public static void eliminar_ult_3_sec_orden_no_desc_arr(int[] arr){
      int inicio = 0;
      int fin = -1;
      int cant = 0;
        while((cant <= MAXCDS)  && (inicio < MAXCOLUMNA-1)){
                inicio = encontrar_inicio_sec(arr, fin+1);
                if(inicio < MAXCOLUMNA-1){
                    fin = encontrar_fin_sec(arr, inicio) ;
                        if(orden_descendente(arr, inicio,fin) != fin){
                           int veces = fin-inicio+1;
                           while(veces > 0){
                               corrimiento_izq(arr,inicio) ;
                                veces--;
                             }
                           
                    
                        }  
                cant++;}
               
            }
            
        }

    
    public static int orden_descendente(int [] arr, int inicio, int fin){        
        while(((inicio )<= fin ) && (arr[inicio]  < arr[inicio+1])){ 
          inicio++;
    }

         return inicio ;    }

    public static void corrimiento_izq(int[] arr, int inicio){
        for(int i = inicio; i < MAXCOLUMNA-1; i++){
            arr[i] = arr[i+1];
        }
    }
    public static int encontrar_inicio_sec(int[] arr, int pos){
        while((pos < MAXCOLUMNA-1) && (arr[pos] == 0)){
            pos++;
        }
        return pos;
    }
    public static int encontrar_fin_sec(int[] arr, int pos){
        while((pos < MAXCOLUMNA-1) && (arr[pos] != 0)){
            pos++;
        }
        return pos-1;
    }

     

    public static void cargar_matriz_secuencia_int(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			cargar_arreglo_secuencias_int(mat[fila]);
		}
		System.out.println(" ");
	}

	public static void cargar_arreglo_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAXCOLUMNA - 1] = 0;
		for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimir_matriz_int(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo_int(mat[fila]);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print(arr[pos]+ "|");
		}
		System.out.println("");
	}
}
