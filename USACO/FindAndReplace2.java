package USACO;

import java.util.Scanner;

public class FindAndReplace2 {
    public static long l, r;
    public static int n;
    public static long[][][] dp;
    public static int[] lev;
    public static String[] rep;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextLong(); r = sc.nextLong();
        n = sc.nextInt();
        lev = new int[n + 1];
        rep = new String[n + 1];
        dp = new long[n + 1][26][3];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            lev[i] = input[0].charAt(0) - 'a';
            rep[i] = input[1];
        }
        for (int i = 0; i < 26; i++) {
            dp[n][i][0] = 1;
            dp[n][i][1] = n;
            dp[n][i][2] = i;
        }
        for (int level = n - 1; level >= 0; level--) {
            for (int i = 0; i < 26; i++) {
                if (lev[level] == i) {
                    if (rep[level].length() == 1) {
                        dp[level][i] = dp[level + 1][rep[level].charAt(0) - 'a'];
                    } else {
                        dp[level][i][1] = level;
                        dp[level][i][2] = i;
                        for (int j = 0; j < rep[level].length(); j++) {
                            dp[level][i][0] += dp[level + 1][rep[level].charAt(j) - 'a'][0];
                            if (dp[level][i][0] > r) break;
                        }
                    }
                } else {
                    dp[level][i] = dp[level + 1][i];
                }
            }
        }
        method(0, 0, 0);
        System.out.println();
    }
    public static void method (long left, int level, int character) {
        if (left + dp[level][character][0] < l || left >= r) return;
        if (level == n) {
            System.out.print((char)(character + 'a')); return;
        }
        if (dp[level][character][1] == n) {
            System.out.print((char)(dp[level][character][2] + 'a')); return;
        }
        if (lev[level] == character) {
            for (int i = 0; i < rep[level].length(); i++) {
                if (rep[level].charAt(i) - 'a' == character) {
                    method(left, (int) dp[level][character][1] + 1, character);
                    left += dp[(int) dp[level][character][1] + 1][character][0];
                } else {
                    method(left, (int) dp[level][rep[level].charAt(i) - 'a'][1], rep[level].charAt(i) - 'a');
                    left += dp[(int) dp[level][character][1]][rep[level].charAt(i) - 'a'][0];
                }
            }
        } else {
            method(left, (int) dp[level][character][1], character);
        }
    }
}
