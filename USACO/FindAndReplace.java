package USACO;

import java.util.Scanner;

public class FindAndReplace {
    public static long l, r;
    public static long[][][] dp;
    public static int c;
    public static int[] lev;
    public static String[] replacement;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextLong(); r = sc.nextLong();
        c = sc.nextInt();
        dp = new long[c + 1][26][2];
        sc.nextLine();
        lev = new int[c + 1];
        replacement = new String[c + 1];
        for (int i = 0; i < c; i++) {
            String[] x = sc.nextLine().split(" ");
            lev[i] = (x[0].charAt(0)) - 'a';
            replacement[i] = x[1];
        }
        for (int i = 0; i < 26; i++) {
            dp[c][i][0] = 1;
        }
        recursion(0, 0);
        search(0, 0, 0);
    }
    public static int recursion (int level, int character) {
        if (dp[level][character][0] != 0) return level;
        if (dp[level][character][1] != 0) return (int)dp[level][character][1];
        if (lev[level] != character) {
            dp[level][character][1] = recursion(level + 1, character);
            dp[level][character][0] = dp[(int)dp[level][character][1]][character][0];
            return (int)dp[level][character][1];
        }

        for (int i = 0; i < replacement[level].length(); i++) {
            dp[level][character][0] += dp[recursion(level + 1, replacement[level].charAt(i) - 'a')][replacement[level].charAt(i) - 'a'][0];
        }
        return level;
    }
    public static void search (long ll, int level, int character) {
        if (ll + dp[level][character][0] < l || ll >= r) {
            return;
        }
        if (level == c) {
            System.out.print((char)(character + 'a')); return;
        }
        if (lev[level] == character) {
            for (int i = 0; i < replacement[level].length(); i++) {
                search(ll, level + 1, replacement[level].charAt(i) - 'a');
                ll += dp[level + 1][replacement[level].charAt(i) - 'a'][0];
            }
        } else {
            search(ll, (int)dp[level][character][1], character);
        }
    }
}