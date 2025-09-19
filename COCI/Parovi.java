package COCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Parovi {
    public static long mod = (long) 1e9;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(0); return;
        }
        long totalPairs = 1; // {1, 2}
        long[] dp = new long[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            ArrayList<Integer> aList = new ArrayList<>();
            for (int j = 2; j < i; j++) {
                if (gcd(j, i) == 1) {
                    aList.add(j);
                }
            }
            totalPairs += aList.size();
            long cur = fastExp(2, aList.size());
            int count = 0;
            int prev = aList.get(0);
            for (int j = 0; j < aList.size(); j++) {
                int x = aList.get(j);
                long temp = (cur - fastExp(2, aList.size() - count) + mod) % mod;
                for (int k = prev + 1; k < x; k++) {
                    dp[i] += dp[k] * temp;
                    dp[i] %= mod;
                } // don't need the last one because n - 1 is always a prime of n
                count++;
                dp[i] += dp[x] * (cur - fastExp(2, aList.size() - count) + mod) % mod;
                dp[i] %= mod;
                prev = x;
            }
            dp[i] += fastExp(2, totalPairs);
            dp[i] %= mod;
            totalPairs++; // {1, i}
        }
        for (int i = 2; i < n; i++) {
            System.out.println(dp[i]);
        }
        System.out.println(dp[n]);
    }
    public static long fastExp (long base, long exp) {
        long ans = 1;
        while (exp > 0) {
            if ((exp | 1) == exp) {
                ans *= base;
                ans %= mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return ans;
    }
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
