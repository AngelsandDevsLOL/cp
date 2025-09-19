package Random;

import java.util.Scanner;

public class SubsetMex {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] ar = new long[n];
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextLong();
            }
            long num = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (ar[j] - num >= 1) continue;
                num += 1 - (ar[j] - num);
            }
            System.out.println(num + 1);
        }
    }
}
