package clase52023;

/* 
 * Hacer un programa que reemplace de un arreglo A todas las
ocurrencias de una secuencia patrón dada en un arreglo P, por la
secuencia contenida en el arreglo R de igual tamaño.
 */
public class act22 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int A[] = { 0, 0, 1, 2, 3, 4, 5, 0, 9, 0, 11, 0, 0, 1, 2, 3, 4, 5, 0, 0 };
        int P[] = { 0, 1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int R[] = { 0, 10, 3, 4, 87, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        /*
         * Tambien pueden hacer que en arreglo P y R solo exista esa secuencia, yo lo
         * hice de esta forma! Pero es indistinto.
         */
        imprimir_arreglo(A);
        reemplazar_ocurrencias(A, P, R);
        System.out.println(" ");
        imprimir_arreglo(A);
    }

    private static void reemplazar_ocurrencias(int[] a, int[] p, int[] r) {
        int ini_a = 0;
        int fin_a = 0;
        int ini_p = 0;
        int fin_p = 0;
        int ini_r = 0;
        int fin_r = 0;
        ini_p = obtener_incio(p, fin_p + 1);
        fin_p = obtener_fin(p, ini_p);
        ini_r = obtener_incio(r, fin_r + 1);
        fin_r = obtener_fin(r, ini_r);
        while (ini_a < MAX) {
            ini_a = obtener_incio(a, fin_a + 1);
            if (ini_a < MAX) {
                fin_a = obtener_fin(a, ini_a);
                if (fin_a < MAX) {
                    int tamR = fin_r - ini_r + 1;
                    int tamA = fin_a - ini_a + 1;
                    if (hay_ocurrencia(a, p, ini_a, fin_a, ini_p) && tamA == tamR) {
                        reemplzar(a, r, ini_a, fin_a, ini_r);
                    }
                }
            }

        }

    }

    public static void reemplzar(int[] a, int[] r, int ini_a, int fin_a, int ini_r) {
        for (int i = ini_a; i <= fin_a; i++) {
            a[i] = r[ini_r];
            ini_r++;

        }
    }

    public static boolean hay_ocurrencia(int[] arr, int[] pat, int inicio, int fin, int inicio_pat) {
        if (fin - inicio + 1 == 1)
            return false;
        while (inicio < fin && arr[inicio] == pat[inicio_pat]) {
            inicio++;
            inicio_pat++;
        }
        return inicio == fin;
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
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
