package WLMOJ;

import java.util.Scanner;

public class SnowballMaking {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] ar = new int[m + 1];
        for (int i = 0; i < n; i++) {
            ar[sc.nextInt()]++;
        }
        int count = ar[m];
        for (int i = 1; i <= Math.ceil(m / 2.0) - 1; i++) {
            count += Math.min(ar[m - i], ar[i]);
        }
        if (m % 2 == 0) {
            count += ar[m / 2] / 2;
        }
        System.out.println(count);
    }
}
