/* Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda y no continuar buscando. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8_ejer5 {
    public static final int MAXCOL = 10;
    public static final int MAXFIL = 5;

    public static void main(String[] args) {
        int[][] mat = { { 1, 3, 4, 5, 6, 3, 4, 5, 1, 8 },
                { 4, 5, 2, 7, 9, 7, 4, 2, 5, 7 },
                { 6, 4, 3, 6, 7, 2, 1, 9, 0, 1 },
                { 5, 6, 1, 8, 0, 3, 1, 6, 7, 1 },
                { 7, 9, 2, 2, 1, 5, 7, 6, 3, 7 }
        };
        int numero, pos;
        imprimir_mat_enteros(mat);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("ingrese un numero entero");
            numero = Integer.valueOf(entrada.readLine());
            encontrar_y_eliminar_pos(mat, numero);
            imprimir_mat_enteros(mat);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void imprimir_mat_enteros(int[][] mat) {
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }

    }

    public static void encontrar_y_eliminar_pos(int[][] mat, int numero) {
        int pos = 0;
        int fila = 0;
        while (fila < MAXFIL) {
            while (pos < MAXCOL) {
                if (mat[fila][pos] == numero) {
                    corrimiento_izq(mat[fila], pos);
                    return;
                    // aca se puede hacer un contador, o un booleano, yo hice return xq es mas
                    // simple
                }
                pos++;
            }
            fila++;
        }

    }

    public static void corrimiento_izq(int[] arr, int numero) {
        for (int i = numero; i < MAXCOL - 1; i++) {
            arr[i] = arr[i + 1];

        }
    }

}