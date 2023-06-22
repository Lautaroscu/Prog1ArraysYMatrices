public class elimarPares {
    public static final int MAX = 6;

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5, 8 };
        for (int i = 0; i < MAX; i++) {
            if (arr[i] % 2 == 0) {
                corrimiento_izq(arr, i);
            }
            System.out.println(" ");
            imprimir_arreglo(arr);
        }

        System.out.println(" ");

    }

    private static void corrimiento_izq(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
