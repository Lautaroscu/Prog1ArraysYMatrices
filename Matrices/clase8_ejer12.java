/* Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, permita encontrar por cada fila la posición de inicio y fin de la
anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
posición de la fila). */

public class clase8_ejer12 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;
    public static final int MAXCANT = 2;

    public static void main(String[] args) {
        int[][] mat = { { 0, 3, 0, 5, 0, 3, 4, 0, 1, 0 },
                { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 },
                { 0, 4, 0, 6, 7, 0, 1, 9, 0, 0 },
                { 0, 6, 0, 8, 0, 0, 1, 0, 5, 0 },
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 }
        };
        imprimir_mat_enteros(mat);
        encontrar_anteult_sec_mat(mat);
    }

    public static void encontrar_anteult_sec_mat(int[][] mat) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            encontrar_anteult_sec_arr(mat[fila]);
        }
    }

    public static int encontrar_inicio_sec(int[] arr, int pos) {
        while ((pos < MAXCOL) && (arr[pos] != 0)) {
            pos--;
        }
        return pos + 1;
    }

    public static int encontrar_fin_sec(int[] arr, int pos) {
        while ((pos < MAXCOL) && (arr[pos] == 0)) {
            pos--;
        }
        return pos;
    }

    public static void encontrar_anteult_sec_arr(int[] arr) {
        int cant = 0;
        int inicio = MAXCOL - 1;
        int fin = MAXCOL - 1;
        while (fin > 0 && cant < MAXCANT) {
            fin = encontrar_fin_sec(arr, inicio - 1);
            if (fin > 0) {
                inicio = encontrar_inicio_sec(arr, fin);
                cant++;
                if (inicio > 0 && cant == MAXCANT) {
                    System.out.println(inicio + " " + fin);
                }
            }

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
