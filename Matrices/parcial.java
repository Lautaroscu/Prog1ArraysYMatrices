/*Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros, hacer un programa que
 extraiga todas las secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N
 (quedando separadas por un 0). */
public class parcial {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int[] ARR = { 0, 2, 8, 6, 0, 9, 7, 0, 4, 4 };
        int[] PAR = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        extraer_copiar_secuencias(ARR, PAR);
        imprimir_arreglo(ARR);
        System.out.println("\npar:");
        imprimir_arreglo(PAR);
    }

    public static void extraer_copiar_secuencias(int[] arr, int[] arrPar) {
        int inicio = 0;
        int fin = 0;
        int posPar = 0;
        while (inicio < MAX) {
            inicio = buscar_pos_inicio(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscar_pos_fin(arr, inicio);
                if (fin < MAX) {
                    int tam = fin - inicio + 1;
                    if (tam % 2 == 0) {
                        for (int i = inicio; i <= fin; i++) {
                            arrPar[posPar] = arr[i];
                            posPar++;
                        }
                        posPar++;
                    }
                }
            }
        }
    }

    public static int buscar_pos_inicio(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int buscar_pos_fin(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
    }

}
