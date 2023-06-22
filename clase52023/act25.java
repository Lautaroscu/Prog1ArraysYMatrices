package clase52023;
/* 
 * Hacer un programa que dado el arreglo definido y precargado,
y un número entero ingresado por el usuario, copie de forma
continua las secuencias de tamaño igual al número ingresado en
otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio
del mismo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class act25 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 0, 0, 0, 11, 0, 13, 14, 0, 2, 17, 18, 19, 0 };
        int arr2[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        imprimir_arreglo(arr2);
        copiar_sec_continua(arr, arr2);
        System.out.println(" ");
        imprimir_arreglo(arr2);
    }

    public static void copiar_sec_continua(int[] arr, int[] arr2) {
        int inicio = 0;
        int fin = 0;
        int pos = 0;
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un numero entero");
            int entero = Integer.valueOf(entrada.readLine());
            while (inicio < MAX) {
                inicio = obtener_incio(arr, fin + 1);
                if (inicio < MAX) {
                    fin = obtener_fin(arr, inicio);
                    if (fin < MAX) {
                        int tam = fin - inicio + 1;
                        if (tam == entero) {
                            for (int i = inicio; i <= fin; i++) {
                                arr2[pos] = arr[i];
                                pos++;
                            }
                            arr2[pos] = 0;
                            pos++;
                        }
                    }
                }
            }

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

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }

}
