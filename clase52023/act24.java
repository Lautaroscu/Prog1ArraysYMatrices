package clase52023;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * Se tiene un arreglo de enteros de tamaño 20 de secuencias de
números entre 1 y 9, separadas por 0. El arreglo está precargado,
y además empieza y termina con uno o más separadores 0. Hacer
un programa que permita obtener a través de métodos la posición
de inicio y la posición de fin de la secuencia ubicada a partir de
una posición entera ingresada por el usuario. Finalmente, si
existen imprima por pantalla ambas posiciones obtenidas.21
 */
public class act24 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 8, 9, 0, 11, 0, 13, 14, 15, 2, 17, 18, 19, 0 };
        encontrar_sec_pos_ingresada(arr);

    }

    public static void encontrar_sec_pos_ingresada(int[] arr) {
        int inicio = 0;
        int fin = 0;
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese una posicion entera entre 0 y 19");
            int pos = Integer.valueOf(entrada.readLine());
            if (pos < 0 || pos > MAX - 1) {
                System.out.println("Posicion inexistente");
                return;
            }

            if (arr[pos - 1] == 0) {
                inicio = obtener_incio(arr, pos - 1);
                fin = obtener_fin(arr, inicio);
            } else {
                while (arr[pos] != 0) {
                    pos++;
                }
                inicio = obtener_incio(arr, pos);
                fin = obtener_fin(arr, inicio);
            }

            System.out.println(inicio + " " + fin);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int obtener_incio(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }
}
