package Random;

import java.util.Arrays;
import java.util.Scanner;

public class SimonAndMarcy {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(), m = sc.nextInt();
        int[] memo = new int[m + 1];
        for (int i = 0; i < c; i++) {
            int[] copy = Arrays.copyOf(memo, m + 1);
            int n = sc.nextInt(), k = sc.nextInt();
            for (int j = k; j <= m; j++) {
                copy[j] = Math.max(memo[j], memo[j - k] + n);
            }
            memo = copy;
        }
        System.out.println(memo[m]);
    }
}
