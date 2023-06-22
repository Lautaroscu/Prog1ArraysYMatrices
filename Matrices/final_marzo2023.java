
/* 
 * Se tiene una matriz precargada de con secuencias de caracteres letras minusculas separadas por uno o mas
 * espacios vacios, se pide realizar un programa que elimine las ultimas dos consonantes de cada secuencia.
 * 
 */
public class final_marzo2023 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;
    public static final int MAXCONSONATES = 2;

    public static void main(String[] args) {

        char[][] mat = { { ' ', 'g', 'a', 'y', 'r', ' ', 'e', 'o', 'i', ' ' },
                { ' ', 'c', 'a', 'i', 'e', 'r', ' ', 's', 'z', ' ' },
                { ' ', 'a', 'h', 's', 't', ' ', 'i', 'o', 't', ' ' },
                { ' ', 's', 'k', 'o', ' ', 'h', 'i', ' ', 's', ' ' },
                { ' ', 'd', 'b', 's', ' ', 's', 'h', ' ', 'a', ' ' }
        };
        imprimir_mat_chars(mat);
        EliminarConsonantes(mat);
        imprimir_mat_chars(mat);
    }

    public static void EliminarConsonantes(char[][] mat) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            EliminarUlt2Consonantes(mat[fila]);
        }
    }

    public static void EliminarUlt2Consonantes(char[] arr) {
        int fin = MAXCOL;
        int inicio = MAXCOL;
        while (fin >= 0) {
            fin = encontrar_fin(arr, inicio - 1);
            if (fin >= 0) {
                inicio = encontrar_inicio(arr, fin);
                if (inicio >= 0) {
                    maxdosConsonates(arr, inicio, fin);
                }

            }
        }

    }

    public static boolean esConsonante(char character) {
        return character != 'a' && (character != 'i') && character != 'o' && character != 'e' && character != 'u';
    }

    public static void maxdosConsonates(char[] arr, int inico, int fin) {
        int i = fin;
        int cantConsonantes = 0;
        while (i >= inico && cantConsonantes < MAXCONSONATES) {
            if (esConsonante(arr[i])) {
                cantConsonantes++;

                corrimiento_izq(arr, i);

            }

            i--;
        }

    }

    public static void corrimiento_izq(char[] arr, int pos) {
        while (pos < MAXCOL - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static int encontrar_inicio(char[] arr, int pos) {
        while (pos >= 0 && arr[pos] != ' ') {
            pos--;
        }
        return pos + 1;
    }

    public static int encontrar_fin(char[] arr, int pos) {
        while (pos >= 0 && arr[pos] == ' ') {
            pos--;
        }
        return pos;
    }

    public static void imprimir_mat_chars(char[][] mat) {
        System.out.println("Matriz de Secuencias");
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }
    }
}
