package Random;

import java.util.Scanner;

public class Deque {
    public static long[][] memo;
    public static long[] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ar = new long[n];
        memo = new long[n][n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            total += ar[i];
        }
        recursion(0, n - 1, n);
        System.out.println(memo[0][n - 1]);
    }
    public static void recursion (int left, int right, int size) {
        if (left > right || left >= size || right < 0 || left < 0 || right >= size) return;
        if (memo[left][right] != 0) return;
        if (right - left == 1) {
            memo[left][right] = Math.max(ar[left], ar[right]); return;
        }
        if (right == left) {
            memo[left][right] = ar[left]; return;
        }
        recursion(left + 1, right - 1, size); recursion(left + 2, right, size); recursion(left, right - 2, size);
        memo[left][right] = ar[left] + Math.min(memo[left + 2][right], memo[left + 1][right - 1]);
        memo[left][right] = Math.max(memo[left][right], ar[right] + Math.min(memo[left][right - 2], memo[left + 1][right - 1]));
    }
}
