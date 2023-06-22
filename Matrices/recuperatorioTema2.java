/* 
 * Tema 2: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas
 *  Además se tiene precargado un arreglo con algunos números de filas. Los números de filas no se repitenn y
 *  están ubicados de forma consecutiva desde el principio del arreglo, luego se completa con -1. De dichas filas
 *  se pide eliminar la penúltima y la antepenúltima secuencia que tengan al menos 3 números impares.
Observaciones: _el tamaño arreglo es igual a la cantidad de filas de la matriz,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_realizar el programa completo sin realizar métodos de carga e impresión de arreglo y matriz, ni utilizar estructuras auxiliares.


 */

public class recuperatorioTema2 {
    public static final int CONSTANTE_3 = 3;
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 15;

    // MAIN
    public static void main(String[] args) {
        int[][] mat = { { 0, 3, 5, 5, 3, 0, 1, 3, 1, 0, 33, 5, 1, 4, 0 },
                { 0, 0, 3, 5, 9, 0, 5, 1, 3, 0, 11, 13, 1, 4, 0 }, // cargada en array
                { 0, 4, 5, 6, 0, 0, 1, 9, 3, 0, 1, 7, 9, 3, 0 },
                { 0, 0, 7, 5, 3, 0, 1, 3, 5, 0, 3, 5, 9, 0, 0 }, // cargada en array
                { 0, 5, 0, 7, 3, 5, 0, 1, 5, 3, 0, 5, 7, 11, 0 } // cargada en array
        };

        int[] arr = { 3, 1, 4, -1, -1 };
        imprimir_mat_enteros(mat);
        elimarPenultimayAntepenultimaSec(mat, arr);
        imprimir_mat_enteros(mat);
    }

    private static void elimarPenultimayAntepenultimaSec(int[][] mat, int[] arr) {
        for (int fila = 0; fila < MAXFIL && arr[fila] != -1; fila++) {
            eliminarSecCumplen(mat[arr[fila]]);
        }

    }

    private static void eliminarSecCumplen(int[] fila) {
        int inicio = MAXCOL - 1;
        int fin = MAXCOL - 1;
        int cant = 0;
        while (fin > 0 && cant < CONSTANTE_3) {
            fin = obtener_fin(fila, inicio - 1);
            if (fin > 0) {
                inicio = obtener_incio(fila, fin);
                if (inicio > 0) {
                    if (alMenos3Impares(fila, inicio, fin) && cant > 0) {
                        eliminar_secuencia(fila, inicio, fin);
                        fin = inicio - 1;

                    }
                }
            }
            cant++;
        }

    }

    public static void eliminar_secuencia(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAXCOL - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static boolean alMenos3Impares(int[] arr, int inicio, int fin) {
        int contador = 0;
        for (int i = inicio; i <= fin; i++) {
            if (arr[i] % 2 != 0) {
                contador++;
            }
        }
        return contador >= 3;
    }

    public static int obtener_incio(int[] arr, int pos) {
        while (pos > 0 && arr[pos] != 0) {
            pos--;
        }
        return pos + 1;
    }

    public static int obtener_fin(int[] arr, int pos) {
        while (pos > 0 && arr[pos] == 0) {
            pos--;
        }
        return pos;
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
