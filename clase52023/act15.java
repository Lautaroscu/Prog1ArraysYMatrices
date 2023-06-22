package clase52023;

/* 
 * Hacer un programa que devuelva la posición de inicio y fin de la
primera secuencia de números distinta de ceros.
 */
public class act15 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 8, 9, 0, 11, 0, 13, 14, 15, 0, 17, 18, 19, 0 };
        encontar_ini_fin_sec(arr);

    }

    public static void encontar_ini_fin_sec(int[] arr) {
        int inicio = 0;
        int fin = 0;
        inicio = buscar_ini(arr, fin + 1);
        fin = buscar_fin(arr, inicio);
        System.out.println(inicio + " " + fin);
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