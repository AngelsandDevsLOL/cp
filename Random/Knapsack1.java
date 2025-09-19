package Random;

import java.util.Arrays;
import java.util.Scanner;

public class
Knapsack1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), W = sc.nextInt();
        long[] ar = new long[W + 1];
        for (int i = 0; i < N; i++) {
            int w = sc.nextInt(), v = sc.nextInt();
            long[] temp = Arrays.copyOf(ar, W + 1);
            for (int j = w; j < W + 1; j++) {
                temp[j] = Math.max(ar[j - 1], ar[j - w] + v);
            }
            ar = temp;
        }
        System.out.println(ar[W]);
    }
}
