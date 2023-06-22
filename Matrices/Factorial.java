
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(7));

    }

    public static int factorial(int numero) {
        if (numero == 1) {
            return 1;

        }
        return numero * factorial(numero - 1);
    }
}
