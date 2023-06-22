/* 
 * Tema 1: Se tiene una matriz de caracteres letra minúscula.
 *  a) Para las primeras 3 filas que tienen una cantidad impar de vocales,
 *  se pide obtener el número de la fila que tiene la menor cantidad de consonantes.(CHECK )
 * 
 *  b) Agregar en un arreglo de caracteres letra minúscula ordenado ascendente (manteniendo su orden en todo momento),
 *  las consonantes mayores al caracter letra ‘f’ de la fila correspondiente al número de fila obtenido en a).
Observaciones: _el tamaño del arreglo es igual a la cantidad de filas de la matriz, _la matriz y el arreglo están precargados,
 _realizar el programa completo bien modularizado sin métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares.

 */

public class prefinalTema1 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;
    public static final int MAXCANT = 3;

    public static void main(String[] args) {
        char[][] mat = { { 'j', 'g', 'a', 'y', 'r', 'd', 'e', 'o', 'i', 'b' },
                { 'i', 'c', 'a', 'i', 'x', 'a', 'o', 'u', 'e', 't' },
                { 'n', 'a', 'h', 's', 't', 'm', 'i', 'o', 't', 'q' },
                { 'e', 'u', 'k', 'o', 'a', 'h', 'i', 'y', 's', 'z' },
                { 's', 'd', 'b', 's', 'i', 's', 'h', 'f', 'a', 'p' }
        };
        char[] arr = { 'a', 'b', 'w', 'x', 'y' };
        agregarConsonantesMayoresAF(mat, arr);

        imprimir_arreglo(arr);
    }

    // incio inciso A
    public static int obtenerNumFilaCumple(char[][] mat) {
        int filaMenor = 0;
        int cant = 0;
        int CantMenor = MAXCOL - 1;
        for (int fila = 0; fila < MAXFIL && cant < MAXCANT; fila++) {
            if (cantImparVocales(mat[fila])) {
                int cantConsonantesFila = obtenerCantConsonatesFila(mat[fila]);
                if (cantConsonantesFila < CantMenor) {
                    CantMenor = cantConsonantesFila;
                    filaMenor = fila;
                }
                cant++;
            }
        }
        return filaMenor;
    }

    public static int obtenerCantConsonatesFila(char[] fila) {
        int cant = 0;
        for (int i = 0; i < MAXCOL; i++) {
            if (!esVocal(fila[i])) {
                cant++;
            }
        }
        return cant;
    }

    public static boolean cantImparVocales(char[] fila) {
        int cant = 0;
        for (int i = 0; i < MAXCOL; i++) {
            if (esVocal(fila[i])) {
                cant++;
            }
        }
        return cant % 2 != 0;
    }

    public static boolean esVocal(char letra) {
        return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');

    }

    // fin inciso A
    // ------ ------ ------ ------- ------ ------ ------ -----
    public static void agregarConsonantesMayoresAF(char[][] mat, char[] arr) {
        int fila = obtenerNumFilaCumple(mat);
        int pos = 0;
        int i = 0;
        while (pos < MAXCOL && i < MAXFIL) {
            if (!esVocal(mat[fila][pos]) && mat[fila][pos] > 'f') {
                insertar_ordenado(arr, mat[fila][pos], i);
                i++;
            }
            pos++;
        }
    }

    public static void insertar_ordenado(char[] arr, char value, int i) {
        if (arr[i] > value) {
            corrimiento_der(arr, i);
            arr[i] = value;
        }
        int posMenor = obtener_pos_menor(arr, value);
        corrimiento_der(arr, posMenor);
        arr[posMenor] = value;

    }

    // incio inciso B
    public static int obtener_pos_menor(char[] arr, int value) {
        int pos = 0;
        while (pos < MAXFIL - 1 && arr[pos] < value) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_der(char[] arr, int pos) {
        for (int i = MAXFIL - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    // fin iniciso B
    public static void imprimir_arreglo(char[] arr) {
        for (int i = 0; i < MAXFIL; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}