package COCI;

import java.util.Scanner;

public class Kratki {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        if (k < Math.ceil(n / 2.0)) System.out.println(-1);
        else {
            if (n == k) {
                for (int i = 0; i < k; i++) {
                    System.out.print(i + 1 + " ");
                }
            } else {
                for (int i = 0; i < k - 1; i++) {
                    System.out.print(i + 1 + " ");
                }
                System.out.print(n + " ");
                for (int i = n - 1; i >= k; i--) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
