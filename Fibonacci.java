import java.util.Scanner;

public class Fibonacci {
    private static int[] fib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de termes de Fibonacci à générer: ");
        int n = scanner.nextInt();
        scanner.close();
        fib = new int[n];

        Thread fibThread = new Thread(() -> {
            if (n > 0) fib[0] = 0;
            if (n > 1) fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        });

        fibThread.start();
        // Attente que le thread enfant termine
        try {
            fibThread.join(); 
        } catch (InterruptedException e) {
            System.err.println("Le thread a été interrompu: " + e); // print error message
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite: " + e);
        }

        System.out.println("Suite de Fibonacci:");
        // Parcourir le tableau fib pour imprimer les termes
        for (int x : fib) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
