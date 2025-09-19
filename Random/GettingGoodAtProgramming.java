package Random;

import java.util.Arrays;
import java.util.Scanner;

public class GettingGoodAtProgramming {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), T = sc.nextInt();
        int[] memo = new int[T + 1];
        for (int i = 0; i < N; i++) {
            int[] ar = Arrays.copyOf(memo, T + 1);
            int l = sc.nextInt();
            int curT = 0;
            int curX = 0;
            for (int j = 0; j < l; j++) {
                int t = sc.nextInt();
                int x = sc.nextInt();
                curT += t;
                curX += x;
                for (int k = T; k >= curT; k--) {
                    ar[k] = Math.max(memo[k - curT] + curX, ar[k]);
                }
            }
            memo = ar;
        }
        System.out.println(memo[T]);
    }
}