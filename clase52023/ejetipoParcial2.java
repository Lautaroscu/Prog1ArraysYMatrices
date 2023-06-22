
package clase52023;
/* 
 * 2do Ejercicio tipo parcial
Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las
secuencias están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha
comportado su animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad
N de repeticiones. Un patrón que se repite una cierta cantidad de veces consecutivas significa que el animal
puede estar pastoreando, caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado
con -1 (de tamaño igual al arreglo que tiene los datos), hacer un programa en JAVA que:
- Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
siguen repitiendo consecutivamente luego de la cantidad N.
 */

public class ejetipoParcial2 {
    public static final int MAX = 21;
    public static final int N = 2;

    public static void main(String[] args) {
        int[] arr = { -1, 12, 22, 44, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 57, -1 };
        int[] patron = { -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, 34, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        eliminarPatronesConsectivos(arr, patron);
        imprimir_arr(arr);

    }

    private static void eliminarPatronesConsectivos(int[] arr, int[] patron) {
        int contador = 0, iniPatron = 0, finPatron = 0, iniArr = 0, finArr = 0;
        iniPatron = obtener_inicio(patron, finPatron + 1);
        finPatron = obtener_fin(patron, iniPatron);
        while (iniArr < MAX) {
            iniArr = obtener_inicio(arr, finArr + 1);
            if (iniArr < MAX) {
                finArr = obtener_fin(arr, iniArr);
                if (finArr < MAX) {
                    if (esPatron(arr, patron, iniArr, finArr, iniPatron, finPatron)) {
                        contador++;
                        if (contador > N) {
                            eliminar_sec(arr, iniArr, finArr);
                            finArr = iniArr;

                        }
                    }

                }
            }

        }
    }

    public static void eliminar_sec(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    private static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static boolean esPatron(int[] arr, int[] patron, int iniArr, int finArr, int iniP, int finP) {
        int tamArr = finArr - iniArr + 1;
        int tamP = finP - iniP + 1;
        if (tamArr != tamP || tamArr == 1)
            return false;

        while (iniArr <= finArr && arr[iniArr] == patron[iniP]) {
            iniArr++;
            iniP++;
        }
        return iniArr > finArr;
    }

    public static int obtener_inicio(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == -1) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != -1) {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimir_arr(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }

}
