
/* Se tiene una matriz de caracteres letra minuscula, 
 * Inciso A: Para las primeras tres filas que tienen una cantidad impar de vocales, se pide obtener
 * el numero de la fila que tiene la menor cantidad de consonantes.
 * inciso B: Agregar en un arreglo de caracteres letra minuscula ordenado ascendente, (manteniendo su orden en todo momento) ,
 * las consonantes > al caracter letra minuscula f de la fila correspondiente al numero de fila obtenida en el inciso A.
 * Observaciones: El tam del arreglo , es igual a la cantidad de filas de la matriz.
 */
public class final_ejemplo3 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;
    public static final int FILASCUMPLEN = 3;
    static char[][] mat = { { 'j', 'g', 'a', 'y', 'r', 'd', 'e', 'o', 'i', 'b' },
            { 'h', 'c', 'a', 'i', 't', 'r', 'o', 's', 'z', 'x' },
            { 'n', 'a', 'h', 's', 't', 'm', 'i', 'o', 't', 'q' },
            { 'q', 's', 'k', 'o', 'a', 'h', 'i', 'y', 's', 'z' },
            { 's', 'd', 'b', 's', 'i', 's', 'h', 'f', 'a', 'p' }
    };
    static char[] arr = { 'a', 'b', 'c', 'd', 'e' };

    public static void main(String[] args) {
        // imprimir_mat_enteros(mat);
        // imprimir_arr_enteros(arr);
        // insertconsonantes(arr ,mat);
        // imprimir_arr_enteros(arr);
        vocales_impares(mat);

    }

    public static void vocales_impares(char[][] mat) {
        int vocales = vocalesImpares(mat);
        System.out.print(vocales);
    }

    public static int vocalesImpares(char[][] mat) {
        int consonantesGuardadas = MAXCOL;
        int filaMenorCumple = 0;
        int filasImpares = 0;
        for (int fila = 0; fila <= MAXFIL; fila++) {
            // verificar filas que cumplen
            if (cumplen(mat[fila]) && filasImpares < FILASCUMPLEN) {
                filasImpares++;
                int consonantes = 0;
                for (int col = 0; col < MAXCOL - 1; col++) {

                    switch (mat[fila][col]) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u': {
                            // no me sirven vocales
                        }
                            break;

                        default:
                            consonantes++;
                            break;

                    }

                }
                if (consonantes < consonantesGuardadas) {
                    consonantesGuardadas = consonantes;
                    filaMenorCumple = fila;
                }

            }

        }
        return filaMenorCumple;
    }

    public static void insertconsonantes(char[] arr, char[][] mat) {
        int filaMenorCumple = vocalesImpares(mat);
        for (int col = 0; col < MAXCOL - 1; col++) {
            switch (mat[filaMenorCumple][col]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': {
                    // no me sirven vocales
                }
                    break;

                default:
                    if (mat[filaMenorCumple][col] > 'f') {
                        int pos = 0;
                        while (pos < MAXFIL - 1) {
                            corrimiento_der(arr, col);
                            arr[pos] = (char) col;
                            orderAsc(arr);

                            pos++;
                        }

                    }
                    break;

            }
        }
    }

    public static void orderAsc(char[] arr) {
        int guardado = 0;
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = i + 1; j < MAXFIL; j++) {
                if (arr[i] > arr[j]) {
                    guardado = arr[i];
                    arr[i] = arr[j];
                    arr[j] = (char) guardado;

                }
            }

        }
    }

    public static void corrimiento_der(char[] arr, int pos) {
        for (int i = MAXFIL; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static boolean cumplen(char[] arr) {
        int col = 0;
        int impar = 0;
        while (col < MAXCOL - 1) {
            switch (arr[col]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': {

                    impar++;
                }
                    break;

                default:
                    break;

            }
            col++;

        }
        return (impar % 2 != 0);
    }

    public static void imprimir_arr_enteros(char[] arr) {
        for (int i = 0; i < MAXFIL; i++) {
            System.out.print(arr[i] + "|");
        }
    }

    public static void imprimir_mat_enteros(char[][] mat) {
        System.out.println("Matriz de Secuencias");
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }
    }
}
