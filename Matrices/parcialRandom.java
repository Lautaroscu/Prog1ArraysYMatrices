/*
dados dos arreglos (AR y RES) AR de secuencias de enteros positivos separadas por ceros y RES inicializado en -1. 
ambos de tamaño MAX.
 copiar en RES, la secuencia de igual numeros mas repetida de AR 
  */

public class parcialRandom {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] AR = { 0, 3, 3, 0, 0, 0, 4, 4, 4, 0, 0, 7, 4, 1, 0, 0, 3, 3, 0, 0 };
        int[] RES = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        copiarSecNumerosRepEnRes(AR, RES);
        imprimir_arreglo(RES);
    }

    private static void copiarSecNumerosRepEnRes(int[] AR, int[] RES) {
        int inicio = 0;
        int fin = 0;
        int iniCumple = 0;
        int finCumple = 0;
        int masRep = 0;
        while (inicio < MAX) {
            int contador = 1;
            inicio = obtener_incio(AR, fin + 1);
            if (inicio < MAX) {
                fin = obtener_fin(AR, inicio);
                if (fin < MAX) {
                    if (numeros_iguales(AR, inicio, fin)) {
                        int newini = inicio;
                        int newfin = fin;
                        while (newini < MAX) {
                            newini = obtener_incio(AR, newfin + 1);
                            newfin = obtener_fin(AR, newini);
                            if (son_iguales(AR, inicio, fin, newini, newfin)) {
                                contador++;
                            }

                        }
                        if (contador > masRep) {
                            masRep = contador;
                            finCumple = fin;
                            iniCumple = inicio;

                        }
                    }
                }
            }
        }
        copiarSec(AR, RES, iniCumple, finCumple);
    }

    public static boolean son_iguales(int[] AR, int ini1, int fin1, int ini2, int fin2) {
        int tam1 = fin1 - ini1 + 1;
        int tam2 = fin2 - ini2 + 1;
        while (ini1 < fin1 && tam1 == tam2 && AR[ini1] == AR[ini2]) {
            ini1++;
            ini2++;
        }
        return ini1 == fin1;
    }

    private static void copiarSec(int[] AR, int[] RES, int iniRep, int finRep) {
        int pos = 0;
        while (iniRep <= finRep) {
            RES[pos] = AR[iniRep];
            pos++;
            iniRep++;
        }
    }

    public static boolean numeros_iguales(int[] arr, int inicio, int fin) {
        if (fin - inicio + 1 == 1)
            return false;
        for (int i = inicio; i < fin; i++) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
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
