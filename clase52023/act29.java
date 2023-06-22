package clase52023;
/* 
 * Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario el ingreso de
dos números enteros (posiciones del arreglo) y ordene de forma
creciente el arreglo entre dos posiciones correspondientes a los
números ingresados.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class act29 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 0, 0, 0, 11, 0, 13, 14, 0, 2, 17, 18, 19, 0 };

        imprimir_arreglo(arr);
        ordenar_arr_entre_dos_pos(arr);
        imprimir_arreglo(arr);

    }

    public static void ordenar_arr_entre_dos_pos(int[] arr) {

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese dos posiciones entre 0 y 19");
            int pos = Integer.valueOf(entrada.readLine());
            int pos2 = Integer.valueOf(entrada.readLine());
            ordenar_asc(arr, pos, pos2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ordenar_asc(int[] arr, int pos1, int pos2) {
        int aux = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = pos1; j < pos2; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }

            }
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
