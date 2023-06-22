/* Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio. */

public class clase8_ejercicio1 {
    public static final int MAXCOlUM = 10;
    public static final int MAXFILA = 5;

    public static void main(String args[]) {
        int[][] matenteros = { { 1, 3, 4, 5, 6, 3, 4, 5, 1, 8 },
                { 4, 5, 2, 7, 9, 7, 4, 2, 5, 7 },
                { 6, 4, 3, 6, 7, 2, 1, 9, 0, 1 },
                { 5, 6, 1, 8, 0, 3, 1, 6, 7, 1 },
                { 7, 9, 2, 2, 1, 5, 7, 6, 3, 7 }
        };

        imprimir_mat_enteros(matenteros);
        invertir_filas(matenteros);
        System.out.println(" ");
        imprimir_mat_enteros(matenteros);

    }

    public static void imprimir_mat_enteros(int[][] mat) {
        for (int i = 0; i < MAXFILA; i++) {
            for (int j = 0; j < MAXCOlUM; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }

    }

    public static void invertir_filas(int[][] mat) {
        int aux;
        for (int i = 0; i < MAXFILA; i++) {
            for (int j = 0; j < MAXCOlUM / 2; j++) {
                aux = mat[i][j];
                mat[i][j] = mat[i][MAXCOlUM - 1 - j];
                mat[i][MAXCOlUM - 1 - j] = aux;

            }
        }

    }

}
