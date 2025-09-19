package Algorithms;

import java.util.Scanner;

public class BIT {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), m = sc.nextLong();
        n %= m;
        System.out.println(Math.min(n, m - n));
    }
}
