/* 
 * Tema 1: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas.
 *  Se pide guardar en un arreglo los números de filas de las primeras 2 filas que cumplen con la condición
 *  de tener a lo sumo 2 secuencias sin orden descendente.
 * 
 * Observaciones: _el tamaño arreglo es igual a la cantidad de filas de la matriz, y está inicializado con -1,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_realizar el programa completo sin realizar métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares.

 */

public class recuperatorioTema1 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;
    public static final int MAXCANT = 2;

    public static void main(String[] args) {

        int[][] mat = { { 0, 3, 5, 5, 0, 3, 6, 0, 1, 0 }, // guardar
                { 0, 3, 2, 0, 9, 7, 0, 2, 3, 0 },
                { 0, 4, 5, 6, 0, 0, 1, 9, 0, 0 }, // guardar
                { 0, 6, 7, 8, 0, 0, 1, 4, 5, 0 }, // es orden distinto de desc, pero, ya hay dos filas arriba que
                                                  // cumple, then , no deberia guardar
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 }
        };
        int[] arr = { -1, -1, -1, -1, -1 };
        guardarFilasCumplen(mat, arr);
        imprimir_arreglo(arr);
    }

    private static void guardarFilasCumplen(int[][] mat, int[] arr) {
        int fila = 0;
        int cant = 0;
        while (fila < MAXFIL && cant < MAXCANT) {
            if (AlMenos2Ascendentes(mat[fila])) {
                arr[cant] = fila;
                cant++;
            }
            fila++;
        }

    }

    public static boolean es_ascendente(int[] fila, int inicio, int fin) {
        while (inicio < fin && fila[inicio] < fila[inicio + 1]) {
            inicio++;
        }
        return inicio == fin;
    }

    public static boolean AlMenos2Ascendentes(int[] fila) {
        int inicio = 0;
        int fin = 0;
        int cant = 0;
        while (inicio < MAXCOL) {
            inicio = obtener_incio(fila, fin + 1);
            if (inicio < MAXCOL) {
                fin = obtener_fin(fila, inicio);
                if (fin < MAXCOL) {
                    if (es_ascendente(fila, inicio, fin)) {
                        cant++;
                    }
                }
            }
        }
        return cant >= MAXCANT;
    }

    public static int obtener_incio(int[] arr, int pos) {
        while (pos < MAXCOL && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin(int[] arr, int pos) {
        while (pos < MAXCOL && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAXFIL; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}