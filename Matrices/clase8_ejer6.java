
/* Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en la matriz si existe. Mientras exista (en cada iteración tiene que buscar la posición fila y
columna) tendrá que usar dicha posición para realizar un corrimiento a izquierda. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8_ejer6 {
    public static final int MAXCOL = 10;
    public static final int MAXFIL = 5;

    public static void main(String[] args) {
        int[][] mat = { { 1, 3, 4, 5, 6, 3, 4, 5, 1, 8 },
                { 4, 5, 2, 7, 9, 7, 4, 2, 5, 7 },
                { 6, 4, 3, 6, 7, 2, 1, 9, 0, 1 },
                { 5, 6, 1, 8, 0, 3, 1, 6, 7, 1 },
                { 7, 9, 2, 2, 1, 5, 7, 6, 3, 7 }
        };
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            imprimir_mat_enteros(mat);

            System.out.println("Ingrese un valor entero");
            int value = Integer.valueOf(entrada.readLine());
            eliminarOcurrenciaEnMat(mat, value);
            imprimir_mat_enteros(mat);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void eliminarOcurrenciaEnMat(int[][] mat, int value) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            eliminarOcurrencias(mat[fila], value);
        }
    }

    private static void eliminarOcurrencias(int[] fila, int value) {
        int pos = 0;

        while (pos < MAXCOL) {
            if (fila[pos] == value) {
                corrimiento_izq(fila, pos);
            }
            pos++;
        }

    }

    private static void corrimiento_izq(int[] fila, int pos) {
        while (pos < MAXCOL - 1) {
            fila[pos] = fila[pos + 1];
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
