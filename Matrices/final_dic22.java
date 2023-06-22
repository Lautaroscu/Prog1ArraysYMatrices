
/* 
 * Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. Ademas se tiene
 * precargado un arreglo con algunos numero de filas, no se repiten y estan ubicados de forma consecutiva  
 * desde el principio del arreglo, luego se completa con -1. De dichas filas de se pide eliminar la ultima 
 * secuencia que cumpla con la condicion de tener valores pares.
 * Observaciones :
 * el tam  del arreglo es igual a la cantidad de filas de la matriz.
 */
public class final_dic22 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;
    public static final int MAXCANT = 1;

    public static void main(String[] args) {
        int[][] mat = { { 0, 5, 4, 3, 0, 2, 0, 2, 6, 0 }, // 0
                { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 },
                { 0, 4, 0, 6, 7, 0, 1, 9, 0, 0 }, // 2
                { 0, 6, 0, 8, 0, 0, 1, 0, 5, 0 },
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 } // 4
        };
        int[] arr = { 0, 2, 4, -1, -1 };
        imprimir_mat_enteros(mat);
        eliminarSecCumple(mat, arr);
        imprimir_mat_enteros(mat);
    }

    public static int obtener_inico(int[] arr, int pos) {
        while (pos >= 0 && arr[pos] != 0) {
            pos--;
        }
        return pos + 1;
    }

    public static int obtner_fin(int[] arr, int pos) {
        while (pos >= 0 && arr[pos] == 0) {
            pos--;
        }
        return pos;
    }

    public static void eliminarSecCumple(int[][] mat, int[] arr) {
        int i = 0;
        while (i < MAXFIL && arr[i] != -1) {
            int fila = arr[i];
            obtener_ult_secYEliminarla(mat[fila]);
            i++;
        }

    }

    public static void obtener_ult_secYEliminarla(int[] fila) {
        int inicio = MAXCOL;
        int fin = MAXCOL;
        int cant = 0;
        while (fin >= 0 && cant < MAXCANT) {
            fin = obtner_fin(fila, inicio - 1);
            if (fin >= 0) {
                inicio = obtener_inico(fila, fin);
                if (inicio >= 0 && tiene_pares(fila, inicio, fin)) {
                    if (cant >= 0) {
                        int tam = fin - inicio + 1;
                        while (tam > 0) {
                            corrimiento_izq(fila, inicio);
                            tam--;
                        }

                    }
                    cant++;
                }

            }
        }

    }

    public static boolean tiene_pares(int[] fila, int inico, int fin) {
        int i = inico;
        while (i < fin) {
            if (fila[i] % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAXCOL - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void imprimir_mat_enteros(int[][] mat) {
        System.out.println("Matriz de Secuencias");
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

}
