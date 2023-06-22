package clase52023;

/* 
 * Hacer un programa que devuelva la posición de inicio y fin de la
anteúltima secuencia de números distintos de ceros. 
 */
public class act17 {
    public static final int MAX = 20;
    public static final int MAXCANT = 2;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 8, 9, 0, 11, 0, 13, 14, 15, 0, 17, 18, 19, 0 };
        encontar_ini_fin_sec(arr);

    }

    public static void encontar_ini_fin_sec(int[] arr) {
        int inicio = MAX - 1;
        int fin = MAX - 1;
        int cant = 0;
        while (fin > 0 && cant < MAXCANT) {
            fin = buscar_fin(arr, inicio - 1);
            if (fin > 0) {
                inicio = buscar_ini(arr, fin);
                cant++;
                if (inicio > 0 && cant == MAXCANT) {
                    System.out.println(inicio + " " + fin);
                }
            }

        }
    }

    public static int buscar_ini(int[] arr, int pos) {
        while (pos > 0 && arr[pos] != 0) {
            pos--;
        }
        return pos + 1;
    }

    public static int buscar_fin(int[] arr, int pos) {
        while (pos > 0 && arr[pos] == 0) {
            pos--;
        }
        return pos;
    }

}
