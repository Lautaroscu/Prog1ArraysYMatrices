package clase52023;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
 */
public class act19 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 1, 3, 0, 6, 7, 8, 9, 0, 11, 0, 13, 14, 15, 0, 18, 18, 0, 0 };
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            imprimir_arreglo(arr);
            int num = Integer.valueOf(entrada.readLine());
            eliminar_sec_tam_input(arr, num);
            imprimir_arreglo(arr);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void eliminar_sec_tam_input(int[] arr, int num) {
        int inicio = 0;
        int fin = 0;

        while (inicio < MAX) {
            inicio = buscar_ini(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arr, inicio);
                if (fin < MAX) {
                    int tam = fin - inicio + 1;
                    if (tam == num && arr[inicio] != arr[inicio + 1]) {
                        eliminar_sec_igual_tam(arr, inicio, fin);
                        fin = inicio;
                    }

                }
            }

        }
    }

    public static int buscar_ini(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int buscar_fin(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }

    public static void eliminar_sec_igual_tam(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }
}
