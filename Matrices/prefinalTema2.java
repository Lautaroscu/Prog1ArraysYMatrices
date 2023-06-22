public class prefinalTema2 {
    public static final int MAXFIL = 3;
    public static final int MAXCOL = 10;
    public static final char m = 'm';

    public static void main(String[] args) {
        char[][] mat = { { 'a', 'e', '8', '9', 'z', 'b', '8', 'd', 'l', '9' },
                { 'x', '5', 'e', '6', 'a', 'b', 'v', 'v', 'f', '8' },
                { ' ', '6', 'w', 'x', 'y', 'z', 'c', 'a', '1', 'd' },

        };
        char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
        if (verificar_consonantes_en_arr_menor_m(mat, arr)) {
            System.out.println("Todas las consonantes menores a " + m + " en la columna "
                    + obtener_indice_col_menor(mat) + " de la matriz estan en arr");
        }
    }

    private static boolean verificar_consonantes_en_arr_menor_m(char[][] mat, char[] arr) {
        int pos = 0;
        int col = obtener_indice_col_menor(mat);
        int fila = 0;
        int cantConsonantesMenoresM = obtenerCantConsonantesMenoresM(mat, col), contador = 0;
        while (fila < MAXFIL) {
            if (esConsonanteMenorM(mat[fila][col])) {
                while (pos < MAXCOL) {
                    if (mat[fila][col] == arr[pos]) {
                        contador++;
                    }
                    pos++;

                }
            }
            fila++;
        }
        return contador == cantConsonantesMenoresM;
    }

    public static int obtener_indice_col_menor(char[][] mat) {
        int col = 0, colMenor = 0, cantMenor = MAXFIL + 1;
        while (col < MAXCOL) {
            int cantConsonantesMenoresM = obtenerCantConsonantesMenoresM(mat, col);
            if (cantConsonantesMenoresM < cantMenor && cantConsonantesMenoresM > 0) {
                cantMenor = cantConsonantesMenoresM;
                colMenor = col;
            }

            col++;
        }

        return colMenor;
    }

    private static int obtenerCantConsonantesMenoresM(char[][] mat, int col) {
        int fila = 0;
        int contador = 0;
        while (fila < MAXFIL) {
            if (esDigito(mat[fila][col]))
                return -1;

            if (esConsonanteMenorM(mat[fila][col])) {
                contador++;
            }
            fila++;
        }
        return contador;
    }

    private static boolean esConsonanteMenorM(char c) {
        return esConsonante(c) && c < m;
    }

    private static boolean esConsonante(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }

    private static boolean esDigito(char c) {
        return c >= '1' && c <= '9';
    }
}
