package COCI;

import java.util.Scanner;

public class Ozljeda {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long[] input = new long[2 * k + 3];
        for (int i = 1; i <= k; i++) {
            long x = sc.nextLong();
            input[i] = x;
        }
        for (int i = 1; i <= k; i++) {
            input[i] ^= input[i - 1];
        }
        for (int i = k + 1; i < input.length; i++) {
            input[i] = input[i - k - 1];
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = (int)((sc.nextLong() - 1) % (k + 1)), r = (int)(sc.nextLong() % (k + 1) + k + 1);
            System.out.println(input[r] ^ input[l]);
        }
    }
}
