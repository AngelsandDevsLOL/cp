package Random;

import java.util.Scanner;

public class WOSSMovingSand {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] psa = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            psa[i] += psa[i - 1] + sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if (a == 1) {
                psa[b - 1] += c;
            } else if (a == 2) {
                psa[b] -= c;
            } else {
                System.out.println(psa[c] - psa[b - 1]);
            }
        }
    }
}
