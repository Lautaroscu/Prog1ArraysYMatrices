/* 
 * Dado dos arreglos de enteros AR y NUEVO, ambos con secuencias de enteros separadas por
 *  uno o mas ceros,y ambos arrelgos empiezan y terminan con uno o mas ceros.
 *  AR esta ordenado ascendente por la suma de los valores de cada secuencia.
 * Se pide insertar en AR manteniendo su orden una secuencia de NUEVO.
 * 
 */

public class parcialRandom2 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int AR[] = { 0, 2, 3, 0, 5, 6, 0, 8, 9, 0 };
        int NUEVO[] = { 0, 9, 10, 0, 0, 6, 7, 0, 9, 0 };
        insertarSecNuevaEnAR(AR, NUEVO);
        imprimir_arreglo(AR);

    }

    private static void insertarSecNuevaEnAR(int[] AR, int[] NUEVO) {
        int finNuevo = 0;
        int iniNuevo = obtener_inicio(NUEVO, finNuevo + 1);
        finNuevo = obtener_fin(NUEVO, iniNuevo);
        int iniAR = obtener_inicio_menor(AR, NUEVO, iniNuevo, finNuevo);

        insertarOrdenado(AR, NUEVO, iniAR, iniNuevo, finNuevo);

    }

    private static void insertarOrdenado(int[] aR, int[] NUEVO, int iniAR, int iniNuevo, int finNuevo) {
        int tamSecNUEVO = finNuevo - iniNuevo + 1;
        int tam = tamSecNUEVO + 1;
        while (tam > 0) {
            corrimiento_izq_limite(aR, 0, iniAR - 1);
            imprimir_arreglo(aR);
            tam--;
        }
        tam = tamSecNUEVO + 1;
        int i = iniAR - tam;
        while (tamSecNUEVO > 0) {
            aR[i] = NUEVO[iniNuevo];
            iniNuevo++;
            i++;
            tamSecNUEVO--;
        }

    }

    public static int obtener_sumatoria_sec(int[] arr, int inicio, int fin) {
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += arr[i];
        }

        return suma;
    }

    private static int obtener_inicio_menor(int[] AR, int[] NUEVO, int iniNuevo, int finNuevo) {
        int inicioAR = 0;
        int finAR = 0;
        while (inicioAR < MAX && obtener_inicio(AR, finAR + 1) != MAX) {
            inicioAR = obtener_inicio(AR, finAR + 1);
            if (inicioAR < MAX) {
                finAR = obtener_fin(AR, inicioAR);
                if (finAR < MAX) {
                    int sumaSecAr = obtener_sumatoria_sec(AR, inicioAR, finAR);
                    int sumaNevo = obtener_sumatoria_sec(NUEVO, iniNuevo, finNuevo);
                    if (sumaSecAr > sumaNevo) {
                        return inicioAR;
                    }
                }
            }

        }
        return MAX - 1;

    }

    public static int obtener_inicio(int[] arr, int pos) {
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

    public static void corrimiento_der(int[] arr, int pos) {
        for (int i = MAX - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void corrimiento_izq_limite(int[] arr, int pos, int limit) {
        while (pos < limit) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
    }
}
