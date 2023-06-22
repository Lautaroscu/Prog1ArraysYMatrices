/* Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada permita encontrar por cada fila la posición de inicio y fin de la
secuencia cuya suma de valores sea mayor. */
public class clase8_ejer11 {
    public static final int MAXFIL = 5;
    public static final int MAXCOL = 10;

    public static void main(String[] args) {

        int[][] mat = /* 0 */ { { 0, 3, 0, 5, 0, 3, 4, 0, 1, 0 },
                { 0, 0, 2, 0, 9, 7, 0, 2, 0, 0 },
                { 0, 4, 0, 6, 7, 0, 1, 9, 0, 0 },
                { 0, 6, 0, 8, 0, 0, 1, 0, 5, 0 },
                { 0, 0, 0, 2, 1, 5, 0, 6, 3, 0 }
        };
        imprimir_mat_enteros(mat);
        recorrer_por_fila(mat);

    }

    public static void imprimir_mat_enteros(int[][] mat) {
        System.out.println("Matriz de Secuencias");
        for (int i = 0; i < MAXFIL; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

    public static int encontrar_inicio_sec(int[] arr, int inicio) {
        int pos = inicio;
        while (pos < MAXCOL - 1 && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int encontrar_fin_sec(int[] arr, int fin) {
        int pos = fin;
        while (pos < MAXCOL - 1 && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void recorrer_por_fila(int[][] mat) {
        for (int fila = 0; fila < MAXFIL; fila++) {
            recorrer_por_columa(mat[fila]);
        }
    }

    public static void recorrer_por_columa(int[] arr) {
        int inicio = 0;
        int fin = -1;
        int suma;
        int sumaMayor = 0;
        int iniMayor = 0;
        int finMayor = 0;
        while (inicio < MAXCOL - 1) {
            inicio = encontrar_inicio_sec(arr, fin + 1);

            if (inicio < MAXCOL) {
                fin = encontrar_fin_sec(arr, inicio);
                if (fin < MAXCOL) {
                    suma = Sumar(arr, inicio, fin);
                    if (suma > sumaMayor) {
                        sumaMayor = suma;
                        iniMayor = inicio;
                        finMayor = fin;
                    }

                }
            }
        }
        System.out.println("El Inicio y Fin de La secuencia que mas suma de la fila es " + iniMayor + " " + finMayor
                + " Suman un total de " + sumaMayor);
    }

    public static int Sumar(int[] arr, int inicio, int fin) {
        int suma = 0;
        while (inicio <= fin) {
            suma += arr[inicio];
            inicio++;
        }
        return suma;
    }
}
