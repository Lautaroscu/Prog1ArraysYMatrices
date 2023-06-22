import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            int numero = 0;
            int numero1 = 0;
            int numero2 = 0;
            System.out.println("Ingrese un Entero distinto de 0");
            numero = Integer.valueOf(entrada.readLine());
            // pedir un numero
            while (numero != 0) {
                // en caso de que el numero cumpla ser != 0
                System.out.println("Ingrese dos numeros enteros ");

                numero1 = Integer.valueOf(entrada.readLine());
                numero2 = Integer.valueOf(entrada.readLine());
                System.out.println("Ingrese un Entero distinto de 0");
                // volvemos a pedir un numero != de 0 para que se reinicie el bucle
                numero = Integer.valueOf(entrada.readLine());
                // en caso de ser 0 este numero, sale y
                // multiplica numero1*numero2
            }
            System.out.println(numero1 * numero2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
