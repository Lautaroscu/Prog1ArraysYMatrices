import java.util.Random;

public class practica {
    public static final int MAXCOLUMNA = 30;
    public static final int MAXFILA = 9;
    public static final double PROBABILIDAD = 0.4;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencia_int(mat);
        imprimir_matriz_int(mat);
        recorrer_filas_matriz(mat);
        System.out.println("");
        imprimir_matriz_int(mat);

    }

    public static void recorrer_filas_matriz(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            recorrer_columnas_mat(mat[fila]);
        }
    }

    public static void recorrer_columnas_mat(int[] arr) {
        int inicio = 0;
        int fin = -1;

        int pares = 0;
        while (inicio < MAXCOLUMNA - 1) {
            inicio = encontrar_inicio_sec(arr, fin + 1);
            if (inicio < MAXCOLUMNA - 1) {
                fin = encontrar_fin_sec(arr, inicio);
                if (fin < MAXCOLUMNA - 1) {
                    pares = verificar_pares(arr, inicio, fin);
                    if ((pares % 2 == 0) || (igual_6(arr, inicio, fin))) {
                        recorrer_sec_promedio(arr, inicio, fin);
                    }
                }
            }
        }
    }

    public static void recorrer_sec_promedio(int[] arr, int inicio, int fin) {
        int promedio;
        int centro = (fin + inicio) / 2;
        for (int i = inicio; i <= fin; i++) {
            promedio = obtener_promedio_sec(arr, inicio, fin);
            // corrimiento_der(arr, centro, fin) ;
            arr[centro] = promedio;
            // System.out.println("el promedio de la suma de la secuencia es " + promedio) ;
        }

    }

    public static int obtener_promedio_sec(int[] arr, int inicio, int fin) {
        int suma = 0;
        int promedio = 0;
        int tam = fin - inicio + 1;
        for (int i = inicio; i <= fin; i++) {
            suma += arr[i];
        }
        promedio = suma / tam;
        return promedio;
    }

    public static int encontrar_inicio_sec(int[] arr, int pos) {
        while ((pos < MAXCOLUMNA - 1) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int encontrar_fin_sec(int[] arr, int pos) {
        while ((pos < MAXCOLUMNA - 1) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static void corrimiento_der(int[] arr, int fin, int centro) {
        for (int i = fin; i <= centro; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static int verificar_pares(int[] arr, int inicio, int fin) {
        int pares = 0;
        for (int i = inicio; i <= fin; i++) {
            if (arr[i] % 2 == 0) {
                pares++;
            }
        }
        return pares;
    }

    public static boolean igual_6(int[] arr, int inicio, int fin) {
        while (inicio <= fin) {
            if (arr[inicio] == 6) {
                return true;
            }
            inicio++;
        }
        return false;
    }

    public static void cargar_matriz_secuencia_int(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_int(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_secuencias_int(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAXCOLUMNA - 1] = 0;
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void imprimir_matriz_int(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_int(mat[fila]);
        }
    }

    public static void imprimir_arreglo_int(int[] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print(arr[pos] + "|");
        }
        System.out.println("");
    }
}
