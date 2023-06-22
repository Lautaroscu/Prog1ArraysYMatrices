package clase52023;

/* 
 * Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo.
 */
public class act20 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 2, 3, 4, 4, 0, 9, 0, 11, 0, 0, 1, 2, 3, 4, 5, 0, 0 };
        int pat[] = { 0, 1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        imprimir_arreglo(arr);
        eliminar_ocurrencias_sec_patron(arr, pat);
        System.out.println(" ");
        imprimir_arreglo(arr);
    }

    private static void eliminar_ocurrencias_sec_patron(int[] arr, int[] pat) {
        int inicio = 0;
        int fin = 0;
        int pat_inicio = 0;
        int pat_fin = 0;
        pat_inicio = obtener_incio(pat, pat_fin + 1);
        while (inicio < MAX) {
            inicio = obtener_incio(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtener_fin(arr, inicio);
                if (fin < MAX) {
                    if (hay_ocurrencia(arr, pat, inicio, fin, pat_inicio)) {
                        eliminar_secuencia(arr, inicio, fin);
                        fin = inicio - 1;
                    }
                    inicio = obtener_incio(arr, fin + 1);
                }
            }
        }
    }

    public static void eliminar_secuencia(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    public static boolean hay_ocurrencia(int[] arr, int[] pat, int inicio, int fin, int inicio_pat) {
        if (fin - inicio + 1 == 1)
            return false;
        while (inicio <= fin && arr[inicio] == pat[inicio_pat]) {
            inicio++;
            inicio_pat++;
        }
        return inicio > fin;
    }

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
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
