
/*
 * /*
Tema 2: Se tiene un arreglo A de secuencias de enteros y un arreglo B de enteros ordenado ascendente. Cada secuencia de A tiene números primos (solo divisible por 1 y por sí mismo) 
o múltiplos de 5. 
Además se tiene el siguiente método pre-existente: _un método que permite obtener el índice inicial de la secuencia con menor cantidad de números múltiplos de un valor dado
 para un arreglo de secuencias.
Se pide realizar el programa y los métodos que permitan agregar en B (manteniendo su orden) los números primos de la secuencia de A con menor cantidad de números múltiplos de 5.
Observaciones: _los arreglos son de tamaño MAX y están precargados,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_definir el encabezado del método pre-existente (no hay que implementarlo),
_no realizar métodos de carga e impresión de arreglos ni utilizar arreglos auxiliares.
 */

public class parcialTema2 {
    public static final int MAX = 10;
    public static final int MULTIPLO = 5;

    public static void main(String[] args) {
        int arregloA[] = { 0, 2, 25, 7, 0, 5, 15, 3, 2, 0 };
        int arregloB[] = { 0, 1, 3, 8, 9, 20, 27, 30, 50, 100 };
        agregarEnBPrimosDeA(arregloA, arregloB);
        imprimir_arreglo(arregloB);

    }

    private static void agregarEnBPrimosDeA(int[] arregloA, int[] arregloB) {
        int inicioMenor = inicioSecMenosCantMultiplos(arregloA, MULTIPLO);
        int finMenor = obtener_fin(arregloA, inicioMenor);
        insertarPrimosOrdenados(arregloA, arregloB, inicioMenor, finMenor);
    }

    private static void insertarPrimosOrdenados(int[] arregloA, int[] arregloB, int inicioMenor, int finMenor) {
        while (inicioMenor <= finMenor) {
            if (esPrimo(arregloA[inicioMenor])) {
                insertar_ordenado(arregloB, arregloA[inicioMenor]);
            }
            inicioMenor++;
        }
    }

    private static void insertar_ordenado(int[] arregloB, int value) {
        int pos = 0;
        while (pos < MAX) {
            if (arregloB[pos] > value) {
                corrimiento_der(arregloB, pos);
                imprimir_arreglo(arregloB);

                arregloB[pos] = value;
                return;
            }
            pos++;
        }
    }

    private static void corrimiento_der(int[] arr, int pos) {
        for (int i = MAX - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    private static boolean esPrimo(int value) {
        if (value < 2)
            return false;

        for (int i = 2; i < value; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

    public static int inicioSecMenosCantMultiplos(int[] arr, int multiplo) {
        int inicio = 0;
        int fin = 0;
        int iniMenor = 0;
        int SecMenor = MAX - 1;
        while (inicio < MAX) {
            inicio = obtener_incio(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtener_fin(arr, inicio);
                if (fin < MAX) {
                    int cantMultiplos = obtener_cantidad_multiplos(arr, inicio, fin, multiplo);
                    if (cantMultiplos < SecMenor) {
                        SecMenor = cantMultiplos;
                        iniMenor = inicio;
                    }

                }
            }
        }
        return iniMenor;
    }

    private static int obtener_cantidad_multiplos(int[] arr, int inicio, int fin, int multiplo2) {
        int cantMultiplos = 0;
        for (int i = inicio; i <= fin; i++) {
            if (arr[i] % multiplo2 == 0) {
                cantMultiplos++;
            }
        }
        return cantMultiplos;
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