
/* Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
se encuentra precargada, solicite al usuario el ingreso de una fila y dos
números enteros (columnas de la matriz), y ordene de forma creciente la
matriz en la fila indicada entre las dos posiciones columnas ingresadas. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8_ejer9 {
    public static int MAXFIl = 5;
    public static int MAXCOL = 10;

    public static void main(String args[]) {
        int fila, columna1, columna2;
        int[][] mat = { { 0, 3, 0, 5, 0, 3, 4, 0, 1, 0 },
                { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 },
                { 0, 4, 0, 6, 7, 0, 1, 9, 0, 0 },
                { 0, 6, 0, 8, 0, 0, 1, 0, 5, 0 },
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 }
        };
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            imprimir_mat_enteros(mat);
            System.out.println("Ingrese una fila");
            fila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una columna");
            columna1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese otra columna");
            columna2 = Integer.valueOf(entrada.readLine());

            ordenar_fila_asc(mat[fila], columna1, columna2);

            imprimir_mat_enteros(mat);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void imprimir_mat_enteros(int[][] mat) {
        System.out.println("Matriz de Secuencias");
        for (int i = 0; i < MAXFIl; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

    public static void ordenar_fila_asc(int[] arr, int columna1, int columna2) {
        int temp;

        for (int i = 0; i < MAXCOL; i++) {
            for (int j = columna1; j < columna2; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

    }

}
