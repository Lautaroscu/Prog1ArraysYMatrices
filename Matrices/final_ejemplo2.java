
/* Se tiene dos arreglos de secuencias de caracteres letras. Se pide realizar un programa
 * (Sin metodos de carga de arreglos que intercambie la secuencia de mayor tam de A por la secuencia de mayor tam de B).
 * 
 * 
 */
public class final_ejemplo2 {
    public static final int MAXCOL = 10;
    static int[] C = { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 };

    static char[] A = { '*', 'L', '*', '*', 'M', 'A', 'N', 'A', 'N', 'A', '*', '*', 'D', 'E', '*' };
    static char[] B = { '*', 'P', 'U', 'E', 'R', 'T', '*', '*', 'A', 'B', 'R', 'E', '*', '*' };

    public static void main(String[] args) {
        imprimir_arr_enteros(C);
        secuencia(C);

    }

    public static int obtenerInicio(int[] arr, int pos) {
        while ((pos < MAXCOL - 1) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int obtenerFin(int[] arr, int pos) {
        while ((pos < MAXCOL - 1) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static void secuencia(int[] C) {
        int inicio = 0;
        int fin = 0;
        while (inicio < MAXCOL - 1) {
            inicio = obtenerInicio(C, fin);
            if (inicio != -1) {
                fin = obtenerFin(C, inicio + 1);
                int tam = TamMayor(C, inicio, fin);
                System.out.print(tam);

            }
        }

    }

    public static int TamMayor(int[] arr, int inicio, int fin) {
        int tam = fin - inicio + 1;
        int TamMayor = 0;
        int inicioMayor = 0;
        while (inicio <= fin) {
            if (tam > TamMayor) {
                TamMayor = tam;
                inicioMayor = inicio;
            }
        }

        return inicioMayor;
    }

    public static void imprimir_arr_enteros(int[] arr) {
        for (int i = 0; i < MAXCOL; i++) {
            System.out.print(arr[i] + "|");
        }
    }

}
