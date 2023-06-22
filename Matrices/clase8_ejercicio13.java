
/* Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada, y un número entero ingresado por el usuario, elimine de cada fila
las secuencias de tamaño igual al número ingresado. */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clase8_ejercicio13 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;

    public static void main(String[] args) {
        int numero;
        int[][] mat = { { 0, 3, 5, 5, 0, 3, 4, 0, 1, 0 },
                { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 },
                { 0, 4, 0, 6, 7, 0, 1, 9, 0, 0 },
                { 0, 6, 0, 8, 0, 0, 1, 0, 5, 0 },
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 }
        };
        imprimir_mat_enteros(mat);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un numero entero");
            numero = Integer.valueOf(entrada.readLine());
            eliminar_sec_igual_tam_mat(mat, numero);
            imprimir_mat_enteros(mat);

        } catch (Exception e) {
            System.out.println(e);
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

    public static int encontrar_inicio_sec(int[] arr, int pos) {
        while ((pos < MAXCOL) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int encontrar_fin_sec(int[] arr, int pos) {
        while ((pos < MAXCOL) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static void eliminar_sec_igual_tam_mat(int[][] mat, int numero) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            eliminar_sec_igual_tam_arr(mat[fila], numero);

        }

    }

    public static void eliminar_sec_igual_tam_arr(int[] arr, int numero) {
        int fin = -1;
        int inicio = 0;
        while (inicio < MAXCOL) {
            if (inicio < MAXCOL) {
                inicio = encontrar_inicio_sec(arr, fin + 1);
                fin = encontrar_fin_sec(arr, inicio);
                if (numero == (fin - inicio + 1)) {
                    eliminar_secuencia(arr, inicio, fin);
                    fin = inicio;
                }

            }
        }

    }

    public static void eliminar_secuencia(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    public static void corrimiento_izq(int[] arr, int inicio) {
        for (int i = inicio; i < MAXCOL - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

}
