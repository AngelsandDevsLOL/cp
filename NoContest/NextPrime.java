package NoContest;

import java.util.Scanner;

public class NextPrime {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Math.max(2, scanner.nextInt());
        while (true) {
            if (isPrime(n)) {
                System.out.println(n);
                break;
            }
            n++;
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
