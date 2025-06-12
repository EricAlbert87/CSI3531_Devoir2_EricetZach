import java.util.Scanner;

public class Fibonacci {
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nombre de termes de Fibonacci à générer : ");
        int n = sc.nextInt();
        arr = new int[n];

        Thread t = new Thread(() -> {
            if (n > 0) arr[0] = 0;
            if (n > 1) arr[1] = 1;
            for (int i = 2; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        });

        t.start();
        sc.close();

        try {
            t.join(); // Attente que le thread enfant termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Suite de Fibonacci :");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
