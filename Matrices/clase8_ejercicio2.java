/* Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, obtenga la cantidad de números pares que tiene y la imprima. */

public class clase8_ejercicio2 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUM = 10;

    public static void main(String args[]) {
        int[][] matenteros = { { 1, 3, 4, 5, 6, 3, 4, 5, 1, 8 },
                { 4, 5, 2, 7, 9, 7, 4, 2, 5, 7 },
                { 6, 4, 3, 6, 7, 2, 1, 9, 0, 1 },
                { 5, 6, 1, 8, 0, 3, 1, 6, 7, 1 },
                { 7, 9, 2, 2, 1, 5, 7, 6, 3, 7 }
        };
        imprimir_mat_enteros(matenteros);
        obtener_pares(matenteros);

    }

    public static void obtener_pares(int[][] mat) {
        int cont = 0;
        for (int i = 0; i < MAXFILAS; i++) {
            for (int j = 0; j < MAXCOLUM; j++) {
                if (mat[i][j] % 2 == 0) {
                    cont++;
                }
            }
        }
        System.out.println(cont);
    }

    public static void imprimir_mat_enteros(int[][] mat) {
        for (int i = 0; i < MAXFILAS; i++) {
            for (int j = 0; j < MAXCOLUM; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }

    }

}
