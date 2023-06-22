
/*Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada, 
*elimine de cada fila todas las ocurrencias de una secuencia patrón dada por un arreglo
*de caracteres de tamaño igual al tamaño de columnas de la matriz (solo tiene esa 
*secuencia con separadores al inicio y al final). Al eliminar en cada fila se 
*pierden los valores haciendo los corrimientos.*/
public class clase8_ejer14 {
    public static final int MAXFILA = 3;
    public static final int MAXCOLUMNA = 20;
    public static int MAX = 20;

    public static void main(String[] args) {
        int[][] matint = { { 0, 1, 2, 0, 3, 4, 0, 6, 6, 4, 3, 0, 6, 5, 4, 3, 0, 8, 5, 0 },
                { 0, 1, 5, 0, 3, 4, 0, 0, 2, 3, 5, 0, 8, 5, 0, 6, 5, 4, 3, 0 },
                { 0, 1, 2, 0, 6, 5, 4, 3, 0, 3, 0, 0, 0, 5, 2, 1, 0, 8, 9, 0 } };
        int[] arrpatron = { 6, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        imprimir_matriz_secuencias_int(matint);
        buscar_secuencias_matriz(matint, arrpatron);
        System.out.println("Nueva matriz: ");
        imprimir_matriz_secuencias_int(matint);
    }

    public static void imprimir_matriz_secuencias_int(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.print("|");
            for (int columna = 0; columna < MAXCOLUMNA; columna++) {
                System.out.print(mat[fila][columna] + "|");
            }
            System.out.println("");
        }
    }

    public static void buscar_secuencias_matriz(int[][] mat, int[] patron) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            buscar_secuencia_fila(mat[fila], patron);
        }
    }

    public static void buscar_secuencia_fila(int[] arr, int[] patron) {
        int inicio, fin;
        inicio = 0;
        fin = -1;
        while (inicio < MAX - 1) {
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAX - 1) {
                fin = obtener_fin_secuencia(arr, inicio);
                if (secuencia_cumple_patron(arr, patron, inicio, fin)) {
                    int veces = fin - inicio + 1;
                    while (veces >= 0) {
                        corrimiento_izq(arr, inicio);
                        veces--;
                    }
                    fin = inicio;
                }
            }
        }
    }

    public static boolean secuencia_cumple_patron(int[] arr, int[] patron, int inicio, int fin) {
        int i = 0;
        while ((inicio <= fin) && (arr[inicio] == patron[i])) {
            i++;
            inicio++;
        }

        return inicio > fin;
    }

    public static int obtener_inicio_secuencia(int[] arr, int pos) {
        while ((arr[pos] == 0) && (pos < MAX - 1)) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(int[] arr, int pos) {
        while ((arr[pos] != 0) && (pos < MAX - 1)) {
            pos++;
        }
        return pos - 1;
    }

    public static void corrimiento_izq(int[] arrenteros, int posicion) {
        for (int pos = posicion; pos < MAX - 1; pos++) {
            arrenteros[pos] = arrenteros[pos + 1];
        }
    }
}