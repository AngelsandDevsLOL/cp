package LCC;

import java.util.Scanner;

public class s1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] psa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt() * (i % 2 == 0 ? -1 : 1);
            psa[i] += psa[i - 1] + x;
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(psa[b] - psa[a - 1]);
        }
    }
}
