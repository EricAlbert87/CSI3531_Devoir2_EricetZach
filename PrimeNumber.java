
public class PrimeNumber {
    public static void main(String[] args) {
        int max;
        try {
            max = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argument invalide, veuillez entrer un entier.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Veuillez fournir un argument entier.");
            return;
        }

        PrimeNumberThread primeThread = new PrimeNumberThread(max);

        // Start the thread to calculate prime numbers
        primeThread.start();
    }
}

class PrimeNumberThread extends Thread {
    private int max;
    public PrimeNumberThread(int max) {
        this.max = max;
    }

    @Override
    public void run(){    
    System.out.println("Nombres premiers jusqu'à " + this.max + ":");
            System.out.print("[ ");
            for (int i = 2; i <= this.max; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("]");
        }

    private static boolean isPrime(int n) {
        // Trial division method
        if (n <= 1) return false; 
        // create a wall with sqrt(n) *(reduce number of iterations)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}