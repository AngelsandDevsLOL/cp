package Random;

import java.util.HashSet;
import java.util.Scanner;

public class ANewPrimeFactorization {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        HashSet<Integer> hSet = new HashSet<>();
        int x = y;
        for (int i = 2; i < y / 2; i++) {
            while (y % i == 0) {
                hSet.add(i);
                y = y / i;
                x = y;
            }
        }
        for (int integer : hSet) {
            System.out.println(integer);
        }
        if (x != 1) {
            System.out.println(x);
        }
    }
}
