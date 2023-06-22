
/* 
reemplazar la secuencia de mayor tam de A por la de mayor tam de B
*/
public class mayoresSec {
    public static final int MAX = 10;

    public static void main(String[] args) {
        char[] A = { ' ', 'a', 'h', 'f', ' ', 'a', 'g', ' ', ' ', ' ' }; // IniMAyor = A[1] , FinMayor = A[3]
        char[] B = { ' ', 'e', 'v', ' ', ' ', 'a', 'g', 'c', 'b', ' ' };// IniMAyor = B[5] , FinMayor = B[8]
        System.out.println(' ');

        IntercambiarSecuenciaMayor(A, B);
        imprimir_arr_enteros(A);

    }

    public static void IntercambiarSecuenciaMayor(char[] A, char[] B) {
        int iniMayorA = secuenciaMayor(A);
        int finMAyorA = obtenerfin(A, iniMayorA);
        int iniMAyorB = secuenciaMayor(B);
        int finMayorB = obtenerfin(B, iniMAyorB);

        reemplazarSecDeAenB(A, B, iniMayorA, finMAyorA, iniMAyorB, finMayorB);
    }

    private static void reemplazarSecDeAenB(char[] a, char[] b, int iniMayorA, int finMAyorA, int iniMAyorB,
            int finMayorB) {
        int dif = 0;
        int tamA = finMAyorA - iniMayorA + 1;
        int tamB = finMayorB - iniMAyorB + 1;
        if (tamA > tamB) {
            dif = tamA - tamB;
            while (dif > 0) {
                corrimiento_izq(a, iniMayorA);
                dif--;
            }
        }
        if (tamA < tamB) {
            dif = tamB - tamA;
            while (dif > 0) {
                corrimiento_der(a, iniMayorA);
                dif--;
            }
        }
        for (int i = iniMAyorB; i <= iniMAyorB; i++) {
            a[iniMayorA] = b[i];
            iniMayorA++;
        }
    }

    private static void corrimiento_izq(char[] a, int iniMayorA) {
        for (int i = iniMayorA; i < MAX - 1; i++) {
            a[i] = a[i + 1];
        }
    }

    private static void corrimiento_der(char[] a, int iniMayorA) {
        for (int i = MAX - 1; i > iniMayorA; i--) {
            a[i] = a[i - 1];
        }
    }

    public static int secuenciaMayor(char[] arr) {
        int tamMayor = 0;
        int iniMayor = 0;
        int inicio = 0;
        int fin = 0;
        while (inicio < MAX) {
            inicio = obtener_inico(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerfin(arr, inicio);
                if (fin < MAX) {
                    int tam = fin - inicio + 1;
                    if (tam > tamMayor) {
                        tamMayor = tam;
                        iniMayor = inicio;
                    }
                }
            }
        }

        return iniMayor;

    }

    public static int obtener_inico(char[] arr, int pos) {
        while (pos < MAX && arr[pos] == ' ') {
            pos++;
        }
        return pos;
    }

    public static int obtenerfin(char[] arr, int pos) {
        while (pos < MAX && arr[pos] != ' ') {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimir_arr_enteros(char[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
