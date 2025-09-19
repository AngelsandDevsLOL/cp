package COCI;

import java.util.Arrays;
import java.util.Scanner;

public class Zapis {
    static long[][] dp;
    static String str;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        str = sc.nextLine();
        dp = new long[n][n];
        for (long[] row : dp) Arrays.fill(row, -1);
        long val = recursion(0, n - 1) % 100000;
        System.out.println(val);
    }
    public static int method(char l, char r) {
        if (l == '?' && r == '?') return 3;
        if ((l == '?' && (r == '}' || r == ']' || r == ')')) || (r == '?' && ((l == '{') || l == '[' || l == '('))) return 1;
        if ((l == '{' && r == '}') || (l == '[' && r == ']') || (l == '(' && r == ')')) return 1;
        return 0;
    }
    public static long recursion(int left, int right) {
        if (right <= left) return 1;
        if (dp[left][right] != -1) return dp[left][right];
        long val = 0;
        for (int s = left + 1; s <= right; s += 2) {
            val += ((recursion(left + 1, s - 1) * recursion(s + 1, right) * method(str.charAt(left), str.charAt(s))) % 100000);
        }
        dp[left][right] = val;
        return val;

    }
}
