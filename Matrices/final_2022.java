
public class final_2022 {
    public static final int MAXCOL = 15;
    public static final int MAXFIL = 4;
    static char[][] mat = { { 'A', 'P', 'U', 'E', 'R', 'T', 'A', '*', '*', 'A', 'B', 'R', 'E', '*', '*' },
            { 'E', 'L', 'A', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' },
            { 'J', '*', 'J', 'U', 'A', 'N', '*', '*', '*', '*', '*', '*', '*', '*', '*' },
            { 'I', '*', '*', '*', 'M', 'A', 'N', 'A', 'N', 'A', '*', '*', 'D', 'E', '*' }
    };
    static int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static void main(String[] args) {

        insert(arr, mat);
        imprimir_arr_enteros(arr);

        orderDesc(arr);
        System.out.println(' ');
        imprimir_arr_enteros(arr);

    }

    public static int cant_vocales(int col, char[][] mat) {
        int suma = 0;
        for (int fila = 0; fila < MAXFIL; fila++) {
            switch (mat[fila][col]) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U': {
                    suma++;
                }
                    break;

                default:
                    break;
            }
        }
        return suma;
    }

    public static void insert(int[] arr, char[][] mat) {

        for (int col = 0; col < MAXCOL; col++) {
            int vocales = cant_vocales(col, mat);
            arr[col] = vocales;
            // orderDesc(arr);
        }
    }

    public static void orderDesc(int[] arr) {
        int guardado = 0;
        for (int i = 0; i < MAXCOL; i++) {
            for (int j = i + 1; j < MAXCOL; j++) {
                if (arr[i] < arr[j]) {
                    guardado = arr[i];
                    arr[i] = arr[j];
                    arr[j] = guardado;

                }
            }

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

    public static void imprimir_arr_enteros(int[] arr) {
        for (int i = 0; i < MAXCOL; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
