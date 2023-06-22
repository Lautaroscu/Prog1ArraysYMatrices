/* Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada elimine todas las secuencias que tienen orden descendente entre
sus elementos. */

public class clase8_ejercicio15 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;

    public static void main(String[] args) {
        int[][] mat = { { 0, 5, 4, 7, 0, 3, 4, 0, 1, 0 },
                { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 },
                { 0, 4, 0, 6, 7, 0, 1, 9, 0, 0 },
                { 0, 6, 0, 8, 0, 0, 1, 0, 5, 0 },
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 }
        };
        imprimir_mat_enteros(mat);
        eliminar_sec_desc_mat(mat);
        imprimir_mat_enteros(mat);

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

    public static void eliminar_sec_desc_mat(int[][] mat) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            eliminar_sec_desc_arr(mat[fila]);
        }
    }

    public static void eliminar_sec_desc_arr(int[] arr) {
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOL - 1) {
            inicio = encontrar_inicio_sec(arr, fin + 1);
            if (inicio < MAXCOL - 1) {
                fin = encontrar_fin_sec(arr, inicio);
                if (es_descendente(arr, inicio, fin)) {
                    eliminar_sec(arr, inicio, fin);
                    fin = inicio;

                }
            }
        }

    }

    public static int encontrar_inicio_sec(int[] arr, int inicio) {
        int pos = inicio;
        while ((pos < MAXCOL) && (arr[pos] == 0)) {
            pos++;

        }
        return pos;
    }

    public static int encontrar_fin_sec(int[] arr, int fin) {
        int pos = fin;
        while ((pos < MAXCOL) && (arr[pos] != 0)) {
            pos++;

        }
        return pos - 1;
    }

    public static boolean es_descendente(int[] arr, int inicio, int fin) {
        if (fin - inicio + 1 == 1)
            return false;
        while ((inicio < fin) && (arr[inicio] > arr[inicio + 1])) {
            inicio++;
        }

        return (inicio == fin);
    }

    public static void eliminar_sec(int[] arr, int inicio, int fin) {
        int i = inicio;
        while (i <= fin) {
            corrimiento_izq(arr, inicio);
            i++;
        }

    }

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAXCOL - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

}
