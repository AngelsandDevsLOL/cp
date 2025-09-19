package Random;

import java.util.Scanner;

public class Railgun {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt(),t = sc.nextInt();
        int[] psa = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            psa[i + 1] = input + psa[i];
        }
        if (s * t >= n) {
            System.out.println(psa[n]);
        } else {
            int max = 0;
            for (int i = 0; i <= t; i++) { // destroyed to the left
                max = Math.max(max, psa[s * i] + psa[n] - psa[n - s * (t - i)]);
            }
            System.out.println(max);
        }
    }
}
