package clase52023;

public class act26 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int A[] = { 0, 2, 3, 2, 4, 6, 7, 8, 9, 2, 11, 1, 13, 14, 15, 2, 17, 18, 0, 0 };
        int B[] = { 0, 1, 6, 0, 0, 8, 1, 4, 0, 0, 2, 5, 2, 3, 7, 2, 0, 0, 0, 0 };
        System.out.println(A.length);
        System.out.println(B.length);
        reemplazarEnASecdeB(A, B);
        imprimir_arreglo(A);
    }

    public static void reemplazarEnASecdeB(int[] A, int[] B) {
        int incioSecMayorA = secMayor(A);
        int incioMayorB = secMayor(B);
        int finSecMayorA = obtener_fin(A, incioSecMayorA);
        int finSecMayorB = obtener_fin(B, incioMayorB);
        reemplazar(A, B, incioSecMayorA, finSecMayorA, incioMayorB, finSecMayorB);

    }

    public static int secMayor(int[] arr) {
        int inicio = 0;
        int fin = 0;
        int inicioMayor = 0;
        int tamMayorA = 0;
        while (inicio < MAX) {
            inicio = obtener_incio(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtener_fin(arr, inicio);
                if (fin < MAX) {
                    int tam = fin - inicio + 1;
                    if (tam > tamMayorA) {
                        tamMayorA = tam;
                        inicioMayor = inicio;
                    }
                }

            }
        }
        return inicioMayor;
    }

    private static void reemplazar(int[] a, int[] b, int iniMayorA, int finMayorA, int iniMayorB, int finMayorB) {
        System.out.println(iniMayorA);
        System.out.println(finMayorA);
        // reemplazar de A la sec de mayor tam con la secuencia de mayor tam de B
        int tamA = finMayorA - iniMayorA + 1;
        int tamB = finMayorB - iniMayorB + 1;
        int diferencia = 0;
        if (tamA > tamB) {
            diferencia = tamA - tamB;
            while (diferencia > 0) {
                corrimientoizq(a, iniMayorA);
                diferencia--;
            }

        }
        if (tamB > tamA) {
            diferencia = tamB - tamA;
            while (diferencia > 0) {
                corrimiento_der(a, iniMayorA);
                diferencia--;
            }
        }

        for (int i = iniMayorB; i <= finMayorB; i++) {
            a[iniMayorA] = b[i];
            iniMayorA++;
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

    public static void corrimientoizq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void corrimiento_der(int[] arr, int pos) {
        for (int i = MAX - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

}
