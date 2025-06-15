
class FibonacciThread extends Thread {
    private int[] fib;
    public FibonacciThread(int[] fib) {
        this.fib = fib;
    }
    
    @Override
    public void run() {
        if (this.fib.length > 0) this.fib[0] = 0;
        if (this.fib.length > 1) this.fib[1] = 1;
        for (int i = 2; i < this.fib.length; i++) {
            this.fib[i] = this.fib[i - 1] + this.fib[i - 2];
        }
    }
}

public class Fibonacci {
    private static int[] fib;

    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argument invalide, veuillez entrer un entier.");
            return;
        }
        
        //tableau partagé
        fib = new int[n];

        FibonacciThread fibThread = new FibonacciThread(fib);

        fibThread.start();

        // Attente que le thread enfant termine
        try {
            fibThread.join(); 
        } catch (InterruptedException e) {
            System.err.println("Le thread a été interrompu: " + e); // print error message
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite: " + e);
        }
        
        // Affichage de la suite de Fibonacci
        System.out.println("Suite de Fibonacci:");
        // Parcourir le tableau fib pour imprimer les termes
        System.out.print("[ ");
        for (int x : fib) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}
