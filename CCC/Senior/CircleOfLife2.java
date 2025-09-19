package CCC.Senior;

import java.util.Scanner;

public class CircleOfLife2 {
    public static int[] ar;
    public static boolean[][] ans;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); long t = sc.nextLong();
        ar = new int[Long.bitCount(t)];
        sc.nextLine();
        String x = Long.toBinaryString(t);
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '1') {
                ar[count++] = x.length() - i - 1;
            }
        }
        ans = new boolean[ar.length + 1][n];
        String input = sc.nextLine();
        for (int i = 0; i < n; i++) {
            ans[0][i] = input.charAt(i) != '0';
        }
        method(1, n);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[ans.length - 1][i] ? 1 : 0);
        }
        System.out.println();
    }
    public static void method(int roundNum, int mod) {
        if (roundNum > ar.length) return;
        long num = (long) ((Math.pow(2, ar[roundNum - 1]) + mod) % mod);
        for (int i = 0; i < mod; i++) {
            ans[roundNum][i] = (ans[roundNum - 1][(int) ((i - num + mod) % mod)] != ans[roundNum - 1][(int) ((i + num) % mod)]);
        }
        method(roundNum + 1, mod);
    }
}
