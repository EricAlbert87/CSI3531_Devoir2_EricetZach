import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre: ");
        int max = scanner.nextInt();
        scanner.close();

        Thread primeThread = new Thread(() -> {
            System.out.println("Nombres premiers jusqu'à " + max + ":");
            for (int i = 2; i <= max; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        });

        primeThread.start();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
