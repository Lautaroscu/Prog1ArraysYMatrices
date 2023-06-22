package clase52023;

//eliminar todas las sec con orden descendente
public class act21 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 0, 3, 2, 1, 0, 8, 5, 4, 0, 11, 0, 0, 1, 2, 3, 4, 5, 0, 0 };
        eliminarDescendentes(arr);
        imprimir_arreglo(arr);

    }

    static void eliminarDescendentes(int[] arr) {
        int inicio = 0;
        int fin = 0;
        while (inicio < MAX) {
            inicio = obtener_incio(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtener_fin(arr, inicio);
                if (fin < MAX) {
                    if (esDescendente(arr, inicio, fin)) {
                        eliminar_secuencia(arr, inicio, fin);
                        fin = inicio - 1;
                    }
                }
            }
        }
    }

    static void eliminar_secuencia(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    static boolean esDescendente(int[] arr, int inicio, int fin) {
        while (inicio < fin && arr[inicio] > arr[inicio + 1]) {
            inicio++;
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

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

}
