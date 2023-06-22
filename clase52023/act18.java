package clase52023;

/* 
 * Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño.
 */
public class act18 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 8, 9, 0, 11, 0, 13, 14, 15, 0, 17, 18, 19, 0 };
        obtener_sec_tam_mayor(arr);

    }

    public static void obtener_sec_tam_mayor(int[] arr) {
        int inicio = 0;
        int fin = 0;
        int tamMayor = 0;
        int iniMayor = 0;
        int finMayor = 0;
        while (inicio < MAX) {
            inicio = buscar_ini(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arr, inicio);
                if (fin < MAX) {
                    int tam = fin - inicio + 1;
                    if (tam > tamMayor) {
                        tamMayor = tam;
                        iniMayor = inicio;
                        finMayor = fin;
                    }
                }

            }

        }
        System.out.println(iniMayor + " " + finMayor);
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

}
