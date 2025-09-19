package NoContest;

import java.util.Scanner;

public class Primes {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int x = 2;
        while (i != n) {
            if (isPrime(x)) {
                System.out.println(x);
                i++;
            }
            x++;
        }
    }
    public static boolean isPrime(int x) {
        boolean bool = true;
        if (x > 2 && x % 2 == 0) bool = false;
        for (int i = 3; i <= Math.sqrt(x); i = i + 2) {
            if (x % i == 0) bool = false;
        }
        return bool;
    }
}
