package clase52023;

/*
 * Cuando se debe procesar texto expresado en lenguaje natural, una de las primeras tareas que se realiza es la de
eliminación de stopwords. Las stopwords son palabras muy comunes en un determinado lenguaje, por ejemplo,
artículos (el, la, las, los...), preposiciones (a, ante, con, por...), etc.
Dado un texto almacenado en un arreglo de caracteres de tamaño MAX_A, donde cada palabra está delimitada
por espacios, comas (,) o puntos (.) se pide eliminar todas las stopwords almacenadas en otro arreglo de
caracteres de tamaño MAX_S que se encuentra delimitado por espacios.
 */
public class modeloExamen2023 {
    public static final int MAXA = 41;
    public static final int MAXS = 20;

    public static void main(String[] args) {
        char[] arrA = { ' ', 'l', 'a', ' ', 'c', 'a', 's', 'a', ' ', 'r', 'o', 'j', 'a', ',', ' ', 'a', ' ', 'l', 'a',
                ' ', 'v', 'u', 'e', 'l', 't', 'a', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'e', 's', 'q', 'u', 'i', 'n', 'a',
                ' ' };
        char[] arrS = { ' ', 'a', ' ', 'l', 'o', ' ', 'l', 'o', 's', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'l', 'a', 's',
                ' ' };
        System.out.println(arrS.length);
        eliminarStopWordsenA(arrA, arrS);
    }

    private static void eliminarStopWordsenA(char[] arrA, char[] arrS) {
        int inicioA = 0;
        int finA = 0;
        while (inicioA < MAXA) {
            inicioA = obtener_inicioA(arrA, finA + 1);
            if (inicioA < MAXA) {
                finA = obtener_finA(arrA, inicioA);
                if (finA < MAXA && isStopWord(arrA, arrS, inicioA, finA)) {
                    eliminarSecuencia(arrA, inicioA, finA);
                    finA = inicioA - 1;
                }
            }
        }
    }

    private static void eliminarSecuencia(char[] arrA, int inicioA, int finA) {

        for (int i = inicioA; i <= finA; i++) {
            corrimiento_izq(arrA, inicioA);
        }
    }

    private static void corrimiento_izq(char[] arrA, int pos) {
        while (pos < MAXA - 1) {
            arrA[pos] = arrA[pos + 1];
            pos++;
        }
    }

    public static boolean isStopWord(char[] arrA, char[] arrS, int inicioA, int finA) {
        int inicioS = 0;
        int finS = 0;
        int contadorStopWords = 0;
        while (inicioS < MAXS && contadorStopWords < 1) {
            inicioS = obtener_incioS(arrS, finS + 1);
            if (inicioS < MAXS) {
                finS = obtener_finS(arrS, inicioS);
                if (finS < MAXS && son_iguales(arrA, arrS, inicioA, finA, inicioS, finS)) {
                    contadorStopWords++;
                }

            }
        }
        return contadorStopWords == 1;
    }

    private static boolean son_iguales(char[] arrA, char[] arrS, int inicioA, int finA, int inicioS, int finS) {
        int tamA = finA - inicioA + 1;
        int tamS = finS - inicioS + 1;
        if (tamA != tamS)
            return false;

        while (inicioA <= finA && arrA[inicioA] == arrS[inicioS]) {
            inicioA++;
            inicioS++;
        }
        return inicioA > finA;
    }

    public static int obtener_inicioA(char[] arr, int pos) {
        while (pos < MAXA && arr[pos] == ' ' || arr[pos] == ',' || arr[pos] == '.') {
            pos++;
        }
        return pos;
    }

    public static int obtener_finA(char[] arr, int pos) {
        while (pos < MAXA && (arr[pos] != ' ' && arr[pos] != ',' && arr[pos] != '.')) {
            pos++;
        }
        return pos - 1;
    }

    public static int obtener_incioS(char[] arr, int pos) {
        while (pos < MAXS && arr[pos] == ' ') {
            pos++;
        }
        return pos;
    }

    public static int obtener_finS(char[] arr, int pos) {
        while (pos < MAXS && arr[pos] != ' ') {
            pos++;
        }
        return pos - 1;
    }
}
