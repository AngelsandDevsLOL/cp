package CCC.MockS;

import java.util.Scanner;

public class CompositeFibonacciNumbers {
    public static boolean[] vis = new boolean[(int) 1e5 + 1];
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        fibonacci(0, 1);
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (vis[n]) {
                if (isPrime(n)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }

    }
    public static void fibonacci (int x, int y) {
        if (x + y >= 1e5) return;
        vis[x + y] = true;
        fibonacci(y, x + y);
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) return true;
        }
        return false;
    }
}
