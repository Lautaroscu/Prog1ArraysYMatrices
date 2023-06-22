package clase52023;

public class act23 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int arr[] = { 0, 2, 3, 0, 0, 6, 7, 8, 9, 2, 11, 0, 13, 14, 15, 2, 17, 18, 19, 0 };
        invertir_ult_sec(arr);
        imprimir_arreglo(arr);

    }

    public static void invertir_ult_sec(int[] arr) {
        int inicio = MAX - 1;
        int fin = MAX - 1;
        int contador = 0;
        fin = buscar_fin(arr, inicio - 1);
        if (fin > 0) {
            inicio = buscar_ini(arr, fin);
            if (inicio > 0) {
                invertir_sec(arr, inicio, fin);
            }

        }

    }

    public static void invertir_sec(int[] arr, int inicio, int fin) {
        int aux = 0;
        int tam = (fin - inicio + 1) / 2;
        for (int i = 0; i <= tam; i++) {
            aux = arr[i + inicio];
            arr[i + inicio] = arr[fin - i];
            arr[fin - i] = aux;

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

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }

}
