import java.util.Scanner;

public class FibonacciSumLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto para leer la entrada
        System.out.print("INGRESA EL DIGITO: ");
        long n = scanner.nextLong(); // Leer el valor de n
        scanner.close(); // Cerrar el Scanner

        // Obtener el último dígito de la suma de Fibonacci
        int lastDigit = getFibonacciSumLastDigit(n);
        System.out.println("EL RESULTADO ES: " + lastDigit); // Imprimir el resultado
    }

    // Método para obtener el último dígito de la suma de Fibonacci
    public static int getFibonacciSumLastDigit(long n) {
        // Encontrar (n + 2) % 60, ya que el período Pisano mod 10 es 60
        int reducedN = (int) ((n + 2) % 60);
        int fibonacciMod10 = calculateFibonacciMod(reducedN);
        int result = (fibonacciMod10 - 1 + 10) % 10;

        return result;
    }

    public static int calculateFibonacciMod(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int temp = (previous + current) % 10;
            previous = current;
            current = temp;
        }

        return current;
    }
}