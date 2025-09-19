package Random;

import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {
    public static int[] memo;
    public static int[] height;
    public static int k;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); k = sc.nextInt();
        memo = new int[n];
        height = new int[n];
        Arrays.fill(memo, -1); memo[0] = 0;
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            height[i] = h;
        }
        method(n - 1);
        System.out.println(memo[n - 1]);
    }
    public static void method (int x) {
        if (memo[x] == -1) {
            method(x - 1);
            memo[x] = memo[x - 1]  + Math.abs(height[x] - height[x - 1]);
        }
        for (int i = Math.max(0, x - k); i < x; i++) {
            memo[x] = Math.min(memo[x], memo[i] + Math.abs(height[i] - height[x]));
        }
    }
}
