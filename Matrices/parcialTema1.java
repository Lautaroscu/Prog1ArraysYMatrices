public class parcialTema1 {
    /*
     * /*
     * Tema 1: Se tiene un arreglo A de enteros ordenado ascendente, y un arreglo B
     * de secuencias de enteros donde
     * cada secuencia tiene múltiplos de 2 o múltiplos de 3 o números primos
     * (solo divisible por 1 y por sí mismo).
     * Además se tiene el siguiente método pre-existente: _un método que permite
     * obtener el índice final de la
     * secuencia con mayor cantidad de números primos de un arreglo de secuencias.
     * Se pide realizar el programa y los métodos que permitan eliminar de A los
     * números primos de
     * la secuencia de B con mayor cantidad de números primos.
     * Observaciones: _los arreglos son de tamaño MAX y están precargados,
     * _las secuencias están separadas por uno o más ceros, empiezan y terminan con
     * uno o más ceros,
     * _definir el encabezado del método pre-existente (no hay que implementarlo),
     * _no realizar métodos de carga e impresión de arreglos ni utilizar arreglos
     * auxiliares.
     */
    public static final int MAX = 11;

    public static void main(String[] args) {
        int[] arrA = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12 };
        int[] arrB = { 0, 2, 8, 0, 3, 0, 0, 5, 2, 7, 0 };
        eliminarPrimosA(arrA, arrB);
        imprimir_arreglo(arrA);

    }

    public static void eliminarPrimosA(int[] arrA, int[] arrB) {
        int inicio = 0;
        int fin = 0;
        int iniMayor = 0;
        int finMayor = 0;
        int secMayor = 0;
        while (inicio < MAX) {
            inicio = buscar_ini(arrB, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arrB, inicio);
                if (fin < MAX) {
                    int cantPrimos = cantPrimosSec(arrB, inicio, fin);
                    if (cantPrimos > secMayor) {
                        secMayor = cantPrimos;
                        iniMayor = inicio;
                        finMayor = fin;
                    }
                }

            }
        }
        eliminarOcurrencias(arrA, arrB, iniMayor, finMayor);

    }

    public static void eliminarOcurrencias(int[] arrA, int[] arrB, int iniMayor, int finMayor) {
        while (iniMayor <= finMayor) {
            int pos = obtener_pos_igual(arrA, arrB[iniMayor]);
            corrimientoizq(arrA, pos);
            iniMayor++;

        }
    }

    public static int obtener_pos_igual(int[] A, int primoB) {
        int pos = 0;
        while (pos < MAX && A[pos] != primoB) {
            pos++;
        }
        return pos;
    }

    public static int cantPrimosSec(int[] arr, int inicio, int fin) {
        int primos = 0;
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(arr[i])) {
                primos++;
            }
        }
        return primos;

    }

    public static boolean esPrimo(int numero) {
        return (numero % 2 != 0 && numero % 3 != 0) || (numero == 2 || numero == 3);
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

    public static void corrimientoizq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }

}
