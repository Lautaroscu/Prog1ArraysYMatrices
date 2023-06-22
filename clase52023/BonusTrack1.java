package clase52023;

public class BonusTrack1 {
    public static final int MAX = 20;
    public static final int separador = -1;

    public static void main(String[] args) {
        double arr[] = { -1, 23.5, 80.00, 12.45, -1, 44.4, 48.00, 150.00, -1, 120.00, 40.00, 15.50, 10.00, -1, 9.00, -1,
                19.50, 20.00, 51.00, -1 };
        obtenerMayor_Menor_y_Promedio_Ticket(arr);

    }

    public static void obtenerMayor_Menor_y_Promedio_Ticket(double[] arr) {
        int inicio = iniMayor(arr);
        int fin = buscar_fin(arr, inicio);
        System.out.println(importeMenor(arr, inicio, fin));
        System.out.println(importeMayor(arr, inicio, fin));
        System.out.println(importePromedio(arr, inicio, fin));

    }

    public static int iniMayor(double[] arr) {
        int inicio = 0;
        int fin = 0;
        int iniMayor = 0;
        double importeMayor = 0;
        while (inicio < MAX) {
            inicio = buscar_ini(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arr, inicio);
                if (fin < MAX) {
                    double suma = sumatoria_ticket(arr, inicio, fin);
                    if (suma > importeMayor) {
                        importeMayor = suma;
                        iniMayor = inicio;
                    }
                }

            }

        }
        return iniMayor;

    }

    public static double sumatoria_ticket(double[] arr, int inicio, int fin) {
        double suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += arr[i];

        }
        return suma;
    }

    private static double importeMenor(double[] arr, int ini, int fin) {
        double menor = Double.MAX_VALUE;
        for (int i = ini; i <= fin; i++) {
            if (arr[i] < menor) {
                menor = arr[i];
            }
        }
        return menor;
    }

    private static double importeMayor(double[] arr, int ini, int fin) {
        double menor = Double.MIN_VALUE;
        for (int i = ini; i <= fin; i++) {
            if (arr[i] > menor) {
                menor = arr[i];
            }
        }
        return menor;
    }

    private static double importePromedio(double[] arr, int inicio, int fin) {
        return (sumatoria_ticket(arr, inicio, fin)) / (fin - inicio + 1);
    }

    public static int buscar_ini(double[] arr, int pos) {
        while (pos < MAX && arr[pos] == separador) {
            pos++;
        }
        return pos;
    }

    public static int buscar_fin(double[] arr, int pos) {
        while (pos < MAX && arr[pos] != separador) {
            pos++;
        }
        return pos - 1;
    }
}
