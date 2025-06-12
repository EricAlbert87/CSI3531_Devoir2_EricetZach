import java.util.Scanner;

public class Fibonacci{
    private static int[] fibonacciSequence;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de termes de Fibonacci à générer : ");
        int n = scanner.nextInt();
        fibonacciSequence = new int[n];

        Thread fibonacciGenerator = new Thread(() -> {
            if (n > 0) fibonacciSequence[0] = 0;
            if (n > 1) fibonacciSequence[1] = 1;
            for (int i = 2; i < n; i++) {
                fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
            }
        });

        fibonacciGenerator.start();
        scanner.close();

        try {
            fibonacciGenerator.join(); // Attente que le thread enfant termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Suite de Fibonacci :");
        for (int num : fibonacciSequence) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
