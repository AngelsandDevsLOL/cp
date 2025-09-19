package DMOPC;

import java.util.Arrays;
import java.util.Scanner;

public class BobAndFrenchClass {
    public static long[] memo;
    public static long[] english;
    public static long[] french;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[3];
        english = new long[n + 1];
        french = new long[n + 1];
        for (int i = 0; i < n; i++) {
            french[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            english[i] = sc.nextLong();
        }
        memo[0] = english[0];
        memo[1] = french[0];
        if (n >= 2) {
            int a = (int) (Math.max(memo[0], memo[1]) + english[1]);
            memo[2] = memo[1] + french[1];
            memo[1] = memo[0] + french[1];
            memo[0] = a;
            recursion(2);
            System.out.println(Math.max(memo[0], Math.max(memo[1], memo[2])));
        } else {
            System.out.println((int)Math.max(memo[0], memo[1]));
        }
    }
    public static void recursion (int x) {
        if (x >= english.length-1) return;
        int a = (int) (Math.max(memo[0], Math.max(memo[1], memo[2])) + english[x]);
        memo[2] = memo[1] + french[x];
        memo[1] = memo[0] + french[x];
        memo[0] = a;
        recursion(x + 1);
    }
}
